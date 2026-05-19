package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage { /*starts the BasePage class, every page will extend it*/
    WebDriver driver; /*creates a variable to store the WebDriver (or browser). Every page and object will use it*/
    WebDriverWait wait; /*creates a variable to store an explicit wait, wait for element*/
    Actions actions; /*creates a variable to store an action object like hover or drag*/

    /*CONSTRUCTOR* It runs automatically when a new page is created, connects the page to the driver - new LoginPage(driver);*/

    public BasePage( WebDriver givenDriver) {
        driver = givenDriver; /*stores the driver passed into the constructor, whatever driver you pass, the constructor will store it*/
        wait = new WebDriverWait(driver, Duration.ofSeconds(5)); /*creates a wait that will wait up to 5 s for elements*/
        actions = new Actions(driver); /*creates an actions object so can perform actions*/
        PageFactory.initElements(driver, this); /*tells the thing to return to the same page after action, This tells Selenium to scan the page for @FindBy elements and initialize them.*/
    }

    /*REUSABLE HELPER METHODS*/

    public WebElement findElement(By locator) { /*creates an element that finds an element using a locator*/
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); /*waits until element becomes visible and then returns it */
    }

    public void hoverOver(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.moveToElement(element).perform();
    }

    public WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean isVisible(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}