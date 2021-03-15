package elements;

import elements.base.BaseField;
import elements.base.ClickableField;
import org.openqa.selenium.By;

/**
 * Link. Clickable text field
 */
public class Link extends ClickableField {

    public Link(BaseField parent, By locator) {
        super(parent, locator);
    }

    public Link(By locator) {
        super(locator);
    }

}
