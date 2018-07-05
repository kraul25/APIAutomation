package steps;

import cucumber.api.java.en.And;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

/**
 * Created by Raul on 5/7/18.
 */
public class DetailsJsonSteps {
    BaseSteps baseSteps;

    @And("^I verify (.*) should be equal to (.*)$")
    public void iVerifyStringEquals(String element, String expectedResult) throws Throwable {
        JsonPath jsonPathEvaluator = baseSteps.response.jsonPath();
        String ActualResult = jsonPathEvaluator.get(element);
        Assert.assertEquals(expectedResult, ActualResult);
    }

    @And("^Verify (.*) should be (.*)$")
    public void VerifyBoolean(String element, String expectedResult) throws Throwable {
        JsonPath jsonPathEvaluator = baseSteps.response.jsonPath();
        boolean ActualResult = jsonPathEvaluator.get(element);
        if (expectedResult.equals("true")) {
            Assert.assertTrue(ActualResult);
        } else {
            Assert.assertFalse(ActualResult);
        }
    }

    @And("^I verify (.*) should contain (.*)$")
    public void iVerifyStringContains(String element, String expectedResult) throws Throwable {
        JsonPath jsonPathEvaluator = baseSteps.response.jsonPath();
        String ActualResult = jsonPathEvaluator.get(element);
        Assert.assertTrue(ActualResult.contains(expectedResult));
    }
}
