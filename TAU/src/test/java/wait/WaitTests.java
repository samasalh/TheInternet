package wait;
import base.BaseTests;
import org.testng.annotations.Test;
import pages.DynamicLoadingExample1Page;
import pages.DynamicLoadingPage;

import static org.testng.AssertJUnit.assertEquals;

public class WaitTests extends BaseTests {
    @Test
    public void testWaitUntilHidden(){
        DynamicLoadingExample1Page loadingPage = homePage.clickDynamicLoading().clickExample1();
        ((DynamicLoadingExample1Page) loadingPage).clickStart();
        assertEquals("Hello World!", loadingPage.getLoadedText());
    }

}
