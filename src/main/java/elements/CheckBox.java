package elements;

import elements.base.BaseField;
import elements.base.ClickableField;
import org.openqa.selenium.By;

/**
 * Button
 */
public class CheckBox extends ClickableField {

    public CheckBox(BaseField parent, By locator) {
        super(parent, locator);
    }

    public CheckBox(By locator) {
        super(locator);
    }

    public Boolean isSelected() {
        return getWebElement().isSelected();
    }

    public void setSelected() {
        if (!isSelected()) {
            click();
        }
    }

    public void unSelect() {
        if (isSelected()) {
            click();
        }
    }
}
