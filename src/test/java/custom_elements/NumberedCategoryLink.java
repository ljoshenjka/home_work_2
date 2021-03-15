package custom_elements;

import elements.Label;
import elements.Link;
import org.openqa.selenium.By;

public class NumberedCategoryLink extends Link {

    private final Label lblCount = new Label(this, By.xpath("./following-sibling::span"));

    public NumberedCategoryLink(By locator) {
        super(locator);
    }

    public Integer getCount() {
        String count = lblCount.getValue().replace("(", "").replace(")", "");
        return Integer.parseInt(count);
    }
}
