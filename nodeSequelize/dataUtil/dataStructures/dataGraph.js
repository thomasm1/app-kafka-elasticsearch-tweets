// Undirected & Directed Braphs
// Breadth-first Search
console.log(
    "%c GRAPHS, Breadth-First Search: ",
    "color:white; background-color:darkblue"
  );
  export function breadthSearch(graph, root) {
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


  export const testBreadthGraph = [
    [0, 1, 1, 1, 0],
    [0, 0, 1, 0, 0],
    [1, 1, 0, 0, 0],
    [0, 0, 0, 1, 0],
    [0, 1, 0, 0, 0]
  ];
  console.log(breadthSearch(testBreadthGraph, 1));
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
export const testUndirectedGraph = {
    NodeA: ["NodeB"],
    NodeB: ["NodeA", "NodeC"],
    NodeC: ["NodeB"],
    NodeD: ["NodeA", "NodeC", "NodeD"]
  };
  console.log(
    "NodeA",
    testUndirectedGraph.NodeA,
    "NodeB: ",
    testUndirectedGraph.NodeB,
    "NodeC",
    testUndirectedGraph.NodeC,
    "NodeD",
    testUndirectedGraph.NodeD
  );
  console.log(
    "%c Undirected Graph Arr:",
    "color:darkblue; background-color:aliceblue"
  );
  export const testUndirectedGraphArray = {
    NodeA: [1],
    NodeB: [0, 2],
    NodeC: [1],
    NodeD: [0, 1, 2]
  };
  console.log(
    "NodeA",
    testUndirectedGraphArray.NodeA,
    "NodeB: ",
    testUndirectedGraphArray.NodeB,
    "NodeC",
    testUndirectedGraphArray.NodeC,
    "NodeD",
    testUndirectedGraphArray.NodeD
  );
  
  console.log(
    "%c Adjacency Matrix: ",
    "color:darkblue; background-color:aliceblue"
  );
export const testAdjacencyMatrix = [[0, 1, 0], [1, 0, 1], [0, 1, 0]];
  console.log(testAdjacencyMatrix);
  
  console.log(
    "%c Incidence Matrix: ",
    "color:darkblue; background-color:aliceblue"
  );
export const testIncidenceMatrixDir = [
    [1, 0, -1, 1],
    [-1, 1, 0, 0],
    [0, -1, 1, 0],
    [0, 0, 0, -1]
  ];
  console.log(testIncidenceMatrixDir);
  