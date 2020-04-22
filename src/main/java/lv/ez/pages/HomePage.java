package lv.ez.pages;

import lv.ez.base.BasePage;
import lv.ez.util.WebDriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class HomePage extends BasePage {

    @FindBy(css = "#main_div li:nth-child(1) > span:nth-child(2) > a > h3")
    private WebElement vacanciesLink;

    public HomePage() {
        WebDriverUtil.getCurrentDriver().get(propertyReader.getHomeUrl());
        PageFactory.initElements(WebDriverUtil.getCurrentDriver(), this);
        Assert.assertFalse(WebDriverUtil.getCurrentDriver().getTitle().isEmpty());
    }

    public JobOfferPage openVacanciesSection() {
        WebDriverUtil.driverWait()
                .until(elementToBeClickable(vacanciesLink));
        vacanciesLink.click();
        return new JobOfferPage();
    }
}
