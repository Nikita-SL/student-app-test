import net.datafaker.Faker;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_object.MainPage;

import java.lang.reflect.Method;

import static org.testng.Assert.assertEquals;
import static utils.ConfigReader.getConfiguration;
import static utils.DriverManager.*;
import static utils.constants.Genders.FEMALE;
import static utils.constants.Messages.SUCCESS_SUBMISSION_HEADER_MESSAGE;
import static utils.constants.SuiteNames.REGRESSION;


public class StudentAppTest {
    private final Faker randomData = new Faker();
    private MainPage mainPage;

    @BeforeMethod(alwaysRun = true)
    public void before(Method methodName) {
        testName = methodName.getName();
        mainPage = new MainPage();

        getInstance().get(getConfiguration().getString("app.acodemy.url"));
    }

    @Test(description = "Successful student submission test", groups = REGRESSION)
    public void testAddStudent() {
        mainPage.clickOnAddStudentButton();
        mainPage.fillForm(randomData.funnyName().name(), randomData.internet().emailAddress(), FEMALE);
        mainPage.submitForm();

        assertEquals(mainPage.getNotificationHeaderMessage(), SUCCESS_SUBMISSION_HEADER_MESSAGE);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!getConfiguration().getBoolean("run.locally")) {
            markRemoteTest(result);
        }
        closeDriver();
    }
}