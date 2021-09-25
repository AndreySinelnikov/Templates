pm.test("Your test name", function () {
    var jsonData = pm.response.json();
    var actualValue = pm.collectionVariables.get("actualValue"); // get request path variable
    pm.expect(jsonData.value).to.eql(actualValue);
});
