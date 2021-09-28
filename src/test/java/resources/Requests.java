package resources;

import base.BaseBuilder;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Requests {

    static Response response;
    RequestSpecification reqspec;

    public Response getRequest(final String apiName, final Method requestType) {

        APIResources resourceAPI = APIResources.valueOf(apiName);
        reqspec = new BaseBuilder().placeSpecBuilder();

        System.out.println("Sending " + requestType.toString() + " request to: " + resourceAPI.getResource() + " service");

        response = given()
                .spec(reqspec)
                .request(requestType.toString(), resourceAPI.getResource())
                .then()
                //.log().all()
                .extract()
                .response();

        return response;
    }
}


