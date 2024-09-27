const Module = function (id) {
  const coinArr = ['BTC','XRP', 'HEX','ETH','ADA','AAVE','YFI','XLM'];
  const colorArr = ['yellow', 'cyan', 'magenta', 'teal','silver','green','blue','orange'];
  const sizeArr = [30, 30, 30, 30, 30, 30,30,30];
  
  document.getElementById(id).innerHTML = `  
    <svg id='thisSVG'>
    </svg>  
    `;

  const svg = d3.select('#thisSVG');
  svg.style('background', 'red');

  const width = +svg.attr('width', '100%');
  const height = +svg.attr('height');

  const colorScale = d3
    .scaleOrdinal()
    .domain(coinArr)
    .range(colorArr);

  const radiusScale = d3
    .scaleOrdinal()
    .domain(coinArr)
    .range(sizeArr);

  const xPosition = (d, i) => i * 70 + 70;

  const capsule = (selection,  props ) => {
    const { modules, height } = props;

    const circles = selection.selectAll('circle')
     .data(modules); //, d => d.id);

    circles
      .enter().append('circle')
      .attr('cx', xPosition)
      .attr('cy', (height / 3)+30)
    .merge(circles) // enter+update
      // circles  // circles object IS the update function!!!!!
      .attr('r', (d) => radiusScale(d.type)) 
      .attr('fill', (d) => colorScale(d.type));

    circles.exit()
      .transition().duration(1000)
      .attr('fill', 'black')
      .transition().duration(1000)
      .attr('r', 0)
      .remove()

    const text = selection.selectAll('text')
      .data(modules);
    text
      .enter().append('text')
      .attr('x', xPosition)
      .attr('y', height / 3 +34 )
    .merge(text)  
      .text(d => d.type);  
    text.exit().remove();

    text.style('text-anchor','middle')
    .style('font-family','sans-serif')
    .style('color','darkblue')
    .style('font-size','1rem');
  };

  const render = () => {
    capsule(svg, {
      modules,
      height: +svg.attr('height'),
    });
  };

  //////////////////////////////////////

  const makeModules = (type) => ({ 
    type,
    id: Math.random()
   }); 

  let modules = d3.range(10).map(() => makeModules('BTC'));

  render();
 
  setTimeout(() => {
    console.log('hey modules', modules);
    modules.pop();
    render();
  }, 1000);

  setTimeout(() => {
    modules[1].type = 'XRP';
    render();
  }, 1500);

  setTimeout(() => {
    modules[2].type = 'ETH';
    render();
  },2000 );

  setTimeout(() => {
    modules = modules.filter((d,i) => i != 0);
    render();
  }, 2500);

  setTimeout(() => {
    modules[3].type = 'HEX';
    render();
  }, 3000);

  setTimeout(() => {
    modules[4].type = 'ADA';
    render();
  }, 3500);

  setTimeout(() => {
    modules[5].type = 'AAVE';
    render();
  }, 4000);
  setTimeout(() => {
    modules[6].type = 'YFI';
    render();
  }, 4500);
  setTimeout(() => {
    modules[7].type = 'XLM';
    render();
  }, 5000);
};

let modInstance = new Module('module');
