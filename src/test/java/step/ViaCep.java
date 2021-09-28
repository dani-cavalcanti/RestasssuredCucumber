package step;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import resources.Requests;


public class ViaCep extends StepValidationUtils {

    public static Response response;
    public static ValidatableResponse validatableResponse;
    public static String placeID;
    public Requests requests;
    private String api;

    public ViaCep(Requests requests) {
        this.requests = requests;
    }

    @Given("User calls {string} with {string} http request")
    public void user_calls_request_with_http_request(final String apiName, final String requestType) {

        response = requests.getRequest(apiName, Method.valueOf(requestType));
        this.api = apiName;
        validatableResponse = response.then();
        js = getJson(validatableResponse);
    }

    @Then("Status code is {int}")
    public void status_code_is(final Integer expectedCode) {
        System.out.println("Status Code: " + response.statusCode());
        verifyResponseStatusValue(validatableResponse, expectedCode);

    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(final String value1, final String value2) {
        verifyResponseKeyValues(value1, value2, validatableResponse);
    }

    @Then("I retrieve the Place ID")
    public void i_retrieve_the_place_id() {
        placeID = js.get("place_id");

        verifyEmpty(placeID);
        System.out.println("Place ID: " + placeID);
    }

    @Then("Validate the schema")
    public void i_validate_the_schema() {
        // Write code here that turns the phrase above into concrete actions

        validationSchema(validatableResponse, this.api);
    }

}
