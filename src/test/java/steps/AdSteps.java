package steps;

import base.BaseStep;
import custom_elements.AdListItem;
import io.cucumber.java.en.And;
import pages.base.AdListPage;

public class AdSteps extends BaseStep {

    @And("user opens {row} ad from list")
    public void userOpenAdFromList(Integer index) {
        AdListItem adListItem = AdListPage.tblAdList.getAd(index);
        saveData("ad description", adListItem.getDescription());
        saveData("ad price", adListItem.getPrice());
        adListItem.click();
    }
}
