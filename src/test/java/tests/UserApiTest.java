package tests;

import base.BaseTest;
import io.restassured.http.ContentType;
import models.User;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UserApiTest extends BaseTest {

    @Test
    public void testGetUsers() {
        given()
        .when()
            .get("/users?page=2")
        .then()
            .statusCode(200)
            .body("data.size()", greaterThan(0));
    }

    @Test
    public void testCreateUser() {
        User user = new User("Swathi", "Engineer");

        given()
            .contentType(ContentType.JSON)
            .body(user)
        .when()
            .post("/users")
        .then()
            .statusCode(201)
            .body("name", equalTo("Swathi"));
    }
}