package tests;



import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.*;

public class InvalidBookingTest extends BaseTest {

@Test
public void bookingWithoutNameTest() {

HomePage home = new HomePage(driver);

home.selectCities("Boston","London");
home.clickFindFlights();

FlightsPage flights = new FlightsPage(driver);

flights.chooseFlight();

PurchasePage purchase = new PurchasePage(driver);

purchase.enterDetails("", "Address", "New York", "123456");

purchase.purchase();

ConfirmationPage confirm = new ConfirmationPage(driver);

String msg = confirm.getConfirmationMessage();

Assert.assertTrue(msg.contains("Thank you"));

}

}
