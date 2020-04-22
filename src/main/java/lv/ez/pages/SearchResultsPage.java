package lv.ez.pages;

import lv.ez.base.BaseSearchPage;
import lv.ez.util.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBeMoreThan;

public class SearchResultsPage extends BaseSearchPage {

    public AdvertisementPage selectRandomAdvert() {
        List<WebElement> searchResults = getResults();
        List<WebElement> filteredResults = filterNonExternalAdvertisements(searchResults);
        int selectedITemIndex = ThreadLocalRandom.current().nextInt(filteredResults.size());
        WebElement selectedElement = filteredResults.get(selectedITemIndex);
        WebDriverUtil.scrollTo(selectedElement);
        selectedElement.click();
        return new AdvertisementPage();
    }

    private List<WebElement> filterNonExternalAdvertisements(List<WebElement> searchResults) {
        return searchResults.stream()
                .filter(webElement -> webElement.getText().equals(" "))
                .collect(Collectors.toList());
    }

    public SearchResultsPage addMultipleItemsToFavorites(int count) {
        List<WebElement> searchResults = getResults();
        List<WebElement> filteredResults = filterNonExternalAdvertisements(searchResults);
        if (filteredResults.size() < count) {
            throw new RuntimeException("There are not enough items in list to execute test");
        }
        for (int i = 0; i < count; i++) {
            WebElement selectedElement = filteredResults.get(i);
            WebDriverUtil.hover(selectedElement);
            WebElement addToFavoritesButton = WebDriverUtil.getCurrentDriver()
                    .findElement(
                            By.cssSelector("table#posts tr.over td:nth-child(9) div div.info a"));
            WebDriverUtil.driverWait().until(elementToBeClickable(addToFavoritesButton)).click();
        }
        return this;
    }

    private List<WebElement> getResults() {
        return WebDriverUtil.driverWait().until(
                numberOfElementsToBeMoreThan(
                        By.cssSelector("#posts tbody tr td"), 0));
    }
}
