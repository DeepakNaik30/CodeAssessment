package com.project.tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class PostRequestAutomation {

    @Test
    private void postRequest(){
        RestAssured.baseURI = "https://reqres.in/api/users";

        String body = "{\n" +
                "    \"name\": \"Deepak\",\n" +
                "    \"job\": \"QA\"\n" +
                "}";

        RestAssured.given().body(body)
                .when()
                .post()
                .then()
                .assertThat()
                .log()
                .all()
                .statusCode(201);
    }


}
