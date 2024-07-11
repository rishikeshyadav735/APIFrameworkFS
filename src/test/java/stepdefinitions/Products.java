package stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import utility.TestDataBuild;

import static org.junit.Assert.*;
import static io.restassured.RestAssured.given;

public class Products {

    public int StatusCode;
    public RequestSpecification httpRequest;
    public Response response;
    public int ResponseCode;
    public ResponseBody responseBody;
    TestDataBuild requestBody = new TestDataBuild();

    @Given("Hit the URL of get products api endpoint")
    public void hit_the_url_of_get_products_api_endpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/";

    }
    @When("Pass the URL of products in the request")
    public void pass_the_url_of_products_in_the_request() {
        httpRequest = RestAssured.given();
        response = httpRequest.get("products");
    }
    @Then("Receive the response code as {int}")
    public void receive_the_response_code_as(Integer int1) {
        ResponseCode = response.getStatusCode();
        assertEquals(ResponseCode, 200);
    }

    @Then("Verify the rate of the product is {string}")
    public void verifyTheRateOfTheProductIs(String rate) {

        responseBody = response.getBody();

        //Converting response body to String
        String respBody = responseBody.toString();

        //JSON Representation of Response Body
        JsonPath jsonpath = response.jsonPath();

        String s = jsonpath.getJsonObject("rating[0].rate").toString();

        assertEquals(rate,s);
    }

    @Given("Hit the URL of post products api endpoint")
    public void hitTheURLOfPostProductsApiEndpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
        httpRequest = RestAssured.given();

    }

    @When("Pass the request body of product title {string}")
    public void passTheRequestBodyOfProductTitle(String title) {
        httpRequest = given().body(requestBody.insertProductPayload(title)).log().all();
        response = httpRequest.post("products");

        // Print the response body
        System.out.println(response.getBody().asString());
    }

    @Then("Receive the response bode with id as {string}")
    public void receiveTheResponseBodeWithIdAs(String id) {
        httpRequest = given().body(requestBody.insertProductPayload("shoes")).log().all();
        response = httpRequest.post("products");

        // Print the response body
        System.out.println(response.getBody().asString());
        JsonPath js = new JsonPath(response.asString());
        String actualID = js.get("id").toString();
        assertEquals(id,actualID);
    }
}
