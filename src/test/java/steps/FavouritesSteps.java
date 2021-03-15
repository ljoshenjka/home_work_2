package steps;

import base.BaseStep;
import custom_elements.AdListItem;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.FavouritesPage;
import pages.base.App;

import java.util.List;

public class FavouritesSteps extends BaseStep {

    @Then("checks that Memo count in header is {string}")
    public void checksThatMemoCountInHeaderIs(String memoValue) {
        Assert.assertEquals("Wrong Memo count value in website header", memoValue, App.lblMemoCount.getValue());
    }

    @Then("checks that correct Ad is present in Favourites")
    public void checksThatCorrectAdIsPresentInFavourites() {
        String expectedAdDescription = getStringData("ad description");
        String expectedAdPrice = getStringData("ad price");

        List<AdListItem> adListItemList = FavouritesPage.tblAdList.getAds();
        AdListItem expectedItem = null;
        for (AdListItem adItem : adListItemList) {
            if (adItem.getDescription().contains(expectedAdDescription)) {
                expectedItem = adItem;
                break;
            }
        }
        Assert.assertNotNull("Ad not found in favourites", expectedItem);
        Assert.assertEquals("Wrong Ad price", expectedAdPrice, expectedItem.getPrice());
    }
}
