package utils;

import constants.GlobalParams;
import helpers.LogHelper;
import org.awaitility.Awaitility;
import org.awaitility.core.ConditionFactory;
import org.openqa.selenium.WebDriverException;

import java.time.Duration;
import java.util.concurrent.Callable;

public class WaitUtil {

    public static ConditionFactory await(String msg, int timeout) {
        return Awaitility.await(msg)
                .atMost(Duration.ofSeconds(timeout))
                .pollInSameThread()
                .pollInterval(Duration.ofMillis(500))
                .pollDelay(Duration.ZERO)
                .ignoreExceptionsInstanceOf(WebDriverException.class);
    }

    public static void waitUntil(Callable<Boolean> condition) {
        await(null, GlobalParams.WAIT_APP).until(condition);
    }

    public static void waitUntil(Callable<Boolean> condition, String msg) {
        await(msg, GlobalParams.WAIT_APP).until(condition);
    }

    public static void waitUntilWithTimeout(Callable<Boolean> condition, int timeout) {
        await(null, timeout).until(condition);
    }

    public static void waitUntilWithTimeout(Callable<Boolean> condition, String msg, int timeout) {
        await(msg, timeout).until(condition);
    }

    public static void waitForPageToLoad() {
        // wait for jQuery requests to finish
        Callable<Boolean> jQueryLoad = () -> {
            try {
                return ((Long) WebDriverUtil.getJsExecutor().executeScript("return jQuery.active") == 0);
            } catch (Exception e) {
                // no jQuery present
                return true;
            }
        };
        // wait for Page to load
        Callable<Boolean> jsLoad = () -> {
            try {
                return WebDriverUtil.getJsExecutor().executeScript("return document.readyState").toString().equals("complete");
            } catch (Exception e) {
                // shit happened
                LogHelper.getLogger().error("Some error in Wait for Page to load JS: " + e.getMessage());
                return false;
            }
        };
        waitUntil(jsLoad, "Page not loaded");
        waitUntil(jQueryLoad, "jQuery requests not finished");
    }
}
