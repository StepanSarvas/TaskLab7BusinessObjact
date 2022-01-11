package businessObject;

import org.testng.asserts.SoftAssert;

public class TestAssertion {
    public void assertCorrectPrice(String priceValidation, AddingToBucket addingToBucket){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(addingToBucket.getBucketSum(), Integer.parseInt(priceValidation));
        softAssert.assertAll();
    }
}
