package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

/**
 * Created by Raul on 5/7/18.
 */
public class BaseSteps {

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
}
