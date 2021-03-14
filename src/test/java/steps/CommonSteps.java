package steps;

import base.BaseStep;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import pages.App;
import transform.RowConverter;

public class CommonSteps extends BaseStep {

    @ParameterType(name = "booleanConverter", value = "[^\"]*")
    public Boolean booleanConverter(String trueFalse) {
        return !trueFalse.toLowerCase().contains("no");
    }

    @ParameterType(name = "row", value = "first|second|third|fourth|fifth|sixth|seventh|eighth|ninth|tenth")
    public Integer row(String rowName) {
        return RowConverter.getIntegerValueFromWord(rowName);
    }

    @Given("user opens website")
    public void userOpensALink() {
        App.navigate();
    }
}
