var inputString = "";

function updateString(value) { 
    inputString += value; 
    document.forms[0].input.value = inputString; 
}

var innerform = document.querySelector("#calc");
// calculator style
innerform.style.border = 'solid 5px grey';
innerform.style.margin = '0 10%'
innerform.style.padding = '5%'

innerform.innerHTML = `
    <form id="innerform" action=""> 
    <input type="button" name="seven" id="bu" value="7" onclick="updateString('7')" /> 
    <input type="button" name="eight" id="bu" value="8" onclick="updateString('8')" /> 
    <input type="button" name="nine" id="bu" value="9" onclick="updateString('9')" /> 
    <input type="button" name="div" id="bu" value="/" onclick="updateString('/')" />
    <br />
    <br />
    
    <input type="button" name="four" id="bu" value="4" onclick="updateString('4')" /> 
    <input type="button" name="five" id="bu" value="5" onclick="updateString('5')" /> 
    <input type="button" name="six" id="bu" value="6" onclick="updateString('6')" />  
    <input type="button" name="mult" id="bu" value="*" onclick="updateString('*')" />
    <br />
    <br />
    
    <input type="button" name="one" id="bu" value="1" onclick="updateString('1')" /> 
    <input type="button" name="two" id="bu" value="2" onclick="updateString('2')" /> 
    <input type="button" name="three" id="bu" value="3" onclick="updateString('3')" /> 
    <input type="button" name="plus" id="bu" value="+" onclick="updateString('+')" />
     <br />
    <br />
    
    <input type="button" name="zero" id="bu" value="0" onclick="updateString('0')" /> 
    <input type="button" name="dot" id="bu" value="." onclick="updateString('.')" /> 
    <input type="button" name="clear" id="bu" value="C" onclick="document.forms[0].input.value='';inputString=''" /> 
    <input type="button" name="minus" id="bu" value="-" onclick="updateString('-')" />
    <br />
    <br />
    
    <input type="button" name="openparenth" id="bu" value="(" onclick="updateString('(')" /> 
    <input type="button" name="closeparenth" id="bu" value=")" onclick="updateString(')')" /> 
    <input type="button" name="power" id="bu" value="^" onclick="updateString('^')" />  
    <input type="button" name="modulus" id="bu" value="%" onclick="updateString('%')" />
   
    <br />
    <br />
    
    <input type="button" style="background-color:blue;color:white;" name="calc" id="bu" value="=" onclick="document.forms[0].input.value = eval(inputString); inputString=''"
    /> 
    <input type="button" name="mem" id="bu" value="M +" onclick="document.forms[0].storedValue.value = parseInt(document.forms[0].storedValue.value) + parseInt(document.forms[0].input.value)"
    /> 
    <input type="button" name="recall" id="bu" value="MRC" onclick="updateString(document.forms[0].storedValue.value)" /> 
    <input type="button" name="memClear" id="bu" value="MC" onclick="document.forms[0].storedValue.value=0" /><br /> 
    <input type="hidden" name="storedValue" value="0" /> 
    <input id="window" type="text" size="40" name="input" />
     
    </form> 
    <!-- Calculator Deux -->
    <div id="innerform2"></div>
    `;

//////////////////////////////////////////////////////////
            // CALCULATOR2 //
/**
 * Calculator function constructor.
 * @constructor
 */
function Calculator() {
  this.total = 0;
}

/**
 * Adds value to current total. 
 * @param {number} number
 * @returns {*}
 */
Calculator.prototype.add = function (number) {
  return this.total += number;
};

/**
 * Subtracts number from current total. 
 * @param {number} number
 * @returns {*}
 */
Calculator.prototype.subtract = function (number) {
  return this.total -= number;
};

/**
 * Multiplies value to current total. 
 * @param {number} number
 * @returns {*}
 */
Calculator.prototype.multiply = function (number) {
  return this.total *= number;
};

/**
 * Divides value to current total. 
 * @param {number} number
 * @returns {*}
 */

Calculator.prototype.divide = function (number) {
  if (number === 0) {
    throw new Error('Cannot divide by zero');
  }

  return this.total /= number;
};

/**
 * Modulus value to current. 
 * @param {number} number
 * @returns {%}
 */
Calculator.prototype.modulus = function (number) {
  return this.total % number;
}

//////////////////////////////////////////////////////////
            // RESULTS //

/**
 * Calculates result for a simple mathematical expression.
 *
 * @param {string} inputValue
 */
function calculate(inputValue) {
  const expression = /\+|\-|\*|\/|\%/;
  const numbers = inputValue.split(expression);

  const numberA = parseInt(numbers[0]);
  const numberB = parseInt(numbers[1]);

  const operation = inputValue.match(expression);

  if (Number.isNaN(numberA) || Number.isNaN(numberB) || operation === null) {
    updateResult('Expression not recognized: must have 2 nums & an operator');
    return;
  }

  const calculator = new Calculator();
  calculator.add(numberA);

  let result;
  switch(operation[0]) {
    case '+':
      result = calculator.add(numberB);
      break;
    case '-':
      result = calculator.subtract(numberB);
      break;
    case '*':
      result = calculator.multiply(numberB);
      break;
    case '/':
      result = calculator.divide(numberB);
      break;
    case '%':
      result = calculator.modulus(numberB);
      break;
    default:
      result = 'Operation not recognized: must be +,-,*,/,%';
  }

  updateResult(result);
}

/**
 * Updates result in DOM element.
 * @param {string} result
 */
function updateResult(result) {
  const element = document.querySelector('#result-calculator');

  if (element) {
    element.innerText = result;
  }
}


var innerform2 = document.querySelector("#innerform2");
innerform2.innerHTML = ` 
<hr>
<div>
<style>
.title-calculator, h4 {
  color:gold; 
}
input.input {
  max-width:90%;
}
span#result-calculator {
  border:inset 1px white;
  min-width:100px;
  padding:3px 5px;
  color:gold;
}
</style>
<h4>Calculator Deux</h4>
 <input
    class="input"
    type="text"
    title="calculator"
    placeholder="Enter operation"
    value=""
    onchange="calculate(this.value)"
  />

  <div class="result-container">
    <div class="title-calculator">Result</div>
    <span id="result-calculator"></span>
  </div>
  </div>
    `;