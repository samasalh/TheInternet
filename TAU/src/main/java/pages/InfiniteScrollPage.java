package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage {
    private WebDriver driver;
    private By textBlocks = By.className("jscroll-added");
    public InfiniteScrollPage(WebDriver driver){
        this.driver  = driver;
    }
    /**
     * Scrolls until paragraph with index specified is in view
     * @param index 1-based
     */

   // public void scrollToParagraph(int index){
     //   String script = "window.scrollTo(0, document.body.scrollHeight)";}
    private int getNumberOfParagraphsPresent(){
        return driver.findElements(textBlocks).size();
    }

    JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
    /**
     * Scrolls until paragraph with index specified is in view
     * @param index 1-based
     */
    public void scrollToParagraph(int index){
        String script = "window.scrollTo(0, document.body.scrollHeight)";
        JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;

        while(getNumberOfParagraphsPresent() < index){
            ((JavascriptExecutor) jsExecutor).executeScript(script);
        }
    }


}
