package StepDefinition;

import Resources.TestDataBuild;
import Resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.junit.Assert.*;

import static io.restassured.RestAssured.given;

public class Login extends Utils {
    RequestSpecification requestSpecification1;
    ResponseSpecification res;
    Response response;
    TestDataBuild testData=new TestDataBuild();
    @Given("Add Place Payload")
    public void add_Place_Payload() {

        res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        requestSpecification1 = given().spec(requestSpecification()).body(testData.addPlacePayload());
    }

    @When("user calls {string} with POST http request")
    public void user_calls_with_POST_http_request(String string) {
        response = requestSpecification1.when().post("/maps/api/place/add/json") //sending
                .then().spec(res)//getting
                .extract().response();
    }

    @Then("the API call got success with status case {int}")
    public void the_API_call_got_success_with_status_case(Integer int1) {
        assertEquals(response.statusCode(), 200);
    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue, String Expectedvalue) {
        String resp = response.asString();
        JsonPath jsonPath = new JsonPath(resp);
        assertEquals(jsonPath.get(keyValue).toString(), Expectedvalue);
    }
}
