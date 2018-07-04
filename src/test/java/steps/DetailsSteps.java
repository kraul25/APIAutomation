package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

/**
 * Created by Raul on 5/7/18.
 */
public class DetailsSteps {

    public static Response response;

    @Given("^I set the base URI to Categories$")
    public void iSetTheBaseURIToCategories() throws Throwable {
        RestAssured.baseURI = "https://api.tmsandbox.co.nz/v1/Categories";
    }

    @And("^I call the Get service for details json$")
    public void iCallTheGetServiceForDetailsJson() throws Throwable {
        RequestSpecification httpRequest = RestAssured.given();
        response = httpRequest.request(Method.GET, "/6327/Details.json?catalogue=false");
    }

    @And("^I verify the service response is (\\d+)$")
    public void iVerifyTheServiceResponseIs(int expectedCode) throws Throwable {
        int responseCode = response.getStatusCode();
        Assert.assertEquals(expectedCode, responseCode);
    }

    @And("^I verify (.*) should be equal to (.*)$")
    public void iVerifyStringEquals(String element, String expectedResult) throws Throwable {
        JsonPath jsonPathEvaluator = response.jsonPath();
        String ActualResult = jsonPathEvaluator.get(element);
        Assert.assertEquals(expectedResult,ActualResult);
    }

    @And("^Verify (.*) should be (.*)$")
    public void VerifyBoolean(String element, String expectedResult) throws Throwable {
        JsonPath jsonPathEvaluator = response.jsonPath();
        boolean ActualResult = jsonPathEvaluator.get(element);
        if(expectedResult.equals("true")) {
            Assert.assertTrue(ActualResult);
        }
        else
        {
            Assert.assertFalse(ActualResult);
        }
    }

    @And("^I verify (.*) should contain (.*)$")
    public void iVerifyStringContains(String element, String expectedResult) throws Throwable {
        JsonPath jsonPathEvaluator = response.jsonPath();
        String ActualResult = jsonPathEvaluator.get(element);
        Assert.assertTrue(ActualResult.contains(expectedResult));
    }
}
