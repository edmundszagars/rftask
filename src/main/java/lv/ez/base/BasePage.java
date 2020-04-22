package lv.ez.base;

import lv.ez.util.PropertyReader;
import lv.ez.util.WebDriverUtil;

public class BasePage {

    protected static PropertyReader propertyReader = new PropertyReader();
    protected static WebDriverUtil webDriverUtil = new WebDriverUtil();
    protected BasePage() {
    }
}
