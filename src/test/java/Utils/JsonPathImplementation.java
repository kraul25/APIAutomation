package Utils;

import steps.BaseSteps;

public class JsonPathImplementation {
    BaseSteps baseSteps;

    public String getJsonPathForString(String element) {
        io.restassured.path.json.JsonPath jsonPathEvaluator = getJsonPathEvaluator();
        return jsonPathEvaluator.get(element);
    }

    public io.restassured.path.json.JsonPath getJsonPathEvaluator() {
        return baseSteps.response.jsonPath();
    }

    public boolean getJsonPathForBoolean(String element) {
        io.restassured.path.json.JsonPath jsonPathEvaluator = getJsonPathEvaluator();
        return jsonPathEvaluator.get(element);
    }
}
