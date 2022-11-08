package apiTestRunner;

import payload.booker.bookerAPI;
import data.createBooking;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class bookerTestAPI {
    bookerAPI baseUrl = new bookerAPI();
    Response response;
    createBooking getBookerData = new createBooking();
    //public String user_id;
    //Random rand = new Random();
    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = baseUrl.getBookerAPI();
    }

    @Test(priority = 0)
    public void getListBookingsIds(){
        response = given()
                .when()
                .get("booking")
                .then()
                .log().body()
                .statusCode(200)
                .extract().response();
    }

    @Test(priority = 1)
    public void getBookings(){
        response = given()
                .when()
                .get("booking/100")
                .then()
                .log().body()
                .statusCode(404)
                .extract().response();
    }

    @Test(priority = 1)
    public void createAPI(){
        response = given()
                .header("Content-Type", "application/json")
                .body(getBookerData.bookingPayload().toJSONString())
                .when()
                .post("booking")
                .then()
                .log().body()
                .statusCode(200)
                .extract().response();
    }
}
