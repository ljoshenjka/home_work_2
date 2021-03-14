package pages;

import constants.GlobalParams;
import utils.WaitUtil;
import utils.WebDriverUtil;

/**
 * Represents website main page
 */
public class App {
    /**
     * Opens the main page
     */
    public static void navigate() {
        WebDriverUtil.getDriver().navigate().to(GlobalParams.APP_URL);
        WaitUtil.waitForPageToLoad();
    }
}
