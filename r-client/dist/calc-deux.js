
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
 * @returns {/}
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
  return this.total %= number;
}

/**
 * Divides value to current total. 
 * @param {number} number
 * @returns {^}
 */ 
Calculator.prototype.exponentiate = function (number) { 
  this.total = Math.pow(this.total,number);
  return this.total 
};

//////////////////////////////////////////////////////////
            // RESULTS //

/**
 * Calculates result for a simple mathematical expression.
 *
 * @param {string} inputValue
 */
function calculate(inputValue) {
  const expression = /\+|\-|\*|\/|\%|\^/;
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
    case '^' :
      result = calculator.exponentiate(numberB);
      break;
    default:
      result = 'Operation not recognized: must be +,-,*,/,%,^';
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