package controller;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import model.UserModel;
import org.apache.commons.configuration.ConfigurationException;

import setup.Setup;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static utils.Utils.saveEnvVar;

public class User extends Setup {
    public User() throws IOException {
        initConfig();
    }


    public void doLogin(String email, String password) throws ConfigurationException, IOException {

        RestAssured.baseURI = prop.getProperty("baseURL");
        UserModel userModel = new UserModel();
        userModel.setEmail(email);
        userModel.setPassword(password);
        Response res =
                given()
                        .contentType("application/json")
                        .body(userModel)
                        .when()
                        .post("/user/login")
                        .then()
                        .assertThat().statusCode(200).extract().response();
//        System.out.println(res.asString());

        JsonPath jsonObj = res.jsonPath();
        String token = jsonObj.get("token");
        System.out.println(token);
        saveEnvVar("token", token);
    }
    public JsonPath createUser(String name, String email, String password, String phone_number, String nid, String role) throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("baseURL");
        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setEmail(email);
        userModel.setPassword(password);
        userModel.setPhone_number(phone_number);
        userModel.setNid(nid);
        userModel.setRole(role);
        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", prop.getProperty("partnerKey"))
                        .body(userModel)
                        .when()
                        .post("/user/create")
                        .then()
                        .assertThat().statusCode(201).extract().response();

        return res.jsonPath();
    }
//    public static void saveEnvVariable(String key, String value) throws ConfigurationException {
//        PropertiesConfiguration config = new PropertiesConfiguration("./src/test/resources/config.properties");
//        config.setProperty(key, value);
//        config.save();
//
//    }





    public static void main(String[] args) throws IOException {
//        controller.myAPICalling controller.myAPICalling = new controller.myAPICalling();
//        controller.myAPICalling.readConfig();
//        String token = controller.myAPICalling.prop.getProperty("token");
//        System.out.println(token);

    }
}
