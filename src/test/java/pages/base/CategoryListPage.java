package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.WebDriverUtil;

import java.util.List;

public abstract class CategoryListPage {
    public static List<String> getCategoryList() {
        List<WebElement> categoryElementList = WebDriverUtil.getElements(By.xpath("//a[@class='a_category']"));
        return WebDriverUtil.getStringListFromWebElementsList(categoryElementList);
    }
}
