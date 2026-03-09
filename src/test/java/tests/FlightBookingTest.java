package tests;

import org.testng.Assert;
import org.testng.annotations.*;

import base.BaseTest;
import pages.*;
import utils.ExcelReader;

//@Listeners(listeners.TestListener.class)

public class FlightBookingTest extends BaseTest {

@DataProvider(name="bookingData")

public Object[][] getData(){

return ExcelReader.getData("testdata/BookingData.xlsx","Sheet1");

}

@Test(dataProvider="bookingData")

public void bookFlight(

String from,
String to,
String name,
String address,
String city,
String card)

{
	
	listeners.TestListener.test.get().info(
			"Test Data Used : From=" + from +
			" To=" + to +
			" Passenger=" + name);

HomePage home=new HomePage(driver);

home.selectCities(from,to);

home.clickFindFlights();

FlightsPage flights=new FlightsPage(driver);

flights.chooseFlight();

PurchasePage purchase=new PurchasePage(driver);

purchase.enterDetails(name,address,city,card);

purchase.purchase();

ConfirmationPage confirm=new ConfirmationPage(driver);

String msg=confirm.getConfirmationMessage();

Assert.assertTrue(msg.contains("Thank you"));

}

}