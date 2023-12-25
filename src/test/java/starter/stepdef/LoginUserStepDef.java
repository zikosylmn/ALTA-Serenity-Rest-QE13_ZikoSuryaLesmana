package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresLoginAPI;
import starter.reqres.ReqresRegisterAPI;
import starter.utils.Constants;

import java.io.File;

public class LoginUserStepDef {
    @Steps
    ReqresLoginAPI reqresLoginAPI;
    @Given("Post login with valid data on json {string}")
    public void postLoginWithValidDataOnJson(String json) {
            File jsonRegisterUser = new File(Constants.REQ_BODY+json);
            reqresLoginAPI.postLoginUser(jsonRegisterUser);
    }

    @When("Send request login user")
    public void sendRequestLoginUser() {
        SerenityRest.when().post(ReqresLoginAPI.POST_LOGIN);
    }

    @Given("Post login with invalid data on json {string}")
    public void postLoginWithInvalidDataOnJson(String json) {
        File jsonRegisterUser = new File(Constants.REQ_BODY+json);
        reqresLoginAPI.postLoginUser(jsonRegisterUser);
    }

    @And("Validate error login json schema {string}")
    public void validateErrorLoginJsonSchema(String json) {
            File jsonLoginError = new File(Constants.JSON_SCHEMA+json);
            SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonLoginError));
    }
}
