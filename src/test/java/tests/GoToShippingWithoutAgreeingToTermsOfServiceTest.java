package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class GoToShippingWithoutAgreeingToTermsOfServiceTest extends BaseTest{

    @Test
    public void goToShippingWithoutAgreeingToTermsOfService() {
        HomePage homePage = new HomePage(driver);
        CartLayerPage cartLayerPage = new CartLayerPage(driver);
        MiniCartPage miniCartPage = new MiniCartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        SignInPage signInPage = new SignInPage(driver, testData);
        SelectDeliveryAddressPage selectDeliveryAddressPage = new SelectDeliveryAddressPage(driver);
        ShippingPage shippingPage = new ShippingPage(driver);

        homePage.hoverProduct();
        homePage.addToCart();

        cartLayerPage.waitUntilAddedToCartNotificationIsVisible();
        cartLayerPage.closeCart();

        miniCartPage.hoverShoppingCart();
        miniCartPage.goToCheckout();

        checkoutPage.waitUntilCheckoutPageLoads();
        checkoutPage.proceedToLogin();

        signInPage.waitUntilSignInPageLoads();
        signInPage.fillInLoginForm("rightPassword");

        selectDeliveryAddressPage.waitUntilGoToNextStepButtonIsVisible();
        selectDeliveryAddressPage.goToNextStep();

        shippingPage.waitUntilAgreementCheckboxIsVisible();
        shippingPage.goToPayment();

        Assert.assertTrue(shippingPage.alertIsVisible());
    }
}
