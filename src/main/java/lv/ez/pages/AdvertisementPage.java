package lv.ez.pages;

import lv.ez.util.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class AdvertisementPage extends SearchResultsPage {

    @FindBy(css = "#favs-link")
    private WebElement addToFavoritesLink;

    public AdvertisementPage() {
        PageFactory.initElements(WebDriverUtil.getCurrentDriver(), this);
        Assert.assertFalse(WebDriverUtil.getCurrentDriver().getTitle().isEmpty());
    }

    public AdvertisementPage clickAddToFavorites() {
        WebDriverUtil.driverWait()
                .until(ExpectedConditions.elementToBeClickable(addToFavoritesLink));
        addToFavoritesLink.click();
        return this;
    }
}
