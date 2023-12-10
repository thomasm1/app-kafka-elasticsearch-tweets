	var width = 280;
	var height = 280;
	var radius = Math.min(width, height) / 2;
	var donutWidth = 75;
	var legendRectSize = 12;
	var legendSpacing = 4;

	var color = d3.scaleOrdinal(["#0000ff", "#ff0000", "#00ff00", "#cc6633", "#ff9933", "#ffcc66"]);
	//var color = d3.scaleOrdinal(d3.schemeCategory20b);

	var svg = d3.select('#svg-' + stattype + '-eurpiechart')
		.append('svg')
		.attr('width', width)
		.attr('height', height)
		.append('g')
		.attr('transform', 'translate(' + (width / 2) +
			',' + (height / 2) + ')');

	var arc = d3.arc()
		.innerRadius(radius - donutWidth)
		.outerRadius(radius);

	var pie = d3.pie()
		.value(function (d) {
			return d.count;
		})
		.sort(null);

	var pietool = d3.select("body").append("div")
		.attr("class", "pietooltip")
		.style("opacity", 100);

	d3.csv('//www.quantigy.com/rest-api/eur-ratio2.php?type=' + stattype + '&location=' + location, function (error, dataset) {
		dataset.forEach(function (d) {
			d.count = +d.count;
		});

		var path = svg.selectAll('path')
			.data(pie(dataset))
			.enter()
			.append('path')
			.attr('d', arc)
			.attr('fill', function (d, i) {
				return color(d.data.label);
			});

		//tooltip trigger
		path.on('mousemove', function (d) {
			var total = d3.sum(dataset.map(function (d) {
				return d.count;
			}));
			var percent = Math.round(1000 * d.data.count / total) / 10;
			pietool
			//.transition()
			//.duration(200)
				.style("opacity", .9)
				.style("left", (d3.event.pageX) + "px")
				.style("top", (d3.event.pageY - 28) + "px")
				.html((d.data.label) + "<br>" + percent + '%');
		});
		path.on('mouseout', function () {
			pietool
			//.transition()
			//.duration(500)
				.style("opacity", 0);
		});

		var legend = svg.selectAll('.legend')
			.data(color.domain())
			.enter()
			.append('g')
			.attr('class', 'legend')
			.attr('transform', function (d, i) {
				var height = legendRectSize + legendSpacing;
				var offset = height * color.domain().length / 2;
				var horz = -3 * legendRectSize;
				var vert = i * height - offset;
				return 'translate(' + horz + ',' + vert + ')';
			});

		legend.append('rect')
			.attr('width', legendRectSize)
			.attr('height', legendRectSize)
			.style('fill', color)
			.style('stroke', color);

		legend.append('text')
			.attr('x', legendRectSize + legendSpacing)
			.attr('y', legendRectSize - legendSpacing)
			.style('font-size', '10px')
			.text(function (d) {
				return d;
			});
	});
