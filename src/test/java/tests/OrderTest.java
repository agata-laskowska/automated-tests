package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class OrderTest extends BaseTest {

    @Test
    public void order() {
        HomePage homePage = new HomePage(driver);
        CartLayerPage cartLayerPage = new CartLayerPage(driver);
        MiniCartPage miniCartPage = new MiniCartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        SignInPage signInPage = new SignInPage(driver, testData);
        SelectDeliveryAddressPage selectDeliveryAddressPage = new SelectDeliveryAddressPage(driver);
        ShippingPage shippingPage = new ShippingPage(driver);
        PaymentPage paymentPage = new PaymentPage(driver);
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);

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
        shippingPage.agreeToTermsOfService();
        shippingPage.goToPayment();

        paymentPage.waitUntilBankTransferButtonIsVisible();
        paymentPage.payByBankTransfer();

        orderConfirmationPage.waitUntilOrderConfirmationButtonIsVisible();
        orderConfirmationPage.confirmOrder();

        String orderConfirmationMessage = orderConfirmationPage.getTextOfOrderConfirmationMessage();

        Assert.assertEquals(orderConfirmationMessage, "Your order on My Store is complete.");
    }
}
