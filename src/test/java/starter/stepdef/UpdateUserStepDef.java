package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresUpdateAPI;
import starter.utils.Constants;

import java.io.File;

public class UpdateUserStepDef {

    @Steps
    ReqresUpdateAPI reqresUpdateAPI;

    @Given("Update user with valid {int} and json {string}")
    public void updateUserWithValidIdAndJson(int id, String json) {
        File jsonUpdateUser = new File(Constants.REQ_BODY+json);
        reqresUpdateAPI.updateUser(id, jsonUpdateUser);
    }
    @When("Send request update user")
    public void sendRequestUpdateUser() {
        SerenityRest.when().put(ReqresAPI.UPDATE_USER);
    }

    @And("Validate update user json schema {string}")
    public void validateUpdateUserJsonSchema(String json) {
        File jsonUpdateSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonUpdateSchema));
    }
}
