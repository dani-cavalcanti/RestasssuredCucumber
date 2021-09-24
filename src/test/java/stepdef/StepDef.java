package stepdef;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

abstract class StepDef {

    public static JsonPath js;

    public static JsonPath rawToJson(Response response) {
        js = new JsonPath(response.body().asString());
        return js;
    }

    public static JsonPath getJson(ValidatableResponse validatableResponse) {
        js = validatableResponse.extract().jsonPath();
        return js;
    }

    public void verifyResponseKeyValues(String key, String val, ValidatableResponse validatableResponse) {
        js = getJson(validatableResponse);

        String keyValue = js.getString(key);
        assertThat(keyValue, is(val));
    }

    public void verifyTrue(boolean val) {
        assertTrue(val);
    }

    public void verifyFalse(boolean val) {
        assertFalse(val);
    }

    public void verifyEmpty(String val) {
        assertNotNull(val);
    }

    public void verifyResponseStatusValue(ValidatableResponse validatableResponse, int expectedCode) {
        validatableResponse.statusCode(is(expectedCode));
    }

}
