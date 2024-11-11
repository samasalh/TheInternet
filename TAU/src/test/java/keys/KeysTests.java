package keys;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.KeyPage;

import static org.testng.AssertJUnit.assertEquals;

public class KeysTests extends BaseTests {

    @Test
    public void testBackspace(){
        KeyPage keyPage = homePage.clickKeyPresses();
        keyPage.enterText("A" + Keys.BACK_SPACE);
        assertEquals(keyPage.getResult(), "You entered: BACK_SPACE");

    }
    @Test
    public void testPi(){
        KeyPage keyPage = homePage.clickKeyPresses();
        keyPage.enterPi();

    }


}
