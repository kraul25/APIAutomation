package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import io.restassured.RestAssured;

/**
 * Created by Raul on 5/7/18.
 */
public class DetailsSteps {
    @Given("^I set the base URI to Categories$")
    public void iSetTheBaseURIToCategories() throws Throwable {
        RestAssured.baseURI = "https://api.tmsandbox.co.nz/v1/Categories";
    }
}
