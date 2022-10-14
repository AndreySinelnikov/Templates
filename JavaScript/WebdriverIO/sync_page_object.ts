class PageObject {
  // Elements
  //--------------------------------------------------------------------------------------------------------------------
  get uniquePageElement(): WebdriverIO.Element {
    const elem = $('unique-selector');
    elem.waitForDisplayed(); // safety waits are built into getters
    return elem;
  }

  get firstElement(): WebdriverIO.Element {
    const elem = $$('multiple-result-selector')[0];
    elem.waitForDisplayed();
    return elem;
  }
  
  get elementByText(): WebdriverIO.Element {
    const elem = $("//*[.='Text']");
    elem.waitForDisplayed();
    return elem;
  }
  
  get elementContainingText(): WebdriverIO.Element {
    const elem = $("//p[contains(text(), 'Text substring')]");
    elem.waitForDisplayed();
    return elem;
  }

  // Actions
  //--------------------------------------------------------------------------------------------------------------------
  actionEncompassingMultipleElements(): void {
    this.uniquePageElement.scrollIntoView();
    this.firstElement.click();
  }

  // Assertions
  //--------------------------------------------------------------------------------------------------------------------
  expectElementContainsText(text: string): void {
    expect(this.uniquePageElement).toHaveTextContaining(text);
  }
}

export default new PageObject();
