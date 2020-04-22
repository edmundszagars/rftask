package lv.ez.base;

import lv.ez.util.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BaseSearchPage extends BasePage {

    @FindBy(css = "#favorites_count")
    private WebElement myFavoritesCounterText;

    public BaseSearchPage() {
        PageFactory.initElements(WebDriverUtil.getCurrentDriver(), this);
    }

    public BaseSearchPage myFavoriteCounterShouldBe(String expectedAmount) {
        Assert.assertEquals(myFavoritesCounterText.getText(), expectedAmount);
        return this;
    }
}
