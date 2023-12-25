package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.checkerframework.checker.units.qual.C;
import starter.utils.Constants;

import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class ReqresAPI {
    public static String GET_LIST_USER = Constants.BASE_URL + "/api/users?page={page}";
    public static String GET_SINGLE_USER = Constants.BASE_URL + "/api/users/{id}";
    public static String GET_LIST_RESOURCE = Constants.BASE_URL + "/api/unknown/";
    public static String POST_CREATE_USER = Constants.BASE_URL+"/api/users";
    public static String UPDATE_USER = Constants.BASE_URL+"/api/users/{id}";
    public static String DELETE_USER = Constants.BASE_URL+"/api/users/{id}";

    @Step("Get list users")
    public void getListUsers(int page){
        SerenityRest.given()
                .pathParam("page", page);
    }
    @Step("Get single user")
    public void getSingleUser(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }
    @Step("Get single user with invalid id2")
    public void getSingleUserInvalidID(String id2){
        SerenityRest.given()
                .pathParam("id", id2);
    }
    @Step("Get list resource")
    public void getListResource(){
        SerenityRest.given();
    }
    @Step("Post create user")
    public void postCreateUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
//    @Step("Update user")
//    public void updateUser(int id, File json){
//        SerenityRest.given()
//                .pathParam("id", id)
//                .contentType(ContentType.JSON)
//                .body(json);
//    }
//    @Step("Delete User")
//    public void deleteUser(int id){
//        SerenityRest.given()
//                .pathParam("id", id);
//    }
}
