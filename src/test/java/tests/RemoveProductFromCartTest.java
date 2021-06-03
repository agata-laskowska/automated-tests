package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartLayerPage;
import pages.HomePage;
import pages.MiniCartPage;

public class RemoveProductFromCartTest extends BaseTest {

    @Test
    public void removeFromCart() {
        HomePage homePage = new HomePage(driver);
        CartLayerPage cartLayerPage = new CartLayerPage(driver);
        MiniCartPage miniCartPage = new MiniCartPage(driver);

        homePage.hoverProduct();
        homePage.addToCart();

        cartLayerPage.waitUntilAddedToCartNotificationIsVisible();
        cartLayerPage.closeCart();

        miniCartPage.hoverShoppingCart();
        miniCartPage.waitUntilRemoveFromCartButtonIsVisible();
        miniCartPage.removeProductFromMinicart();
        miniCartPage.waitUntilEmptyCartMessageIsVisible();

        Assert.assertTrue(miniCartPage.cartIsEmpty());
    }
}
