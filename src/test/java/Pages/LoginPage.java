package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    } /*CONSTRUCTOR - gives the login page a web driver,
    sends it BasePage*/

    /*LOCATORS FOR PAGE ELEMENTS - describe how to find the email field, password field and click button on
    the webpage. This finds the element
     */
    @FindBy(css = "input[type='email']")
    WebElement emailField;
    @FindBy(css = "input[type='password']")
    WebElement passwordField;
    @FindBy(css = "button[type='submit']")
    WebElement submitBtn;

    /*METHODS TO INTERACT WITH THE WEBPAGE - goes back to the loginpage after method is executed
     */
    public LoginPage provideEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }
    public LoginPage providePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage clickSubmit() {
        submitBtn.click();
        return this;
    }
    /*FULL LOGIN METHOD - shortcut method, can just call login() to login*/
    public void login() {
        provideEmail("anita.surewicz@testpro.io");
        providePassword("AnitaAnita1029");
        clickSubmit();
    }
}
