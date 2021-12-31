package Models;

import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static Utils.FileOperations.setProperties;

public class BodyViaCepModel {

    public static String[] getJsonObjectKeys(Response response){
        String bodyString = response.body().asString();
        JSONObject responseJson = new JSONObject(bodyString);

        Iterator<String> keys = responseJson.keys();
        String[] onlyKeys = new String[responseJson.length()];

        for (int i = 0; i < onlyKeys.length; i++){
            onlyKeys[i] = keys.next();
        }

        return onlyKeys;
    }

    public static void createEmptyValuesFile(String name, Response response){
        String[] keys = getJsonObjectKeys(response);

        for (int i = 0; i < keys.length; i++){
            setProperties(name, keys[i], "");
        }
    }

    public static void createResponseBodyFile(String name, Response response){
        String[] keys = getJsonObjectKeys(response);
        String jsonBody = response.getBody().asString();
        JSONObject json = new JSONObject(jsonBody);

        for (int i = 0; i < keys.length; i++){
            setProperties(name, keys[i], json.getString(keys[i]));
        }
    }

    public static void createResponseObject(){

    }

}
