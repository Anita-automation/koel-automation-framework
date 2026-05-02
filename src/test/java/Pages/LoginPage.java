package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    } /*CONSTRUCTOR - gives the login page a web driver,
    sends it BasePage, constructor - connects connects LoginPage to the browser.*/

    /*LOCATORS FOR PAGE ELEMENTS - describe how to find the email field, password field and click button on
    the webpage. This finds the element, locators using pageFactory from the BasePage
     */
    @FindBy(css = "input[type='email']")
    WebElement emailField;
    @FindBy(css = "input[type='password']")
    WebElement passwordField;
    @FindBy(css = "button[type='submit']")
    WebElement submitBtn;
    @FindBy(css = "form[data-testid='login-form']")
    WebElement loginForm;

    public WebElement getPasswordField() {
        return passwordField;
    } //gives password field if needed in a test

    /*METHODS TO INTERACT WITH THE WEBPAGE - goes back to the loginpage after method is executed
     */
    public LoginPage navigateToPage() {
        driver.get("https://qa.koel.app/"); // your Koel URL
        return this; //open login page and return means stay on the login page, can do loginPage.navigateToPage().provideEmail("x");, etc
    }

    public LoginPage provideEmail(String email) {
        emailField.sendKeys(email);
        return this; //Types the email into the email field. Returns the LoginPage so you can chain more actions
    }
    public LoginPage providePassword(String password) {
        passwordField.sendKeys(password);
        return this; //does the same for the password
    }
    public LoginPage clickSubmit() {
        submitBtn.click();
        return this;
    }

    public boolean isErrorState() {
        return loginForm.getAttribute("class").contains("error");
    }

    public boolean waitForErrorState() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        return wait.until(d -> loginForm.getAttribute("class").contains("error"));
    }

    /*FULL LOGIN METHOD - shortcut method, can just call loginPage.login(); good if the login details don't change */
    public void login() {
        provideEmail("anita.surewicz@testpro.io");
        providePassword("AnitaAnita1029");
        clickSubmit();
    }
}
