

export class SortingTools {

    constructor(data) {

        //properties
        this.data = data;
        this.adjacencyMatrix = [
            [0, 3, 5, 6, 0, 8, 0],
            [3, 0, 0, 4, 2, 0, 5],
            [5, 0, 0, 0, 0, 4, 0],
            [6, 4, 0, 0, 0, 1, 6],
            [0, 2, 0, 0, 0, 0, 10],
            [8, 0, 6, 1, 0, 0, 8],
            [0, 8, 0, 6, 10, 8, 0]
        ] ; 

    }
 
}
    


