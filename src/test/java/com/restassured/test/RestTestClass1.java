package com.restassured.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class RestTestClass1 {
    @Test
    public void getTest(){
        // to get all the get all details or specific detail through ID
        Response response = RestAssured.get("http://localhost:3000/posts/");
        System.out.println(response.getStatusCode());
        System.out.println(response.asString());
    }

    @Test
    public  void postTest(){
        // post is to create
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",22);
        jsonObject.put("title","json-serverOne");
        jsonObject.put("author", "teju");
        request.body(jsonObject.toJSONString());
        Response response = request.post("http://localhost:3000/posts");
        System.out.println(response.getStatusCode());
        System.out.println(response.asString());
    }

    @Test
    public  void putTest(){
        // put is to update
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title","Phoenix");
        jsonObject.put("author", "Teju");
        request.body(jsonObject.toJSONString());
        Response response = request.put("http://localhost:3000/posts/20");
        System.out.println(response.getStatusCode());
        System.out.println(response.asString());
    }

    @Test
    public void deleteTest(){
        // delete is to delete
        RequestSpecification request = RestAssured.given();
        Response response = request.delete("http://localhost:3000/posts/20");
        System.out.println(response.getStatusCode());
        System.out.println(response.asString());
    }

    @Test
    public void basicAuthTest(){

        RestAssured.baseURI="http://localhost:3000/posts/";
        RequestSpecification request =   RestAssured.given()
                .auth().preemptive().basic("username","password");
        Response response = request.get();
        System.out.println(response.getStatusCode());
        System.out.println(response.asString());

    }

}


