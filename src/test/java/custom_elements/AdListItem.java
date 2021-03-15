package custom_elements;

import elements.CheckBox;
import elements.Label;
import elements.base.ClickableField;
import org.openqa.selenium.By;

public class AdListItem extends ClickableField {

    //TODO: change locators to avoid indexes
    private final Label lblDescription = new Label(this, By.xpath(".//td[3]"));
    private final Label lblPrice = new Label(this, By.xpath(".//td[last()]"));
    public final CheckBox cbxSelect = new CheckBox(this, By.xpath(".//input[@type='checkbox']"));

    public AdListItem(AdList parent, By locator) {
        super(parent, locator);
    }

    public String getDescription() {
        return lblDescription.getValue();
    }

    public String getPrice() {
        return lblPrice.getValue();
    }
}
