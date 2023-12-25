package starter.stepdef;

import com.gargoylesoftware.htmlunit.javascript.host.fetch.Response;
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

public class ReqresStepDef {

    @Steps
    ReqresAPI reqresAPI;

    // Scenario 1
    @Given("Get list users with page {int}")
    public void getListUsersWithPagePage(int page) {
        reqresAPI.getListUsers(page);
    }

    @When("Send request get list users")
    public void sendRequestGetListUsers() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USER);
    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }
    @And("Response body page should be {int}")
    public void responseBodyPageShouldBePage(int page) {
        SerenityRest.and().body(ReqresResponses.PAGE,equalTo(page));
    }
    @And("Validate get list users json schema {string}")
    public void validateGetListUsersJsonSchema(String json) {
        File jsonGetListSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonGetListSchema));
    }

    //Scenario 2
    @Given("Post create user with valid json {string}")
    public void postCreateUserWithValidJson(String json) {
        File jsonCreateUser = new File(Constants.REQ_BODY+json);
        reqresAPI.postCreateUser(jsonCreateUser);
    }
    @When("Post request post create user")
    public void postRequestPostCreateUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }
    @And("Response body name was {string} and job was {string}")
    public void responseBodyNameWasAndJobWas(String name, String job) {
        SerenityRest.and()
                .body(ReqresResponses.NAME,equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job));
    }
    @And("Validate create user json schema {string}")
    public void validateCreateUserJsonSchema(String json) {
        File jsonCreateSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonCreateSchema));
    }

    // Scenario 3
//    @Given("Update user with valid {int} and json {string}")
//    public void updateUserWithValidIdAndJson(int id, String json) {
//        File jsonUpdateUser = new File(Constants.REQ_BODY+json);
//        reqresAPI.updateUser(id, jsonUpdateUser);
//    }
//    @When("Send request update user")
//    public void sendRequestUpdateUser() {
//        SerenityRest.when().put(ReqresAPI.UPDATE_USER);
//    }
//
//    @And("Validate update user json schema {string}")
//    public void validateUpdateUserJsonSchema(String json) {
//        File jsonUpdateSchema = new File(Constants.JSON_SCHEMA+json);
//        SerenityRest.and()
//                .assertThat()
//                .body(JsonSchemaValidator.matchesJsonSchema(jsonUpdateSchema));
//    }

    // Scenario 4
//    @Given("Delete user with valid id {int}")
//    public void deleteUserWithValidIdId(int id) {
//        reqresAPI.deleteUser(id);
//    }
//    @When("Send request delete user")
//    public void sendRequestDeleteUser() {
//        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
//    }
}
