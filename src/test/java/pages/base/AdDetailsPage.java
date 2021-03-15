package pages.base;

import elements.Button;
import elements.Label;
import elements.TextBox;
import org.openqa.selenium.By;

public class AdDetailsPage {
    public static TextBox txbDescription = new TextBox(By.id("msg_div_msg"));
    public static Label lblPrice = new Label(By.cssSelector("span.ads_price"));
    public static Button btnAddFavourites = new Button(By.id("a_fav"));
    public static Button btnAddCompare = new Button(By.id("a_add"));

}
