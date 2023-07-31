package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.datafaker.Faker;
import org.testng.Assert;
import page_object.MainPage;

public class MainPageStepDefs {

    MainPage mainPage = new MainPage();
    Faker randomData = new Faker();

    @Given("user click on add student button")
    public void userClickOnAddStudentButton() {
        mainPage.clickOnAddStudentButton();
    }

    @And("user selects {string} in gender field")
    public void userSelectsGenders(String gender) {
        mainPage.setGender(gender);
    }

    @And("user enters name in name field")
    public void userEntersNameInNameField() {
        mainPage.enterName(randomData.name().fullName());
    }

    @And("user enter email in email field")
    public void userEnterEmailInEmailField() {
        mainPage.enterMail(randomData.internet().emailAddress());
    }

    @When("user click on submit button")
    public void userClickOnSubmitButton() {
        mainPage.submitForm();
    }

    @Then("user is created with success message {string}")
    public void userIsCreatedWithSuccessMessage(String message) {
        Assert.assertEquals(mainPage.getNotificationHeaderMessage(), message);
    }
}
