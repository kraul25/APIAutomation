package steps;

import Utils.JsonPathImplementation;
import cucumber.api.java.en.And;
import org.junit.Assert;

/**
 * Created by Raul on 5/7/18.
 */
public class DetailsJsonSteps extends JsonPathImplementation {

    @And("^I verify (.*) should be equal to (.*)$")
    public void iVerifyStringEquals(String element, String expectedResult) throws Throwable {
        String ActualResult = getJsonPathForString(element);
        Assert.assertEquals(expectedResult, ActualResult);
    }

    @And("^Verify (.*) should be (.*)$")
    public void VerifyBoolean(String element, String expectedResult) throws Throwable {
        boolean ActualResult = getJsonPathForBoolean(element);
        if (expectedResult.equals("true")) {
            Assert.assertTrue(ActualResult);
        } else {
            Assert.assertFalse(ActualResult);
        }
    }

    @And("^I verify (.*) should contain (.*)$")
    public void iVerifyStringContains(String element, String expectedResult) throws Throwable {
        String ActualResult = getJsonPathForString(element);
        Assert.assertTrue(ActualResult.contains(expectedResult));
    }

}
