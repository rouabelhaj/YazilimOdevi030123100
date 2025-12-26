package com.test;

import com.test.base.BaseTest;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetUserTest extends BaseTest {

    @Test
    public void getPostById_shouldReturn200_andCorrectBody_andFastResponse() {

        given()
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)                       // ✅ status code kontrolü
                .time(lessThan(2000L))                 // ✅ response time kontrolü (2 sn altı)
                .body("id", equalTo(1))                // ✅ response body kontrolü
                .body("userId", notNullValue())
                .body("title", notNullValue())
                .log().all();                          // (sunum için) response'u yazdırır
    }
}
