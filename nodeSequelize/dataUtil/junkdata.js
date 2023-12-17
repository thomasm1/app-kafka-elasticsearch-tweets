(function() {
    const coins = [
        {"name":"bitcoin","price":4300,"recent":3330},
        {"name":"ethereum","price":2332,"recent":3330},
        {"name":"chainlink","price":25.00,"recent":3330} 
        ]
        let dim = {
          "width":720,
          "height":500,
          "margin":50
        };
        let svg = d3.select('#chart').append('svg').attr(dim)
        document.querySelector("#chart").classList.add("center")
    
        let scaleX = d3.scaleBand()
        .domain(coins.map(d=>d.name))
        .range([dim.margin, dim.width-dim.margin])
        .padding(0,1)
        .round(true); 
        
        let scaleY = d3.scaleLinear()
        .domain([0,d3.max(coins, d = d.price-d.recent)])
        .nice()
        .range([dim.height-dim.margin, dim.margin])
        .interpolate(d3.interpolateRound);
    
        let color = d3.scaleSequential()
        .domain([0,d3.max(coins, d = d.price-d.recent)])
        .interpolator(d3.interpolateBlues);
    
        let axisX = d3.axisBottom(scaleX);
        let axisY = d3.axisLeft(scaleY);
    
        svg.append('g')
        .data(coins)
        .enter()
        .append('rect')
        .attrs({
          'x':(d) => scaleX(d.name),
          'y':(d) => scaleY(d.price-d.recent)
        })
})();
 