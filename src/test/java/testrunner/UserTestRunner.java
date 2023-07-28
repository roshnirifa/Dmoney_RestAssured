package testrunner;

import com.github.javafaker.Faker;
import controller.User;
import io.restassured.path.json.JsonPath;
import model.UserModel;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Utils;

import java.io.IOException;

public class UserTestRunner {

    @Test(priority = 1, description = "calling user login")
    public void doLogin() throws ConfigurationException, IOException {
        User user = new User();
        user.doLogin("admin1@roadtocareer.net", "1234");

    }
    @Test(priority = 2, description = "create new customer")
    public void createNewCustomer() throws IOException, ConfigurationException, ParseException {
        User user = new User();
        int randomId = Utils.generateRandomId(1000, 9999);
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String email = "test" + randomId + "@test.com";
        String password = faker.internet().password();
        String phone_number = "0191" + randomId + "100";
        String nid = "22"+randomId+"33";
        String role = "Customer";
        JsonPath res = user.createUser(name, email, password, phone_number, nid, role);

        UserModel model = new UserModel();
        model.setName(name);
        model.setEmail(email);
        model.setPassword(password);
        model.setPhone_number(phone_number);
        model.setNid(nid);
        model.setRole(role);
        Utils.saveInfo(model);

        String message = res.get("message");
        Assert.assertTrue(message.contains("User created"));
    }
    @Test(priority = 3, description = "create another customer")
    public void createAnotherCustomer() throws IOException, ConfigurationException, ParseException {
        User user = new User();
        int randomId = Utils.generateRandomId(1000, 9999);
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String email = "test" + randomId + "@test.com";
        String password = faker.internet().password();
        String phone_number = "0191" + randomId + "100";
        String nid = "22"+randomId+"33";
        String role = "Customer";
        JsonPath res = user.createUser(name, email, password, phone_number, nid, role);

        UserModel model = new UserModel();
        model.setName(name);
        model.setEmail(email);
        model.setPassword(password);
        model.setPhone_number(phone_number);
        model.setNid(nid);
        model.setRole(role);
        Utils.saveInfo(model);

        String message = res.get("message");
        Assert.assertTrue(message.contains("User created"));
    }

    @Test(priority = 4, description = "Create a agent")
    public void createNewAgent() throws IOException, ConfigurationException, ParseException {
        User user = new User();
        int randomId = Utils.generateRandomId(1000, 9999);
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String email = "test" + randomId + "@test.com";
        String password = faker.internet().password();
        String phone_number = "0191" + randomId + "100";
        String nid = "22"+randomId+"33";
        String role = "Agent";
        JsonPath res = user.createUser(name, email, password, phone_number, nid, role);

        UserModel model = new UserModel();
        model.setName(name);
        model.setEmail(email);
        model.setPassword(password);
        model.setPhone_number(phone_number);
        model.setNid(nid);
        model.setRole(role);
        Utils.saveInfo(model);

        String message = res.get("message");
        Assert.assertTrue(message.contains("User created"));
    }
}
