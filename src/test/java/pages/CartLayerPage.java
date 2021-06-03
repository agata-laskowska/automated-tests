package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartLayerPage {

    private WebDriver driver;

    public CartLayerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "icon-ok")
    private WebElement addedToCartNotification;

    @FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_product.col-xs-12.col-md-6 > span")
    private WebElement closeButton;


    public void waitUntilAddedToCartNotificationIsVisible() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(addedToCartNotification));
    }

    public void closeCart() {
        closeButton.click();
    }

    public Boolean addedToCartNotificationIsVisible() {
        return addedToCartNotification.isDisplayed();
    }
}
