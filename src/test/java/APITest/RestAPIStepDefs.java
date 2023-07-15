package APITest;

import java.util.Map;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAPIStepDefs {
	
	RequestSpecification request;
	Response response;
	


@Given("I have the end point as {string}")
public void i_have_the_end_point_as(String endpointURL) {
    // Write code here that turns the phrase above into concrete actions
    request=RestAssured.given().baseUri(endpointURL);
}

@When("I perform the get operation")
public void i_perform_the_get_operation() {
    // Write code here that turns the phrase above into concrete actions
	response=request.get();
  
}

@Then("I should get the response as {int}")
public void i_should_get_the_response_as(int expResponse) {
    // Write code here that turns the phrase above into concrete actions
	
	Assert.assertEquals(expResponse,response.getStatusCode());
   
}

@When("I perform the post operation with below data")
public void i_perform_the_post_operation_with_below_data(Map<String, String>datamap) {
   
	response = request.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(datamap)
			.post();

System.out.println("The response is " + response.getBody().asString());


}
@Then("The firstname should be {string} in response")
public void the_firstname_should_be_in_response(String name) {
    Assert.assertEquals(name,response.jsonPath().get("firstName"));
    
}


}
