package pages;

import UtilClasses.HoverElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MiniCartPage {

    private WebDriver driver;

    HoverElement hoverElement = new HoverElement();

    public MiniCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a")
    private WebElement shoppingCart;

    @FindBy(className = "ajax_cart_block_remove_link")
    private WebElement removeFromCartButton;

    @FindBy(css = "#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a > span.ajax_cart_no_product")
    private WebElement emptyCartMessage;

    @FindBy(id = "button_order_cart")
    private WebElement goToCheckoutButton;

    @FindBy(css = "#header > div:nth-child(3) > div > div > div:nth-child(3) > div > div > div > div > dl > dt > a > img")
    private WebElement productInCart;

    @FindBy(css = "#header > div:nth-child(3) > div > div > div:nth-child(3) > div > div > div > div > dl > dt > div > div.product-atributes")
    private WebElement productDescription;

    public void waitUntilMiniCartIsVisible() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(shoppingCart));
    }

    public void waitUntilEmptyCartMessageIsVisible() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(emptyCartMessage));
    }

    public void waitUntilGoToCheckoutButtonIsClickable() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(goToCheckoutButton));
    }

    public void waitUntilRemoveFromCartButtonIsVisible() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(removeFromCartButton));
    }

    public String getTextOfProductDescription() {
        return productDescription.getText();
    }

    public void hoverShoppingCart() {
        waitUntilMiniCartIsVisible();
        hoverElement.hoverElement(shoppingCart);
        waitUntilGoToCheckoutButtonIsClickable();
    }

    public void removeProductFromMinicart() {
        removeFromCartButton.click();
    }

    public void clickProductInCart() {
        productInCart.click();
    }

    public void goToCheckout() {
        goToCheckoutButton.click();
    }

    public Boolean cartIsEmpty() {
        return emptyCartMessage.isDisplayed();
    }
}
