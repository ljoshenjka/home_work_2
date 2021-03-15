package steps;

import base.BaseStep;
import custom_elements.AdListItem;
import exceptions.TestException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.base.AdDetailsPage;
import pages.base.AdListPage;
import pages.base.App;

public class AdSteps extends BaseStep {

    @And("user opens {row} ad from list")
    public void userOpenAdFromList(Integer index) {
        AdListItem adListItem = AdListPage.tblAdList.getAd(index);
        saveData("ad description", adListItem.getDescription());
        saveData("ad price", adListItem.getPrice());
        adListItem.click();
    }

    @And("user adds Ad to favourites")
    public void userAddsAdToFavourites() {
        userClicksButtonOnAdDetailsPage("Add to favourites");
        CommonSteps.userConfirmDialog();
    }

    @And("^user clicks '(Add to favourites)' button on Ad Details page$")
    public void userClicksButtonOnAdDetailsPage(String button) {
        switch (button) {
            case "Add to favourites":
                AdDetailsPage.btnAddFavourites.click();
                break;
            case "Add to compare":
                AdDetailsPage.btnAddCompare.click();
                break;
            default:
                throw new TestException("No such button on Ad Details page: " + button);
        }
    }

    @Then("checks that 'Added to favourites' dialog shown")
    public void checksThatAddedToFavouritesDialogShown() {
        Assert.assertTrue("'Added to favourites' dialog not shown", App.dlgAttention.isDisplayed());
        Assert.assertEquals("Wrong dialog header", "Attention", App.dlgAttention.lblHeader.getValue());
        Assert.assertEquals("Wrong dialog message", "Advertisement added to favorites.", App.dlgAttention.lblMsg.getValue());
    }

    @When("user select {row} ad from list")
    public void userSelectAdFromList(Integer index) {
        AdListItem adListItem = AdListPage.tblAdList.getAd(index);
        saveData("ad description", adListItem.getDescription());
        saveData("ad price", adListItem.getPrice());
        adListItem.cbxSelect.setSelected();
    }

    @And("^user clicks '(Add to favourites)' button on Ad List page$")
    public void userClicksButtonOnAdListPage(String button) {
        switch (button) {
            case "Add to favourites":
                AdListPage.btnAddSelectedToMemo.click();
                break;
            case "Add to compare":
                AdListPage.btnAddSelectedToCompare.click();
                break;
            default:
                throw new TestException("No such button on Ad List page: " + button);
        }
    }
}
