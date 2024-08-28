// Undirected & Directed Braphs
// Breadth-first Search
console.log(
    "%c GRAPHS, Breadth-First Search: ",
    "color:white; background-color:darkblue"
  );
  function breadthSearch(graph, root) {
    var nodesLength = {};
    for (var i = 0; i < graph.length; i++) {
      nodesLength[i] = Infinity;
    }
    nodesLength[root] = 0;
  
    var queue = [root];
    var current;
  
    while (queue.length !== 0) {
      current = queue.shift();
  
      var curConnected = graph[current];
      var neighborIdx = [];
      var idx = curConnected.indexOf(1);
      while (idx !== -1) {
        neighborIdx.push(idx);
        idx = curConnected.indexOf(1, idx + 1);
      }
      for (var j = 0; j < neighborIdx.length; j++) {
        if (nodesLength[neighborIdx[j]] === Infinity) {
          nodesLength[neighborIdx[j]] = nodesLength[current] + 1;
          queue.push(neighborIdx[j]);
        }
      }
    }
    return nodesLength;
  }
  var newBreadthGraph = [
    [0, 1, 1, 1, 0],
    [0, 0, 1, 0, 0],
    [1, 1, 0, 0, 0],
    [0, 0, 0, 1, 0],
    [0, 1, 0, 0, 0]
  ];
  console.log(breadthSearch(newBreadthGraph, 1));
  // Undirected & Directed Braphs
  console.log(
    "%c GRAPHS, Adjacency Lists: ",
    "color:white; background-color:darkblue"
  );
  console.log(
    "%c Undirected Graph: ",
    "color:darkblue; background-color:aliceblue"
  );
  // Adjacency List
  var undirectedGraph = {
    NodeA: ["NodeB"],
    NodeB: ["NodeA", "NodeC"],
    NodeC: ["NodeB"],
    NodeD: ["NodeA", "NodeC", "NodeD"]
  };
  console.log(
    "NodeA",
    undirectedGraph.NodeA,
    "NodeB: ",
    undirectedGraph.NodeB,
    "NodeC",
    undirectedGraph.NodeC,
    "NodeD",
    undirectedGraph.NodeD
  );
  console.log(
    "%c Undirected Graph Arr:",
    "color:darkblue; background-color:aliceblue"
  );
  var undirectedGraphArray = {
    NodeA: [1],
    NodeB: [0, 2],
    NodeC: [1],
    NodeD: [0, 1, 2]
  };
  console.log(
    "NodeA",
    undirectedGraphArray.NodeA,
    "NodeB: ",
    undirectedGraphArray.NodeB,
    "NodeC",
    undirectedGraphArray.NodeC,
    "NodeD",
    undirectedGraphArray.NodeD
  );
  
  console.log(
    "%c Adjacency Matrix: ",
    "color:darkblue; background-color:aliceblue"
  );
  var adjacencyMatrix = [[0, 1, 0], [1, 0, 1], [0, 1, 0]];
  console.log(adjacencyMatrix);
  
  console.log(
    "%c Incidence Matrix: ",
    "color:darkblue; background-color:aliceblue"
  );
  var incidenceMatrixDir = [
    [1, 0, -1, 1],
    [-1, 1, 0, 0],
    [0, -1, 1, 0],
    [0, 0, 0, -1]
  ];
  console.log(incidenceMatrixDir);
  