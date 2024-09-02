class CalculateCard extends HTMLElement {
    constructor(){
        super();
        this.innerHTML = `<h1>Calculated Component`
    }
}
window.customElements.define('calculate-card', CalculateCard);