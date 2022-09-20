
import { AppPage } from '../app.po';
import { browser, logging, element, by, ExpectedConditions } from 'protractor';
import { Alert } from 'selenium-webdriver';


describe('client landing page', () => {

  beforeEach(() => {
    browser.driver.get('http://localhost:4200/clients/54');  // HARD - CODED Test User number must dynamic
  });

  it('should find page-title "CLIENT LANDING " "+ ADD-PET BUTTON" ', () => {

    let t = browser.driver.findElement(by.className('panel-title')).getText();
    expect(t).toContain('Welcome');     // Best to add dynamic name of client
  });

  // it('should contain Add Pet Option', () => {

  //   let t = browser.driver.findElement(by.className('pet-create')).getText();
  //   expect(t).toEqual('Add Pet');
  //   // browser.driver.sleep(500);
  // });

  afterEach(async () => {
    // Assert that there are no errors emitted from the browser
    const logs = await browser.manage().logs().get(logging.Type.BROWSER);
    expect(logs).not.toContain(jasmine.objectContaining({
      level: logging.Level.SEVERE,
    } as logging.Entry));
  });
});

