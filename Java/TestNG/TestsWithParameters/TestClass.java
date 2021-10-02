public class TestClass {

  // Parameters specified in xml used to launch tests in this class
  @Parameters({"firstParameter", "secondParameter"})
  @Test
  public void testWithParameters(String firstParameter, String secondParameter) {
      // testLogic
  }
  
  // Can be used for setups etc.
  
  @Parameters({"firstParameter", "secondParameter"})
  @BeforeClass
  public void setUp(String firstParameter, String secondParameter) {
      // setupLogic
  }
  
  // You may set optional values for parameters that can be absent in XML file (note how there is no 'thirdParameter' in xml for this class)
  @Parameters({"firstParameter", "secondParameter", "thirdParameter"})
  @Test
  public void testWithOptionalParameters(String firstParameter, String secondParameter, @Optional("defaultOptionalValue") String thirdParameter) {
      // testLogic
  }

}

