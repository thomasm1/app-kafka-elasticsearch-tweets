

export class GraphingTools {
    // constructor can be called empty, or with 1 dataObject holding all, or separately
    // separately using javascript SPREAD/REST operators....
    constructor(dataObject, arr1d,arr2d, arrAdjacencyList, arrAdjacencyMatrix, arr3d) {

        this.dataObj = dataObject || { 
                                        arr1d:[],
                                        arr2d:[[]],
                                        arrAdjacencyList:[[]],
                                        arrAdjacencyMatrix:[[]],
                                        arr3d:[[[]]]
        };
        this.arr1d = arr1d || [];
        this.arr2d = arr2d || [[]];

        // Adjacency List : less space complexity (in sparse graphs)
        //                  : faster iteration over all edges
        //                 : Slower to lookup edge
        this.adjacencyList = [
            [1,5],       // 'A' reached at index i  etc...
            [0,2],       // 'B' reached at index i  etc...
            [1,3],       // 'C' reached at index i  etc...
            [2,4],       // 'D' reached at index i  etc...
            [3,5],       // 'E' reached at index i  etc...
            [4,0]       // 'F' reached at index i  etc...
        ]
        this.adjacencyMatrix =  [
                      //   A, B, C, D, E, F 
                          [0, 1, 0, 0, 0, 1],   // A  
                          [1, 0, 1, 0, 0, 0],    // B 
                          [0, 1, 0, 1, 0, 0],   // C  
                          [0, 0, 1, 0, 1, 0],   // D
                          [0, 0, 0, 1, 0, 1],  // E 
                          [1, 0, 0, 0, 1, 0],     // F  
        ]
        // Adjacency Matrix : More space complexity (in sparse graphs)
        //                  : Slower iteration over all edges
        //                 : Faster to lookup edge
        
        this.arrAdjacencyMatrix = arr2d || [
                          //   A, B, C, D, E, F, G.  ..
                         [0, 3, 5, 6, 0, 8, 0],      // A  
                         [3, 0, 0, 4, 2, 0, 5],     // B 
                         [5, 0, 0, 0, 0, 4, 0],   // C  
                         [6, 4, 0, 0, 0, 1, 6],   // D 
                         [0, 2, 0, 0, 0, 0, 10], // E 
                         [8, 0, 6, 1, 0, 0, 8],    // F 
                         [0, 8, 0, 6, 10, 8, 0]  // G 
                                ];


        this.arr3d = arr3d || [
            [
                [0, 3, 5, 6, 0, 8, 0],
                [3, 0, 0, 4, 2, 0, 5],
                [5, 0, 0, 0, 0, 4, 0],
                [6, 4, 0, 0, 0, 1, 6],
                [0, 2, 0, 0, 0, 0, 10],
                [8, 0, 6, 1, 0, 0, 8],
                [0, 8, 0, 6, 10, 8, 0]
                                    ],[
                                        [0, 3, 5, 6, 0, 8, 0],
                                        [3, 0, 0, 4, 2, 0, 5],
                                        [5, 0, 0, 0, 0, 4, 0],
                                        [6, 4, 0, 0, 0, 1, 6],
                                        [0, 2, 0, 0, 0, 0, 10],
                                        [8, 0, 6, 1, 0, 0, 8],
                                        [0, 8, 0, 6, 10, 8, 0]
                                    ]
        ] 
    } 
}
const graphingTools = new GraphingTools();

console.log(graphingTools)
console.log(graphingTools.dataArray)
console.log(graphingTools)