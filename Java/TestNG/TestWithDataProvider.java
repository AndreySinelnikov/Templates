@DataProvider(name = "testData")
public Object[][] dataProviderMethodName() {
    return new Object[][] {
        {"First test", "Some string", 0},
        {"Second test", "Some other string", 1},
    };
}

@Test(dataProvider = "testData")
public void testOperatingOnData(String testId, String text, int number) {
    // testLogic
}

// testId is not used in test body; it serves to describe an individual row of test data

// note that test data array elements can be of reference type: you can cycle through, for example, Page Object fields that way
