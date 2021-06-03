package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;
import pages.SignInPage;

public class UnsuccessfulSignInTest extends BaseTest{

    @Test
    public void unsuccessfulSignIn() {
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = new SignInPage(driver, testData);
        AccountPage accountPage = new AccountPage(driver);

        homePage.waitUntilSignInButtonIsClickable();
        homePage.clickSignInButton();

        signInPage.waitUntilSignInPageLoads();
        signInPage.fillInLoginForm("wrongPassword");

        Assert.assertTrue(signInPage.errorMessageIsDisplayed());
    }
}
