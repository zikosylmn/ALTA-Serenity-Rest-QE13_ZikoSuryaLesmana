package starter.reqres;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.checkerframework.checker.units.qual.C;
import starter.utils.Constants;

import java.io.File;
import static org.hamcrest.Matchers.equalTo;
public class ReqresDeleteAPI {

    public static String DELETE_USER = Constants.BASE_URL+"/api/users/{id}";
    @Step ("Delete user")
    public void deleteUser (int id){
        SerenityRest.given().pathParam("id",id);
    }
    @Step ("Delete user using chara")
    public void deleteUserChara (String id){
        SerenityRest.given().pathParam("id",id);
    }
}
