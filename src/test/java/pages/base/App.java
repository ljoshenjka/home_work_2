package pages.base;

import constants.GlobalParams;
import elements.Label;
import elements.Link;
import org.openqa.selenium.By;
import utils.WaitUtil;
import utils.WebDriverUtil;

/**
 * Represents website main page
 */
public class App {

    private static final String xptMainMenu = "//*[@id='main_table']";
    public static Link lnkSubmitAd = new Link(By.xpath(xptMainMenu + "//a[contains(@href, '/new')]"));
    public static Link lnkMyMessages = new Link(By.xpath(xptMainMenu + "//a[contains(@href, '/login')]"));
    public static Link lnkSearch = new Link(By.xpath(xptMainMenu + "//a[contains(@href, '/search')]"));
    public static Link lnkMemo = new Link(By.xpath(xptMainMenu + "//a[contains(@href, '/favorites')]"));
    public static Link lnkLanguage = new Link(By.xpath(xptMainMenu + "//span[@class='menu_lang']/a"));
    public static Link lnkHeaderLogo = new Link(By.xpath("//a[./img[@class='page_header_logo']]"));

    public static Label lblMemoCount = new Label(By.id("mnu_fav_id"));

    public static void navigate() {
        WebDriverUtil.getDriver().navigate().to(GlobalParams.APP_URL);
        WaitUtil.waitForPageToLoad();
    }
}
