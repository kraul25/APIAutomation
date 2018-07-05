package steps;

import Utils.JsonPathImplementation;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class BaseSteps extends JsonPathImplementation{

    public static Response response;

    @Given("^I set the base URI to Categories$")
    public void iSetTheBaseURIToCategories() throws Throwable {
        RestAssured.baseURI = "https://api.tmsandbox.co.nz/v1/Categories";
    }

    @And("^I verify the service response is (\\d+)$")
    public void iVerifyTheServiceResponseIs(int expectedCode) throws Throwable {
        int responseCode = response.getStatusCode();
        Assert.assertEquals(expectedCode, responseCode);
    }


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
