package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.MainMenuPage;

public class GoToSpecialPriceCategoryTest extends BaseTest {

    @Test
    public void goToSpecialPriceCategory() {
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);

        mainMenuPage.clickSelectedCategory(1);

        categoryPage.waitUntilCategoryPageHeadingIsVisible();

        String categoryHeaderTextBeforeClick = categoryPage.getTextOfCategoryPageHeading();

        categoryPage.clickSpecialPriceCategoryBlock();
        categoryPage.waitUntilSpecialPriceCategoryHeadingIsVisible();

        String categoryHeaderTextAfterClick = categoryPage.getTextOfSpecialPriceCategoryPageHeading();

        Assert.assertNotEquals(categoryHeaderTextBeforeClick, categoryHeaderTextAfterClick);
    }
}
