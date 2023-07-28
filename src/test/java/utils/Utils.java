package utils;

import model.UserModel;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {
    public static void saveEnvVar(String key, String value) throws ConfigurationException, ConfigurationException {
        PropertiesConfiguration config = new PropertiesConfiguration("./src/test/resources/config.properties");
        config.setProperty(key, value);
        config.save();
    }
    public static int generateRandomId(int min, int max){
        double number = Math.random()*(max-min)+min;
        return (int) number;
    }
    public static void saveInfo(UserModel model) throws IOException, ParseException, IOException {
        String filePath = "./src/test/resources/Users.json";
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(filePath));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", model.getName());
        jsonObject.put("email", model.getEmail());
        jsonObject.put("password", model.getPassword());
        jsonObject.put("phone_number", model.getPhone_number());
        jsonObject.put("nid", model.getNid());
        jsonObject.put("role", model.getRole());

        jsonArray.add(jsonObject);

        FileWriter writer = new FileWriter(filePath);
        writer.write(jsonArray.toJSONString());
        writer.flush();
        writer.close();
    }

    public static JSONArray readJSONArray() throws IOException, ParseException, ParseException {
        String filePath = "./src/test/resources/Users.json";
        JSONParser parser = new JSONParser();
        JSONArray userArray = (JSONArray) parser.parse(new FileReader(filePath));
        return userArray;
    }
}
