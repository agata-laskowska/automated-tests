package pages;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {

    private WebDriver driver;
    private JSONObject testData;

    public SignInPage(WebDriver driver, JSONObject testData) {
        this.driver = driver;
        this.testData = testData;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "SubmitCreate")
    private WebElement createAccountButton;

    @FindBy(id = "email")
    private WebElement emailInputField;

    @FindBy(id = "passwd")
    private WebElement passwordInputField;

    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;

    @FindBy(css = "#center_column > div.alert.alert-danger")
    private WebElement errorMessage;

    public void waitUntilSignInPageLoads() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(createAccountButton));
    }

    public void waitUntilSignInButtonIsClickable() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(signInButton));
    }

    public void fillInLoginForm(String jsonKey) {
        String login = (String) testData.get("login");
        String password = (String) testData.get(jsonKey);
        System.out.println(password);

        emailInputField.sendKeys(login);
        passwordInputField.sendKeys(password);

        signInButton.click();
    }

    public Boolean errorMessageIsDisplayed() {
        return errorMessage.isDisplayed();
    }
}
