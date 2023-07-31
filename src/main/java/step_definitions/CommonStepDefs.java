package step_definitions;

import io.cucumber.java.en.Given;
import utils.ConfigReader;
import utils.DriverManager;

public class CommonStepDefs {
    @Given("user is on the app page")
    public void userIsOnTheAppPage() {
        DriverManager.getInstance().get(ConfigReader.getConfiguration().getString("app.acodemy.url"));
    }
}
