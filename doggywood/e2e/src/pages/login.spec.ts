
import { AppPage } from '../app.po';
import { browser, logging, element, by, ExpectedConditions } from 'protractor';
import { Alert } from 'selenium-webdriver';


describe('login page', () => {

  beforeEach(() => {
    browser.driver.get('http://localhost:4200');
  });

  it('should find page-title "CLIENT LOGIN" ', () => {

    let t = browser.driver.findElement(by.className('panel-title')).getText();
    expect(t).toEqual('CLIENT LOGIN');
  });

  it('should accept email + passoword and redirect', () => {

    browser.driver.findElement(by.css('#email')).sendKeys('userTest@gmail.com');
    browser.driver.findElement(by.css('#password')).sendKeys('password');
    browser.driver.findElement(by.css('.login')).click();


    // let abc: Alert = browser.switchTo().alert();
    // abc.accept();
    // abc.dismiss();
    // browser.driver.sleep(500);
  });

  afterEach(async () => {
    // Assert that there are no errors emitted from the browser
    const logs = await browser.manage().logs().get(logging.Type.BROWSER);
    expect(logs).not.toContain(jasmine.objectContaining({
      level: logging.Level.SEVERE,
    } as logging.Entry));
  });
});

