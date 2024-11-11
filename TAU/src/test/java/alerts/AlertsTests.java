package alerts;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.AlertsPage;
import org.testng.Assert.*;

import static org.testng.AssertJUnit.assertEquals;

public class AlertsTests extends BaseTests {
    @Test
    public void testAcceptAlert(){
      AlertsPage alertsPage =  homePage.clickJavaScriptAlerts();
      alertsPage.triggerAlert();
      alertsPage.alert_clickToAccept();
      assertEquals("You successfully clicked an alert", alertsPage.getResult());

    }

    @Test
    public void testGetTextFromAlert(){

        AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerConfirm();
        String text = alertsPage.alert_getText();
        alertsPage.alert_clickToDismiss();

        assertEquals("I am a JS Confirm", text);
    }
    @Test
    public void testSetInputInAlert(){
        AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerPrompt();
        String text = "TAU rocks!";
        alertsPage.alert_setInput(text);
        alertsPage.alert_clickToAccept();
        assertEquals("You entered: " +  text, alertsPage.getResult());
    }
}
