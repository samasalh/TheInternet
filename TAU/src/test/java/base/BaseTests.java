package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.devtools.v128.filesystem.model.File;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class BaseTests {
        private WebDriver driver;
        protected HomePage homePage;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(getChromeOptions());
        //driver = new ChromeDriver("getChromeOptions()");
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
        goHome();
    }



    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }
    @AfterMethod
    public void recordFailure(ITestResult result) {

        if (ITestResult.FAILURE == result.getStatus()) {


            TakesScreenshot camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            // Ensure the directory exists
            File targetDirectory = new File("resources/screenshots/");
            if (!targetDirectory.exists()) {
                targetDirectory.mkdirs(); // Create the directory if it doesn't exist
            }
            try {
                Files.move(screenshot.toPath(), new File("resources/screenshots/test.png").toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }
    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        return options;
    }

            /* @AfterClass
             public void tearDown(){
                driver.quit();
            }*/

            //1 - Maximize the window
          //  driver.manage().window().maximize();

            //2 - Fullscreen mode
            //driver.manage().window().fullscreen();

            //3 - Specific width (show Chrome iPhoneX emulator)
           // Dimension size = new Dimension(375, 812);
           // driver.manage().window().setSize(size);
           // System.out.println(driver.getTitle());

            //finding elements
            //List<WebElement> links = driver.findElements(By.tagName("a"));
            //System.out.println(links.size());

            //4 finding element
           // WebElement inputsLink = driver.findElement(By.linkText("Inputs"));
           // inputsLink.click();

            //driver.quit();
        }



