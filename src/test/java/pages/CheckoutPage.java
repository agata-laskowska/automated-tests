package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "cart_title")
    private WebElement checkoutHeading;

    @FindBy(id = "1_1_0_0")
    private WebElement trashIcon;

    @FindBy(css = "#center_column > p")
    private WebElement emptyCartAlert;

    @FindBy(css = "#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium")
    private WebElement proceedToLoginButton;

    public void waitUntilCheckoutPageLoads() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(checkoutHeading));
    }

    public void waitUntilEmptyCartAlertIsVisible() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(emptyCartAlert));
    }

    public void deleteProduct() {
        trashIcon.click();
    }

    public void proceedToLogin() {
        proceedToLoginButton.click();
    }

    public Boolean emptyCartAlertIsVisible() {
        return emptyCartAlert.isDisplayed();
    }
}
