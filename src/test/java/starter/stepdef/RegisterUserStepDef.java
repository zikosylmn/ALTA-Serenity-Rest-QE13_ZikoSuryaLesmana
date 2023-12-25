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
import starter.reqres.ReqresRegisterAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class RegisterUserStepDef {

    @Steps
    ReqresRegisterAPI reqresRegisterAPI;
    @Given("Post register with valid data on json {string}")
    public void postRegisterUser(String json) {
        File jsonRegisterUser = new File(Constants.REQ_BODY+json);
        reqresRegisterAPI.postRegisterUser(jsonRegisterUser);
    }

    @When("Send request register user")
    public void sendRequestRegisterUser() {
        SerenityRest.when().get(ReqresRegisterAPI.REGISTER_USER);
    }

    @Then("Status code register user should be {int}")
    public void statusCodeRegisterUserShouldBe(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @Given("Post register with invalid data on json {string}")
    public void postRegisterWithInvalidDataOnJson(String json) {
        File jsonRegisterUser = new File(Constants.REQ_BODY+json);
        reqresRegisterAPI.postRegisterUser(jsonRegisterUser);
    }

//    @And("Validate register user json schema {string}")
//    public void registerUserJsonSchema(String json){
//        File jsonRegisterUser = new File(Constants.JSON_SCHEMA+json);
//        SerenityRest.and()
//                .assertThat()
//                .body(JsonSchemaValidator.matchesJsonSchema(jsonRegisterUser));
//    }
}
