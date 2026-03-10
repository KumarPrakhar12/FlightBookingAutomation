package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.*;

public class PassengerValidationTest extends BaseTest {

    @Test(description="Verify passenger name appears on confirmation page")
    public void verifyPassengerName(){

        String passenger="John Doe";

        HomePage home=new HomePage(driver);

        home.selectCities("Boston","London");

        home.clickFindFlights();

        FlightsPage flights=new FlightsPage(driver);

        flights.chooseFlight();

        PurchasePage purchase=new PurchasePage(driver);

        purchase.enterDetails(passenger,"Street","NY","123456");

        purchase.purchase();

        ConfirmationPage confirm=new ConfirmationPage(driver);

        String message=confirm.getConfirmationMessage();

        Assert.assertTrue(message.contains("Thank you"));
    }
}