import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest { //starts the class, https://github.com/Test-Pro-Bootcamp/A81-QA-Automation-Framework/pull/21

    public static WebDriver driver; //This creates a browser variable that all tests can use. It will hold ChromeDriver once the browser is launched.
    public static String url; //This stores the website address (BaseURL) that your tests will open.
    //gets this info from From your testng.xml file, where you define the parameter. <suite name="MySuite">
    //    <parameter name="BaseURL" value="https://qa.koel.app/"/>
    public static WebDriverWait wait = null; //creates a wait helper, filled in befor methods
    public static Actions actions;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    } //Download the correct ChromeDriver version for this machine

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) { //this method receives the BaseURL from your TestNG XML file.
        ChromeOptions options = new ChromeOptions(); //creates object so can customize it later
        options.addArguments("--remote-allow-origins=*"); //adds setting to chrome - allows remote origins
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options); //starts chrome with the set options
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //allows the wait, automatically
        driver.manage().window().maximize();
        url = BaseURL; //Stores the BaseURL (from XML) into your url variable.

        wait = new WebDriverWait(driver, Duration.ofSeconds(40)); //wait mentioned as null in base test is initialized
        //can call on this if needed

        actions = new Actions(driver);
        navigateToPage(); //opens the page used the stored URL
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public void navigateToPage() {
        driver.get(url);
    }

}