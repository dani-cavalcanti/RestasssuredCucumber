package base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utilities.PropertiesReader;

public class BaseBuilder {
    PropertiesReader propertiesReader = new PropertiesReader();
    RequestSpecBuilder builder;

    public RequestSpecification placeSpecBuilder() {
        builder = new RequestSpecBuilder();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        ///System.out.println("Environment found!!!!!!!!, setting default environment to ==> "+propertiesReader.getPropValue("baseUrl"));

        builder.setBaseUri(propertiesReader.getPropValue("baseUrl"));
        builder.setContentType(ContentType.JSON);
        builder.setRelaxedHTTPSValidation();
        return builder.build();
    }
}
