package custom_elements;

import elements.Button;
import elements.Label;
import elements.base.BaseField;
import org.openqa.selenium.By;

public class Dialog extends BaseField {

    public Label lblHeader = new Label(this, By.className("alert_head_left"));
    public Button btnClose = new Button(this, By.className("alert_head_right"));
    public Label lblMsg = new Label(this, By.id("alert_msg"));
    public Button btnConfirm = new Button(this, By.id("alert_ok"));

    public Dialog(By locator) {
        super(locator);
    }
}
