package utils;
import org.apache.hc.client5.http.entity.EntityBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.events.WebDriverListener;

public class EventReporter implements WebDriverEventListener {
    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("Clicking on: " + element.getText());
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        // Implement if you want any action after clicking
    }



}
