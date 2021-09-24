package stepdef;

import java.io.FileNotFoundException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import resources.APIResources;
import resources.Requests;


public class GoogleMap extends StepDef{

	public static Response response;
	public static ValidatableResponse validatableResponse;
	public static String placeID;
	public Requests requests;

	public GoogleMap(Requests requests) {
		this.requests = requests;
	}

	@Given("User calls {string} with {string} http request")
	public void user_calls_request_with_http_request(String apiName, String requestType) {

		response = requests.getRequest(apiName);

		validatableResponse = response.then();
		js = this.getJson(validatableResponse);
	}
	
	@Then("Status code is {int}")
	public void status_code_is(Integer expectedCode) {
		System.out.println("Status Code: "+response.statusCode());
		verifyResponseStatusValue(validatableResponse, expectedCode);

	}
	
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String value1, String value2) {
		verifyResponseKeyValues(value1, value2, validatableResponse);
	}
	
	@Then("I retrieve the Place ID")
	public void i_retrieve_the_place_id() {
		placeID = js.get("place_id");

		verifyEmpty(placeID);
		System.out.println("Place ID: "+placeID);
	}

}
