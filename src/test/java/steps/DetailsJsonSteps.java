package steps;

import cucumber.api.java.en.And;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;

public class DetailsJsonSteps {

    BaseSteps baseSteps;

    @And("^I call the Get service for details json$")
    public void iCallTheGetServiceForDetailsJson() throws Throwable {
        RequestSpecification httpRequest = RestAssured.given().queryParam("catalogue","false").pathParam("code","6327");
        baseSteps.response = httpRequest.request(Method.GET, "/{code}/Details.json");
    }
}
