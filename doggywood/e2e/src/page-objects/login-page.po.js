'use strict';

let AngularPage = function () {
  browser.get('http://localhost:4200');
};

 AngularPage.prototype = Object.create({}, {
    loginButton: { get: function () { return element(by.id('login')); }},
    loginPage: { get: function () { return element(by.css('.list-header-title')); }},
    // yourName: { get: function () { return element(by.model('yourName')); }},
    // greeting: { get: function () { return element(by.binding('yourName')).getText(); }},
    // todoList: { get: function () { return element.all(by.repeater('todo in todos')); }},
    // typeName: { value: function (keys) { return this.yourName.sendKeys(keys); }},
    // todoAt: { value: function (idx) { return this.todoList.get(idx).getText(); }},
    // addTodo: { value: function (todo) {
    // this.todoText.sendKeys(todo);
    // this.addButton.click();
  // }}
});

module.exports = AngularPage;