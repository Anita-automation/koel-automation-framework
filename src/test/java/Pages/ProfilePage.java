package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.UUID;

public class ProfilePage extends BasePage{
    public ProfilePage(WebDriver driver) {
        super(driver);
    }
    //This is the constructor for ProfilePage.
    //
    //When you write new ProfilePage(driver) in a test, this runs.
    //
    //It calls super(driver), which means:
    //
    //“Send this driver to BasePage so it can set everything up.”

    // Locators
    private By avatarIcon = By.cssSelector("img.avatar");
    private By currentPasswordField = By.cssSelector("[name='current_password']");
    private By profileNameField = By.cssSelector("[name='name']");
    private By saveButton = By.cssSelector("button.btn-submit");
    private By profileNameDisplay = By.cssSelector("a.view-profile > span");


    //METHODS
    // Navigate to profile, This method opens the profile page.
    //
    //It waits until the avatar icon is clickable.
    //
    //Then it clicks it.
    //
    //That action opens the profile/settings area
    public void openProfile() {
        waitForClickable(avatarIcon).click();
    }

    // Change profile name
    public void changeProfileName(String newName) {
        waitForVisible(currentPasswordField).clear();
        findElement(currentPasswordField).sendKeys("te$t$student");

        waitForVisible(profileNameField).clear();
        findElement(profileNameField).sendKeys(newName);

        waitForClickable(saveButton).click();
    }

    // Assertion helper
    public void verifyProfileNameUpdated(String expectedName) {
        String actual = waitForVisible(profileNameDisplay).getText();
        if (!actual.equals(expectedName)) {
            throw new AssertionError("Expected: " + expectedName + " but got: " + actual);
        }
    }

    // Utility. This method creates a random string you can use as a profile name.
    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
