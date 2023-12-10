var inputString = "";

function updateString(value) { 
    inputString += value; 
    document.forms[1].input.value = inputString; 
}

const innerform = document.querySelector("#calc");
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
    <input type="button" name="clear" id="bu" value="C" onclick="document.forms[1].input.value='';inputString=''" /> 
    <input type="button" name="minus" id="bu" value="-" onclick="updateString('-')" />
    <br />
    <br />
    
    <input type="button" name="openparenth" id="bu" value="(" onclick="updateString('(')" /> 
    <input type="button" name="closeparenth" id="bu" value=")" onclick="updateString(')')" /> 
    <input type="button" name="power" id="bu" value="**" onclick="updateString('**')" />  
    <input type="button" name="modulus" id="bu" value="%" onclick="updateString('%')" />
   
    <br />
    <br />
    
    <input type="button" style="background-color:blue;color:white;" name="calc" id="bu" value="=" onclick="document.forms[1].input.value = eval(inputString); inputString=''"
    /> 
    <input type="button" name="mem" id="bu" value="M +" onclick="document.forms[1].storedValue.value = parseInt(document.forms[1].storedValue.value) + parseInt(document.forms[1].input.value)"
    /> 
    <input type="button" name="recall" id="bu" value="MRC" onclick="updateString(document.forms[1].storedValue.value)" /> 
    <input type="button" name="memClear" id="bu" value="MC" onclick="document.forms[1].storedValue.value=0" /><br /> 
    <input type="hidden" name="storedValue" value="0" /> 
    <input id="window" type="text" size="40" name="input" />
     
    </form> 
    <!-- Calculator Deux -->
    <div id="innerform2"></div>
    `;
