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
    this.uniquePageElement.moveTo();
    this.firstElement.click();
  }
  
  callMethodForEachArrayElement(): void {
    $$('multiple-result-selector').forEach((elem) => {
      elem.waitForExist();
    });
  }

  // Assertions
  //--------------------------------------------------------------------------------------------------------------------
  expectElementContainsText(text: string): void {
    expect(this.uniquePageElement).toHaveTextContaining(text);
  }
  
  expectSuccessMessage(): void {
    expect(this.successMessage.isExisting()).toBeTruthy();
  }
  
  // Actions with hacks

  actionWithHacks(): void {
    // скрытие элемента, перехватывающего клик
    const hideElem = this.uniquePageElement;
    browser.execute((hideElem) => {
      hideElem.style.display = 'none';
    }, hideElem);

    // кликаем в правый нижний угол элемента, чтобы обойти ещё одно перехватывание
    const xoffset = Math.trunc(this.firstPhoto.getSize('width') / 2) - 1;
    const yoffset = Math.trunc(this.firstPhoto.getSize('height') / 2) - 1;
    this.firstElement.click({ x: xoffset, y: yoffset });
  }
}

export default new PageObject();
