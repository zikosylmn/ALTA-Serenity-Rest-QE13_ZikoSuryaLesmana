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

public class ListResourceStepDef {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Get list resource")
    public void getListResourceWithValidParamPagePage() {
        reqresAPI.getListResource();
    }

    @When("When send request get list resource")
    public void whenSendRequestGetListResource() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_RESOURCE);
    }

    @Then("Status code get list resource should be {int}")
    public void statusCodeGetListResourceShouldBe(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate get list resource json schema {string}")
    public void validateGetListResourceJsonSchema(String json) {
        File jsonListResource = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonListResource));
    }
}
