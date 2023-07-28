package controller;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import model.TransactionModel;
import setup.Setup;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Transaction extends Setup {
    public Transaction() throws IOException {
        initConfig();
    }
    public JsonPath depositMoney(String from_account, String to_account, double amount){
        RestAssured.baseURI = prop.getProperty("baseURL");
        TransactionModel transactionModel = new TransactionModel();
        transactionModel.setFrom_account(from_account);
        transactionModel.setTo_account(to_account);
        transactionModel.setAmount(amount);
        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", prop.getProperty("partnerKey"))
                        .body(transactionModel)
                        .when()
                        .post("/transaction/deposit")
                        .then()
                        .assertThat().statusCode(201).extract().response();

        return res.jsonPath();
    }

    public JsonPath withdrawMoney(String from_account, String to_account, double amount){
        RestAssured.baseURI = prop.getProperty("baseURL");
        TransactionModel transactionModel = new TransactionModel();
        transactionModel.setFrom_account(from_account);
        transactionModel.setTo_account(to_account);
        transactionModel.setAmount(amount);
        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", prop.getProperty("partnerKey"))
                        .body(transactionModel)
                        .when()
                        .post("/transaction/withdraw")
                        .then()
                        .assertThat().statusCode(201).extract().response();

        return res.jsonPath();
    }

    public JsonPath sendMoney(String from_account, String to_account, double amount){
        RestAssured.baseURI = prop.getProperty("baseURL");
        TransactionModel transactionModel = new TransactionModel();
        transactionModel.setFrom_account(from_account);
        transactionModel.setTo_account(to_account);
        transactionModel.setAmount(amount);
        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", prop.getProperty("partnerKey"))
                        .body(transactionModel)
                        .when()
                        .post("/transaction/sendmoney")
                        .then()
                        .assertThat().statusCode(201).extract().response();

        return res.jsonPath();
    }

    public JsonPath payment(String from_account, String to_account, double amount){
        RestAssured.baseURI = prop.getProperty("baseURL");
        TransactionModel transactionModel = new TransactionModel();
        transactionModel.setFrom_account(from_account);
        transactionModel.setTo_account(to_account);
        transactionModel.setAmount(amount);
        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", prop.getProperty("partnerKey"))
                        .body(transactionModel)
                        .when()
                        .post("/transaction/payment")
                        .then()
                        .assertThat().statusCode(201).extract().response();

        return res.jsonPath();
    }

    public JsonPath checkBalance(String phone_number){
        RestAssured.baseURI = prop.getProperty("baseURL");
        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", prop.getProperty("partnerKey"))
                        .when()
                        .get("/transaction/balance/"+phone_number)
                        .then()
                        .assertThat().statusCode(200).extract().response();
        return res.jsonPath();
    }
}