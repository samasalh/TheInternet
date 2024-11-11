package utils;

import org.openqa.selenium.WebDriver;

public class WindowManager {
    private WebDriver driver;

    public WindowManager(WebDriver driver){
        this.driver = driver;
        navigate = driver.navigate();
    }


    private WebDriver.Navigation navigate;

    public void goBack(){
        driver.navigate().back();
    }
    public void goForward(){
        navigate.forward();
    }

    public void refreshPage(){
        navigate.refresh();
    }

    public void goTo(String url){
        navigate.to(url);
    }

}
