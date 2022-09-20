//require('home_page.js');
 
describe('Testing a groot adoption flow using page object', function() {
     
    beforeEach(function() {
        browser.get('http://localhost:4200');
    });
     
    var home_page = require('./pages/home_page.js');
    it ('Should be able to adopt a groot by page object', function() {
        home_page.enterName('Blabla');
        expect(home_page.getDynamicText()).toBe('Blabla');
        var groot_page = home_page.clickContinue();
         
        groot_page.selectGroot(1);
        var confirm_page = groot_page.clickContinue();
         
        expect(confirm_page.getTitle()).toContain('Thank');
    });
});