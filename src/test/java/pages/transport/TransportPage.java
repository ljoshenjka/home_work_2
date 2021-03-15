package pages.transport;

import custom_elements.NumberedCategoryLink;
import org.openqa.selenium.By;
import pages.base.CategoryListPage;

public class TransportPage extends CategoryListPage {

    // Categories
    public static NumberedCategoryLink lnkCars = new NumberedCategoryLink(By.cssSelector("a[href$='cars/']"));
    public static NumberedCategoryLink lnkCargoCars = new NumberedCategoryLink(By.cssSelector("a[href$='cargo-cars/']"));
    public static NumberedCategoryLink lnkMotoTransport = new NumberedCategoryLink(By.cssSelector("a[href$='moto-transport/']"));
}
