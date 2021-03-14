package hook;

import constants.GlobalParams;
import constants.PropertyConfigs;
import helpers.LogHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import utils.ConfigReader;
import utils.WebDriverSetup;
import utils.WebDriverUtil;

import java.net.MalformedURLException;

public class Hook {

    private boolean shutdown = true;
    private static boolean initializeShutdownHook = true;

    static {
        LogHelper.getLogger().info("URL: " + ConfigReader.getInstance().getValue(PropertyConfigs.APP_URL));
    }

    @Before(order = 1)
    public void initialize(Scenario scenario) throws MalformedURLException {
        if (WebDriverUtil.getDriver() != null) {
            // reuse previously created web driver instance if present
            try {
                WebDriverUtil.getDriver().getTitle();
            } catch (WebDriverException wde) {
                LogHelper.getLogger().error("Some error in existing driver: ", wde);
                try {
                    WebDriverUtil.getDriver().quit();
                } catch (Exception e) {
                    LogHelper.getLogger().error("Some error on driver quit: ", e);
                }
                WebDriverUtil.setDriver(null);
            }
        } else {
            // create new web driver instance
            if (GlobalParams.IS_REMOTE) {
                LogHelper.getLogger().info("Open remote browser: " + GlobalParams.SELENIUM_DRIVER);
                WebDriverUtil.setDriver(WebDriverSetup.setupRemoteWebDriver(GlobalParams.SELENIUM_DRIVER));
            } else {
                LogHelper.getLogger().info("Open browser: " + GlobalParams.SELENIUM_DRIVER);
                WebDriverUtil.setDriver(WebDriverSetup.setupWebDriver(GlobalParams.SELENIUM_DRIVER));
            }
            WebDriverUtil.setImplicitWait();
            WebDriverUtil.maximize();
        }
        LogHelper.getLogger().info("Scenario '" + scenario.getName() + "' STARTED");
    }

    @Before(order = 2)
    public void shutdownHook() {
        if (initializeShutdownHook && !GlobalParams.IS_FROM_MAVEN) {
            Runtime.getRuntime().addShutdownHook(new Thread() {
                final WebDriver driver = WebDriverUtil.getDriver();

                public void run() {
                    if (shutdown) {
                        LogHelper.getLogger().info("Close browser in addShutdownHook");
                        driver.quit();
                    }
                }
            });
            initializeShutdownHook = false;
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        LogHelper.getLogger().info("Scenario '" + scenario.getName() + "' " + scenario.getStatus().toString());
        if (WebDriverUtil.getDriver() != null) {
            WebDriverUtil.getDriver().manage().deleteAllCookies();
        }
    }
}
