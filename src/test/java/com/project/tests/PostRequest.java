package com.project.tests;

import com.project.constants.groups.PRIORITY;
import com.project.constants.groups.TESTTYPE;
import com.project.utility.BaseTest;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class PostRequest extends BaseTest {

    @Test(testName = "Post_Request_Validation", groups = {PRIORITY.P1, TESTTYPE.SMOKE})
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
