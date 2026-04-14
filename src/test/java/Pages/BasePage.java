package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage { /*starts the class*/
    WebDriver driver; /*creates a variable to store the WebDriver. Every page and object will use it*/
    WebDriverWait wait; /*creates a variable to store an explicit wait*/
    Actions actions; /*creates a variable to store an action object*/

    /*CONSTRUCTOR* It runs automatically when a new page is created*/

    public BasePage( WebDriver givenDriver) {
        driver = givenDriver; /*stores the driver passed into the constructor*/
        wait = new WebDriverWait(driver, Duration.ofSeconds(5)); /*creates a wait that will wait up to 5 s for elements*/
        actions = new Actions(driver); /*creates an actions object so can perform actions*/
    }

    public WebElement findElement(By locator) { /*creates an element that finds an element using a locator*/
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); /*waits until element becomes visible and then returns it */
    }

}