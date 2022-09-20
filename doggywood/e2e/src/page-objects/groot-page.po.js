
require('./groot_page.js');
 
var home_page = function() {
     
    this.nameTextBox = element(by.model('person.name'));
    this.dynamicText = element(by.binding('person.name'));
    this.continueButton = element(by.buttonText('CONTINUE'));
     
    this.enterName = function(name) {
        this.nameTextBox.sendKeys(name);
    };
     
    this.getDynamicText = function() {
        return this.dynamicText.getText();
    };
     
    this.clickContinue = function() {
        this.continueButton.click();
        return require('./groot_page.js');
    };
};