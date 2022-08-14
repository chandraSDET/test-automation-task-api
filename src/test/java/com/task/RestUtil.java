package com.task;

import com.task.config.ConfigFileReader;
import com.task.config.ConfigManager;

import com.task.reports.ExtentReportManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class RestUtil extends ExtentReportManager {
    public ConfigFileReader configFileReader;
    Map<String,String> headers = new HashMap<>();

    @BeforeMethod(alwaysRun = true)
    public void preCondition(Method method) {
        ExtentReportManager.startTest(method.getName(),method.getName());
        configFileReader=ConfigManager.getInstance().getConfigReader();
        headers.put("X-Auth-Token","a5d573dfdc474289a361eaff1482c71f");
        RestAssured.baseURI=configFileReader.getBaseUrl();
    }

    public Response getApiResponse(String url){
       return given().contentType(ContentType.JSON).headers(headers)
                .when()
                .get(url);
    }

    public String getCompetitionIdFromResponse(Response response,String name){
        String id="";
        JSONObject jsonObject = new JSONObject(response.asString());
        int size=jsonObject.getJSONArray("competitions").length();
        for(int i=0;i<size;i++){
            if(jsonObject.getJSONArray("competitions").getJSONObject(i).get("name").equals(name)){
                id=String.valueOf(jsonObject.getJSONArray("competitions").getJSONObject(i).get("id"));
            }
        }
        return id;
    }

}
