package starter.stepdef;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.json.Json;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class SingleUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Get single user with id {int}")
    public void getSingleUserWithIdId(int id) {
        reqresAPI.getSingleUser(id);
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }
    @Then("Status code get single user should be {int}")
    public void statusCodeGetSingleUserShouldBe(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Response body data should be {int}")
    public void responseBodyDataShouldBe(int data) {
        SerenityRest.and().body(ReqresResponses.DATA_ID, equalTo(data));
    }

    @And("Validate get single user json schema {string}")
    public void validateGetSingleUserJsonSchema(String json) {
        File jsonSchemaSingleUser = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaSingleUser));
    }

    @Given("Get single user with invalid id {string}")
    public void getSingleUserWithInvalidId(String chara) {
        reqresAPI.getSingleUserInvalidID(chara);
    }
}
