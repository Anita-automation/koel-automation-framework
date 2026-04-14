package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    } /*CONSTRUCTOR - gives the login page a web driver,
    sends it BasePage*/

    /*LOCATORS FOR PAGE ELEMENTS - describe how to find the email field, password field and click button on
    the webpage
     */
    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By submitBtn = By.cssSelector("button[type='submit']");

    /*METHODS TO INTERACT WITH THE WEBPAGE - fine the email filed, type the email into it, find the password field
    and type the password into it. Click submit.
     */
    public void provideEmail(String email) {
        findElement(emailField).sendKeys(email);
    }
    public void providePassword(String password) {
        findElement(passwordField).sendKeys(password);
    }
    public void clickSubmit() {
        findElement(submitBtn).click();
    }
    /*FULL LOGIN METHOD - shortcut method, can just call login() to login*/
    public void login() {
        provideEmail("anita.surewicz@testpro.io");
        providePassword("AnitaAnita1029");
        clickSubmit();
    }
}
