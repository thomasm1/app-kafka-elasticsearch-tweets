
    ////////////////////////////////////
    // UndirectedPath Graph Methods
    ////////////////////////////////////////////
export class Graphs {
    
    constructor(graphObject){
        // noOfEdges = noOfVertices - 1
        this.graph = graphObject || {
            A:['C','B'],
            B:['D'],
            C:['E'],
            D:['F'],
            E:[],
            F:[]
        }
        this.noOfVertices = Object.keys(this.graph).length;  // defaults to 6 if using default graph
        this.edgesArr = []
        this.visited = new Array(this.noOfVertices).fill(false) 
        this.resultArray = []
        for (let i = 0; i <this.noOfVertices;i++) 
            this.edgesArr.push([])       
    }

    addEdge = (src, dest) => {
        this.edgesArr[src].push(dest);   // hence, ['NodeA'] becomes ['NodeA','NodeB']
       }
    
    undirectedPath = (edgesArr, nodeA, nodeB) => {       /// retrns boolean if node coords are among node edges list
        const graph = this.buildGraph(edgesArr);
        return this.hasPath(graph, nodeA, nodeB, new Set());
    };
    
    hasPath = (graph, src, dest, visited) => {  // 
        if (visited.has(src)) return false;
        visited.add(src);
    
        for (let neighbor of graph[src]) {    /// checking object values
            if (this.hasPath(graph, neighbor, dest, visited) ===true) {
                return true;
            }
        }
        return false;
    };
    
    buildGraph = (edgesArr) =>{       // hence, ['NodeA','NodeB']                  
        const graph = {};                      /// make edge list into Adjacency List Object
    
        for (let edge of edgesArr) {
            const [a,b] = edge;
            if (!(a in graph)) graph[a] = [];
            if (!(b in graph)) graph[b] = [];
            graph[a].push(b);
            graph[b].push(a); 
        }
        return graph;         
    }
        
    /// TRAVERSALS
    depthFirstRecursion = (graph, src, print=false) =>{
        let localPrint = print;                    // <== Recursion print
        if (localPrint===true){console.log(src)}; 
        for(let neighbor of graph[src]) {
            this.depthFirstRecursion(graph, neighbor,localPrint);
        }
    }

    depthFirstIteration = (graph,src,print=false) =>{
        let stack = [src];
        while (stack.length>0){
            let current = stack.pop();
            if (print === true) {console.log(current)}

            for (let neighbor of graph[current]) {
            stack.push(neighbor);
            }
        }
    } 

    breadthFirstPrint = (graph, src, print=false) =>{   // pass in 3rd param as boolean true to print
        let queue = [src];
        while (queue.length>0) {
            let current = queue.shift(); 
            if (print === true) {console.log(current)}

            for (let neighbor of graph[current]) {  // cycle through values of obj (@ graph.current)
                queue.push(neighbor);
            }
        }
    }

    breadthFirstTraverse(src) {    // Returns Array
        // first node in traversal queue
        let queue = [src]
        this.visited[src] = true

        while(queue.length !=0){
            let current = queue.shift()  //  srcNode is current now, next look for neighbors
            console.log(current)
            for (let i = 0; i<this.edgesArr[current].length;i++){    //                                      <--------- PROBLEM
                let next = this.edgesArr[current][i] // ['nodeA','nodeB'] 
                if(!this.visited[next]){
                    // add in adjacent nodes for ccurent node:
                    queue.push(next);
                    this.visited[next] = true;
                }
            }
            this.resultArray.push(current)
        }
        return this.resultArray
    }
 

}


//// FOR UNIT TESTS
const graphUndirected = {
    a:['c','b'],
    b:['d'],
    c:['e'],
    d:['f'],
    e:[],
    f:[]
}
const graphsNew = new Graphs(graphUndirected)

const xEdges = [[0,1],[1,0],[1,2],[2,1],[0,2],[2,0]]
const x1 = 2;
const x2 = 1
const x3 = 4
console.log("True: "+ graphsNew.undirectedPath(xEdges,x1,x2));
console.log("false: "+ graphsNew.undirectedPath(xEdges,x1,x3));


graphsNew.depthFirstRecursion(graphUndirected, 'a', true) // acebdf
console.log("depthFirstRecursion_^^acebdf")

graphsNew.depthFirstIteration(graphUndirected, 'a', true);  //abdfce
console.log("depthFirstIteration_^^abdfce") 
graphsNew.depthFirstIteration(graphUndirected, 'a', false); // does not print  
console.log("^^nothing")

graphsNew.breadthFirstPrint(graphUndirected, 'a', true);  //acbedf
console.log("breadthFirst_^^acbedf") 
graphsNew.breadthFirstPrint(graphUndirected, 'a', false); // does not print  
console.log("^^nothing")


// graphsNew.breadthFirstTraverse('a');  //acbedf
// console.log("breadthFirst_^^acbedf") 
graphsNew.breadthFirstTraverse('A'); // does not print  
console.log("^^nothing")
