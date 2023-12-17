export class StringManips {
    constructor() {

    }

    customStrings(strings, ...values) {
        return values.reduce((finalString, value, index) => {
            return `${finalString}${value}${strings[index+1]}`
        }, strings[0])
    } 
// console.log(stringManips.customStrings`first 3 strings: ${var1} and middle 4 strings${var2}`) 
// first 3 strings: var1 and middle 4 strings...var2

// console.log(stringManips.customStrings`first 3 strings: ${var1} and 2nd set of 4 strings var2->${var2} , and 3rd set of strings =>: ${var3} and last 4 strings ${var4}`) 

    
    isEmbeddable(frontText, backText) {
        const frontArray = frontText.split(' ');
        const backArray = backText.split(' ');
        const backObject = {};
    
        backArray.forEach(word => {
            if (!backObject[word]) { backObject[word] = 0; }
            backObject[word]++; 
        });
    
        let isEmbeddable = true;
        frontArray.forEach(word => {
            if (backObject[word]) {              /// check if backArray has word we need in its storage bank.
                backObject[word]--;
                if (backObject[word] < 0) { isEmbeddable = false; }
            }
            // process of only eliminate 
            else { isEmbeddable = false; }
        });
        return isEmbeddable;
    }
    
    // Validate JSON with quoted keys 
    validateJSONwithQuotedKeys() {
    json_string.replace(/(\s*?{\s*?|\s*?,\s*?)(['"])?([a-zA-Z0-9]+)(['"])?:/g, '$1"$3":');
    eval('var json = new Object(' + json_string + ')');
    }
    
}

/// PULL OUT FOR UNIT TEST
const var1 = "var1"
const var2 = "var2"
const var3 = "var3"
const var4 = "var4"
const sm = new StringManips()
console.log(sm.isEmbeddable("this is in front", "this is both in the front and in the back"))
// true
console.log(sm.isEmbeddable("this is in middle", "this is both in the front and in the back"))
// false
console.log(sm.customStrings`first 3 strings: ${var1} and middle 4 strings${var2}`) 
// first 3 strings: var1 and middle 4 strings...var2
console.log(sm.customStrings`first 3 strings: ${var1} and 2nd set of 4 strings var2->${var2} , and 3rd set of strings =>: ${var3} and last 4 strings ${var4}`) 
