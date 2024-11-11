package alerts;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.UploadPage;
import static org.testng.AssertJUnit.assertEquals;

public class FileUploadTests extends BaseTests {
    @Test
    public void testFileUpload(){
        UploadPage uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile("C:\\Users\\pc\\IdeaProjects\\TAU\\pom.xml");
        assertEquals( "pom.xml", uploadPage.getUploadedFiles());

    }
}
