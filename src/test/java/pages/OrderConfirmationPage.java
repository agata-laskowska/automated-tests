package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderConfirmationPage {

    private WebDriver driver;

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#cart_navigation > button")
    private WebElement orderConfirmationButton;

    @FindBy(css = "#center_column > div > p > strong")
    private WebElement orderConfirmationMessage;

    public void waitUntilOrderConfirmationButtonIsVisible() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(orderConfirmationButton));
    }

    public void confirmOrder() {
        orderConfirmationButton.click();
    }

    public String getTextOfOrderConfirmationMessage() {
        return orderConfirmationMessage.getText();
    }
}
