package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.*;

public class EmptyAddressTest extends BaseTest {

@Test(description="Verify booking behavior when address field is empty")
public void verifyEmptyAddress(){

HomePage home = new HomePage(driver);

home.selectCities("Boston","London");

home.clickFindFlights();

FlightsPage flights = new FlightsPage(driver);

flights.chooseFlight();

PurchasePage purchase = new PurchasePage(driver);

purchase.enterDetails("John", "", "NY", "123456");

purchase.purchase();

String page = driver.getPageSource();

Assert.assertTrue(page.contains("Thank"));

}

}