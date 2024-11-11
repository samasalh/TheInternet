package tests;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.WysiwygEditorPage;
import org.testng.Assert.*;

import static org.testng.AssertJUnit.assertEquals;

public class FrameTests  extends BaseTests {
    @Test

    public void testWysiwyg(){

        WysiwygEditorPage editorPage = homePage.clickWysiwygEditor();
        editorPage.clearTextArea();

        String text1 = "hello ";
        String text2 = "world";

        editorPage.setTextArea(text1);
        editorPage.decreaseIndention();
        editorPage.setTextArea(text2);

        assertEquals(  "Text from editor is incorrect", editorPage.getTextFromEditor());
    }
}



