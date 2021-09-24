package resources;

import base.BaseBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import stepdef.GoogleMap;

import static io.restassured.RestAssured.given;

public class Requests {

    static Response response;
    RequestSpecification reqspec;

    public Response getRequest(String apiName) {

        APIResources resourceAPI= APIResources.valueOf(apiName);
        reqspec = new BaseBuilder().placeSpecBuilder();

        if(apiName.equalsIgnoreCase("AddPlaceAPI"))
        {
            System.out.println("Sending POST request to: "+resourceAPI.getResource()+" service");
            reqspec = given().spec(reqspec).body(Payload.addPlacePayload());
        }
        else if(apiName.equalsIgnoreCase("DeletePlaceAPI"))
        {
            System.out.println("Sending POST request to: "+resourceAPI.getResource()+" service");
            reqspec = given().spec(reqspec).body(Payload.deletePayload(GoogleMap.placeID));

        }

        response = reqspec.post(resourceAPI.getResource()).then().extract().response();


        return response;
    }
}


