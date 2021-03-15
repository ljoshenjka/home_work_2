package pages;

import elements.Link;
import org.openqa.selenium.By;

public class HomePage {

    // Main categories
    private static final String xptMainCategory = "//a[contains(@href, '/%s') and @class='a1']";
    public static Link lnkJobAndBusiness = new Link(By.xpath(String.format(xptMainCategory, "work")));
    public static Link lnkTransport = new Link(By.xpath(String.format(xptMainCategory, "transport")));
    public static Link lnkRealEstate = new Link(By.xpath(String.format(xptMainCategory, "real-estate")));
    public static Link lnkConstruction = new Link(By.xpath(String.format(xptMainCategory, "construction")));
    public static Link lnkElectronics = new Link(By.xpath(String.format(xptMainCategory, "electronics")));
    public static Link lnkClothesFootwear = new Link(By.xpath(String.format(xptMainCategory, "clothes-footwear")));
    public static Link lnkForHome = new Link(By.xpath(String.format(xptMainCategory, "home-stuff")));
    public static Link lnkProductionWork = new Link(By.xpath(String.format(xptMainCategory, "production-work")));
    public static Link lnkForChildren = new Link(By.xpath(String.format(xptMainCategory, "for-children")));
    public static Link lnkAnimals = new Link(By.xpath(String.format(xptMainCategory, "animals")));
    public static Link lnkAgriculture = new Link(By.xpath(String.format(xptMainCategory, "agriculture")));
    public static Link lnkRestHobbies = new Link(By.xpath(String.format(xptMainCategory, "entertainment")));
}
