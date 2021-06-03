package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebsiteHeaderPage;
import pages.SearchResultsPage;

public class SearchProductTest extends BaseTest {

    @Test
    public void searchProduct() {
        WebsiteHeaderPage websiteHeaderPage = new WebsiteHeaderPage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

        websiteHeaderPage.enterKeyword();
        websiteHeaderPage.search();

        Assert.assertTrue(searchResultsPage.firstProductContainsKeyword());

    }
}
