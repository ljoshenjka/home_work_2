package steps;

import base.BaseStep;
import exceptions.TestException;
import io.cucumber.java.en.When;
import pages.transport.CarsPage;
import pages.transport.TransportPage;

public class TransportSteps extends BaseStep {

    @When("^user opens '(Cars)' category from Transport page$")
    @When("^user opens '(Cargo cars)' category from Transport page$")
    @When("^user opens '(Moto transport)' category from Transport page$")
    public void userOpensCategoryFromTransportPage(String category) {
        switch (category) {
            case "Cars":
                TransportPage.lnkCars.click();
                break;
            case "Cargo cars":
                TransportPage.lnkCargoCars.click();
                break;
            case "Moto transport":
                TransportPage.lnkMotoTransport.click();
                break;
            default:
                throw new TestException("No such category on Transport page");
        }
    }

    @When("^user opens '(BMW)' category from Cars page$")
    @When("^user opens '(Audi)' category from Cars page$")
    @When("^user opens '(Skoda)' category from Cars page$")
    public void userOpensCategoryFromCarsPage(String category) {
        switch (category) {
            case "BMW":
                CarsPage.lnkBMW.click();
                break;
            case "Audi":
                CarsPage.lnkAudi.click();
                break;
            case "Skoda":
                CarsPage.lnkSkoda.click();
                break;
            default:
                throw new TestException("No such category on Cars page");
        }
    }
}
