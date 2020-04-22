package lv.ez.tests;

import lv.ez.pages.HomePage;
import lv.ez.tests.base.BaseTest;
import org.testng.annotations.Test;

public class AddToFavoritesTest extends BaseTest {

    @Test
    public void addToFavoritesFromAdPageTest() {
        new HomePage()
                .openVacanciesSection()
                .searchFor("Darbs")
                .selectRandomAdvert()
                .clickAddToFavorites()
                .myFavoriteCounterShouldBe("1");
    }

    @Test
    public void addMultipleAddsFromListToFavoriteTest(){
        new HomePage()
                .openVacanciesSection()
                .searchFor("Darbs")
                .addMultipleItemsToFavorites(5)
                .myFavoriteCounterShouldBe("5");
    }

}
