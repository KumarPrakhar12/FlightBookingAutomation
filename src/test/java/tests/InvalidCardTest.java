package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.*;

public class InvalidCardTest extends BaseTest {

    @Test(description="Verify booking behavior with invalid credit card number")
    public void invalidCardTest(){

        HomePage home=new HomePage(driver);

        home.selectCities("Boston","London");

        home.clickFindFlights();

        FlightsPage flights=new FlightsPage(driver);

        flights.chooseFlight();

        PurchasePage purchase=new PurchasePage(driver);

        purchase.enterDetails("Test","Address","NY","INVALID");

        purchase.purchase();

        Assert.assertTrue(driver.getPageSource().contains("Thank"));
    }
}