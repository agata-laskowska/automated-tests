package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartLayerPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.MiniCartPage;

public class DeleteProductFromCheckoutTest extends BaseTest {

    @Test
    public void deleteProductFromCheckout() {
        HomePage homePage = new HomePage(driver);
        CartLayerPage cartLayerPage = new CartLayerPage(driver);
        MiniCartPage miniCartPage = new MiniCartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        homePage.hoverProduct();
        homePage.waitUntilAddToCartButtonIsVisible();
        homePage.addToCart();

        cartLayerPage.waitUntilAddedToCartNotificationIsVisible();
        cartLayerPage.closeCart();

        miniCartPage.hoverShoppingCart();
        miniCartPage.goToCheckout();

        checkoutPage.waitUntilCheckoutPageLoads();
        checkoutPage.deleteProduct();
        checkoutPage.waitUntilEmptyCartAlertIsVisible();

        Assert.assertTrue(checkoutPage.emptyCartAlertIsVisible());
    }
}
