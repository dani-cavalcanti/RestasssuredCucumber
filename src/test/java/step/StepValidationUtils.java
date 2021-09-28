package step;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

/**
 * Classe base resposável por reunir utilitários para serem utlizado na validação das asserções
 *
 * @author dgrassato
 * @lastUpdate 2021/09/28
 * @since 2021/09/28
 */
abstract class StepValidationUtils {

    public static JsonPath js;

    public static JsonPath rawToJson(final Response response) {
        js = new JsonPath(response.body().asString());
        return js;
    }

    public static JsonPath getJson(final ValidatableResponse validatableResponse) {
        js = validatableResponse.extract().jsonPath();
        return js;
    }

    public void verifyResponseKeyValues(final String key, final String val, final ValidatableResponse validatableResponse) {
        js = getJson(validatableResponse);

        String keyValue = js.getString(key);
        assertThat(keyValue, is(val));
    }

    public void verifyTrue(final boolean val) {
        assertTrue(val);
    }

    public void verifyFalse(final boolean val) {
        assertFalse(val);
    }

    public void verifyEmpty(final String val) {
        assertNotNull(val);
    }

    public void verifyResponseStatusValue(final ValidatableResponse validatableResponse, int expectedCode) {
        validatableResponse.statusCode(is(expectedCode));
    }

    public void validationSchema(final ValidatableResponse validatableResponse, String schemaName) {

        final String schemaPath = "constracts/".concat(schemaName).concat(".json");
        validatableResponse.body(matchesJsonSchemaInClasspath(schemaPath)).assertThat();

    }

}
