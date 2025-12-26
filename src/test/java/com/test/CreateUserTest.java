package com.test;

import com.test.base.BaseTest;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;

public class CreateUserTest extends BaseTest {

    @Test
    public void createPost_shouldReturn201_andReturnSameFields_andFastResponse() {

        String requestBody = """
                {
                  "title": "Test Title",
                  "body": "Hello from Rest Assured",
                  "userId": 1
                }
                """;

        given()
                .contentType(JSON)
                .body(requestBody)                     // ✅ request body var
                .when()
                .post("/posts")
                .then()
                .statusCode(201)                       // ✅ status code kontrolü
                .time(lessThan(2000L))                 // ✅ response time kontrolü
                .body("title", equalTo("Test Title"))  // ✅ response body kontrolü
                .body("body", equalTo("Hello from Rest Assured"))
                .body("userId", equalTo(1))
                .body("id", notNullValue())            // JSONPlaceholder genelde id döndürür
                .log().all();
    }
}
