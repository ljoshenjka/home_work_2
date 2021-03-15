package pages.transport;

import custom_elements.NumberedCategoryLink;
import org.openqa.selenium.By;
import pages.base.CategoryListPage;

public class CarsPage extends CategoryListPage {

    // Categories
    public static NumberedCategoryLink lnkBMW = new NumberedCategoryLink(By.cssSelector("a[href$='bmw/']"));
    public static NumberedCategoryLink lnkAudi = new NumberedCategoryLink(By.cssSelector("a[href$='audi/']"));
    public static NumberedCategoryLink lnkSkoda = new NumberedCategoryLink(By.cssSelector("a[href$='skoda/']"));
}
