package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class GoToPDPFromMiniCartTest extends BaseTest {

    @Test
    public void goToPDPFromMiniCart() {
        HomePage homePage = new HomePage(driver);
        CartLayerPage cartLayerPage = new CartLayerPage(driver);
        MiniCartPage miniCartPage = new MiniCartPage(driver);
        ProductPage productPage = new ProductPage(driver);

        homePage.hoverProduct();
        homePage.addToCart();

        cartLayerPage.waitUntilAddedToCartNotificationIsVisible();
        cartLayerPage.closeCart();

        miniCartPage.hoverShoppingCart();
        miniCartPage.clickProductInCart();

        productPage.waitUntilProductPageLoads();

        Assert.assertTrue(productPage.addToCartButtonIsVisible());
    }
}
