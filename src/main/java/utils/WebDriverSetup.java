package utils;

import constants.GlobalParams;
import constants.PropertyConfigs;
import exceptions.TestException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverSetup {

    public static WebDriver setupWebDriver(String driverType) throws MalformedURLException {
        WebDriver driver;
        switch (driverType) {
            case PropertyConfigs.FIREFOX: {
                WebDriverManager.firefoxdriver().setup();
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                driver = new FirefoxDriver(getFirefoxOptions());
                break;
            }
            case PropertyConfigs.CHROME: {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(getChromeOptions());
                break;
            }
            case PropertyConfigs.EDGE: {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver(getEdgeOptions());
                break;
            }
            case PropertyConfigs.IE: {
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver(getInternetExplorerOptions());
                break;
            }
            case PropertyConfigs.SAFARI: {
                driver = new SafariDriver(getSafariOptions());
                break;
            }
            default:
                throw new TestException("Invalid driver type: " + driverType);
        }
        return driver;
    }

    public static RemoteWebDriver setupRemoteWebDriver(String driverType) throws MalformedURLException {
        RemoteWebDriver remoteWebDriver;
        switch (driverType) {
            case PropertyConfigs.FIREFOX:
                remoteWebDriver = new RemoteWebDriver(new URL(GlobalParams.SELENIUM_HUB_LINK), getFirefoxOptions());
                break;
            case PropertyConfigs.CHROME:
                remoteWebDriver = new RemoteWebDriver(new URL(GlobalParams.SELENIUM_HUB_LINK), getChromeOptions());
                break;
            case PropertyConfigs.EDGE:
                remoteWebDriver = new RemoteWebDriver(new URL(GlobalParams.SELENIUM_HUB_LINK), getEdgeOptions());
                break;
            case PropertyConfigs.IE:
                remoteWebDriver = new RemoteWebDriver(new URL(GlobalParams.SELENIUM_HUB_LINK), getInternetExplorerOptions());
                break;
            case PropertyConfigs.SAFARI:
                remoteWebDriver = new RemoteWebDriver(new URL(GlobalParams.SELENIUM_HUB_LINK), getSafariOptions());
                break;
            default:
                throw new TestException("Invalid remote driver type: " + driverType);
        }
        remoteWebDriver.setFileDetector(new LocalFileDetector());
        return remoteWebDriver;
    }

    private static ChromeOptions getChromeOptions() {
        return new ChromeOptions();
    }

    private static FirefoxOptions getFirefoxOptions() {
        return new FirefoxOptions();
    }

    private static InternetExplorerOptions getInternetExplorerOptions() {
        return new InternetExplorerOptions();
    }

    private static EdgeOptions getEdgeOptions() {
        return new EdgeOptions();
    }

    private static SafariOptions getSafariOptions() {
        return new SafariOptions();
    }
}
