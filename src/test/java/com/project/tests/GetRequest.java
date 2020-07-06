package com.project.tests;

import com.project.constants.groups.PRIORITY;
import com.project.constants.groups.TESTTYPE;
import com.project.utility.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetRequest extends BaseTest {

    @Test(testName = "Get_Request_Validation", groups = {PRIORITY.P2, TESTTYPE.REGRESSION})
    private void getRequestAuto(){
        RestAssured.baseURI = "https://www.youtube.com/results";

        Response response = RestAssured.given()
                .param("search_query", "National Geographic")
                .param("pbj", "1")
                .when()
                .get();
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.contentType());
        System.out.println(response.getCookies());

        System.out.println(response.prettyPrint());

//        RestAssured.given()
//                .param("page", "2")
//                .when()
//                .get()
//                .then()
//                .assertThat()
//                //.log()
//               // .all()
//                .statusCode(200);
    }
}
