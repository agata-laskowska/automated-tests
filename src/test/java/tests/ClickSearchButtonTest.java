package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchResultsPage;
import pages.WebsiteHeaderPage;

public class ClickSearchButtonTest extends BaseTest {

    @Test
    public void clickSearchButton() {

        WebsiteHeaderPage websiteHeaderPage = new WebsiteHeaderPage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

        websiteHeaderPage.enterKeyword();
        websiteHeaderPage.clickSearchButton();

        Assert.assertTrue(searchResultsPage.firstProductContainsKeyword());
    }
}
