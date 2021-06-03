package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class SubscribeToNewsletterTest extends BaseTest {

    @Test
    public void subscribeToNewsletter() {

        HomePage homePage = new HomePage(driver);

        homePage.waitUntilHomepageSliderIsVisible();
        homePage.enterRandomEmailIntoNewsletterInput();
        homePage.subscribeToNewsletter();

        Assert.assertTrue(homePage.successfulNewsletterSubscriptionAlertIsVisible());
    }
}
