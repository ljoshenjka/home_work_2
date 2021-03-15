package pages;

import elements.DropDown;
import elements.Link;
import org.openqa.selenium.By;
import pages.base.AdListPage;

public class FavouritesPage extends AdListPage {
    public static DropDown drpSelectAdDisplay = new DropDown(By.className("filter_sel"));
    public static Link lnkFavourites = new Link(By.cssSelector(".filter_second_line_dv .a1"));
    public static Link lnkRecentlyViewed = new Link(By.cssSelector(".filter_second_line_dv .a9a"));
}
