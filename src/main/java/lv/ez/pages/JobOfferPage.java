package lv.ez.pages;

import lv.ez.base.BasePage;
import lv.ez.util.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class JobOfferPage extends BasePage {

    @FindBy(id = "f_bigtext")
    private WebElement searchInputTextField;

    @FindBy(css = "form#frmFilter div.submitContainer > input[name='btnSearch']")
    private WebElement searchButton;


    public JobOfferPage() {
        PageFactory.initElements(WebDriverUtil.getCurrentDriver(), this);
        Assert.assertEquals(
                "Reklama.lv - Vakances / Darbs, bizness",
                WebDriverUtil.getCurrentDriver().getTitle());
    }

    public SearchResultsPage searchFor(String query) {
        searchInputTextField.click();
        searchInputTextField.clear();
        searchInputTextField.sendKeys(query);
        searchButton.click();
        return new SearchResultsPage();
    }
}
