package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;

import static utils.constants.Messages.SUCCESS_SUBMISSION_HEADER_MESSAGE;

public class MainPage {

    private final WebDriver driver = DriverManager.getInstance();
    private final WebDriverWait webDriverWait;

    public MainPage() {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    private final By addStudentButton = By.id("addStudentButton");
    private final By nameField = By.id("name");
    private final By emailField = By.id("email");
    private final By genderDropDown = By.id("gender");
    private final By submitButton = By.xpath("//span[text()='Submit']//parent::button");
    private final By successHeader = By.className("ant-notification-notice-message");

    public void clickOnAddStudentButton() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addStudentButton));
        driver.findElement(addStudentButton).click();
    }

    public void enterName(String name) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(nameField));
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterMail(String mail) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(emailField));
        driver.findElement(emailField).sendKeys(mail);
    }

    public void setGender(String gender) {
        driver.findElement(genderDropDown).click();
        webDriverWait.until(ExpectedConditions.textToBe(By.xpath("//div[@title='" + gender + "']"), gender));
        driver.findElement(By.xpath("//div[@title='" + gender + "']")).click();
    }

    public void submitForm() {
        driver.findElement(submitButton).click();
    }

    public void fillForm(String name, String mail, String gender) {
        enterName(name);
        enterMail(mail);
        setGender(gender);
    }

    public String getNotificationHeaderMessage() {
        webDriverWait.until(ExpectedConditions.textToBe(successHeader, SUCCESS_SUBMISSION_HEADER_MESSAGE));
        return driver.findElement(successHeader).getText();
    }
}
