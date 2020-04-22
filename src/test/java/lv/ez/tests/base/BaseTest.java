package lv.ez.tests.base;

import lv.ez.util.WebDriverUtil;
import org.testng.annotations.AfterTest;

public class BaseTest {

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        WebDriverUtil.close();
    }
}
