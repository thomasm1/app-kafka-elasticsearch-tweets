// Calculating: 
//      A   3   B
//   5   6     4   2 
// C        D        E
//    (8)      (5)
//   4   1     6   10 
//      F   8    G  
 

import  {SortingTools}   from "./SortingTools.js";
// adjacencyMatrix = [
//     [0, 3, 5, 6, 0, 8, 0],
//     [3, 0, 0, 4, 2, 0, 5],
//     [5, 0, 0, 0, 0, 4, 0],
//     [6, 4, 0, 0, 0, 1, 6],
//     [0, 2, 0, 0, 0, 0, 10],
//     [8, 0, 6, 1, 0, 0, 8],
//     [0, 8, 0, 6, 10, 8, 0]
// ] ; 


let tool = new SortingTools();
const adjacencyMatrix = tool.adjacencyMatrix;

dijkstra(adjacencyMatrix)

function dijkstra(Matrix){
    var v = Matrix.length;
    var visited = new Array(v);
    var distance = new Array(v).fill(Number.MAX_SAFE_INTEGER);

    //start 
    distance[0] = 0;

    for (let i=0;i < v-1; i++){                                  // 1 less not including start
        let minVertex = findMinVertex(distance, visited);
        visited[minVertex]  = true;

        for(let j=0; j<v ; j++){
            if(Matrix[minVertex][j] !=0 && !visited[j]){
                let newDist = distance[minVertex]+ Matrix[minVertex][j]

                if (newDist<distance[j]){
                    distance[j] = newDist;
                }
            }
        } 
    } 
    for(let i=0; i<v ;i++){
        console.log(i+""+distance[i])
    }
} 
function findMinVertex(distance, visited){
    let minVertex = -1;
    for (let i=0; i<distance.length; i++){
        if(!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex] )){
            minVertex=i;
        }
    }
    return minVertex;
}