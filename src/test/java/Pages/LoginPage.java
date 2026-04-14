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
    
    /*METHODS TO INTERACT WITH THE WEBPAGE
     */
    public void provideEmail(String email) {
        emailField.sendKeys(email);
    }
    public void providePassword(String password) {
        passwordField.sendKeys(password);
    }
    public void clickSubmit() {
        submitBtn.click();
    }
    /*FULL LOGIN METHOD - shortcut method, can just call login() to login*/
    public void login() {
        provideEmail("anita.surewicz@testpro.io");
        providePassword("AnitaAnita1029");
        clickSubmit();
    }
}
