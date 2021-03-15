package custom_elements;

import elements.base.BaseField;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import utils.WebDriverUtil;

import java.util.ArrayList;
import java.util.List;

public class AdList extends BaseField {

    public AdList(By locator) {
        super(locator);
    }

    public AdListItem getAd(int rowIndex) {
        return new AdListItem(this, By.xpath(String.format(".//tbody/tr[not(@id='head_line')][%s]", rowIndex)));
    }

    public Integer getAdCount() {
        WebElement we;
        try {
            we = getWebElement();
        } catch (NoSuchElementException e) {
            return 0;
        }
        return WebDriverUtil.getElementsOrEmpty(we, By.xpath(".//tbody/tr[not(@id='head_line')]")).size();
    }

    public List<AdListItem> getAds() {
        List<AdListItem> rows = new ArrayList<>();
        for (int i = 1; i <= getAdCount(); i++) {
            rows.add(getAd(i));
        }
        return rows;
    }
}
