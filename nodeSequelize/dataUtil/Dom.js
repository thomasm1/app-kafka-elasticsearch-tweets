
    ////////////////////////////////////
    // DOM Methods
    ////////////////////////////////////////////
    export class DOM {
    
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
    }

    export function addGlobalEventListener( 
type, 
selector, 
callback, 
options, 
parent = document
    ) {
        parent.addEventListener(
            type,
            e => {
                if (e.target.matches(selector)) callback(e)
            }, 
            options
        )
    }

    export function qs(selector, parent = document) {
        return parent.querySelector(selector)
    }
    export function qsa(selector, parent = document ) {
        return [ ...parent.querySelectorAll(selector)] //  Take result and Spread into result
    } 

    export function createElement(type, options = {}) {
        const element = document.createElement(type)
        Object.entries(options).forEach(([key, value]) => {
            if (key==="class"){
                element.classList.add(value)
                return 
            }
            if (key === "dataset") {
                Object.entries(value).forEach(([dataKey, dataValue]) => {
                    eleement.dataset[dataKey] = dataValue
                })
            return
            }
            if (key === "text") {
                element.textContent = value
                return
            }
            element.setAttribute(key, value)
        })
        return element
    }


    



