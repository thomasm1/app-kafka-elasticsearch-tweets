class SketchPad {
    constructor(container, size=400) {
        this.canvas=document.createElement("canvas");
        this.canvas.width=size;
        this.canvas.height=size;
        this.canvas.style=`
            background-color:white;
            box-shadow: 0px 0px 10px 2px black;
            `;
        container.appendChild(this.canvas);

        const lineBreak=document.createElement("br");
        container.appendChild(lineBreak);
        this.undoBtn=document.createElement("button");
        this.undoBtn.innerHTML="UNDO";
        container.appendChild(this.undBtn);

        this.ctx=this.canvas.getContext("2d");
        this.paths=[]; // 2d array
        this.isDrawing=false;
        this.#redraw();
        
        this.#addEventListeners();
    }

    #addEventListeners(){
        this.canvas.onmousedown=(evt)=>{
            const mouse = this.#getMouse(evt);
            this.path.push([mouse]);
            this.isDrawing=true;
        }
        this.canvas.onmousemove=(evt)=>{
            if(this.isDrawing){
            const mouse = this.#getMouse(evt);
            const lastPath=this.paths[this.paths.length-1];
            lastPath.push(mouse);
            this.#redraw();
            }
        }
        this.canvas.onmouseup=()=>{
            this.isDrawing=false;
        }
        this.canvas.ontouchstart=(evt)=>{
            const loc=evt.touches[0];
            this.canvas.onmousedown(loc);
        }
        this.canvas.ontouchmove=(evt)=>{
            const loc=evt.touches[0];
            this.canvas.onmousemove(loc);
        }
        
        this.canvas.ontouchend=()=>{
            this.canvas.onmouseup();
        }
        this.undoBtn.onclick=()=>{
            this.paths.pop();
            this.#redraw();
        }
    }
    #redraw(){
        this.ctx.clearRect(0,0,
            this.canvas.width, this.canvas.height);
        draw.paths(this.ctx, this.paths);
        
    }

    #getMouse=(evt)=>{
        const rect=this.canvas.getBoundingClientRect();
        return [
            Math.round(evt.clientX-rect.left),
            Math.round(evt.clientY-rect.top)                
        ];
    }
}