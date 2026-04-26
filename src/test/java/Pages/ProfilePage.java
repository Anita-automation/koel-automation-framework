package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.UUID;

public class ProfilePage extends BasePage{
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private By avatarIcon = By.cssSelector("img.avatar");
    private By currentPasswordField = By.cssSelector("[name='current_password']");
    private By profileNameField = By.cssSelector("[name='name']");
    private By saveButton = By.cssSelector("button.btn-submit");
    private By profileNameDisplay = By.cssSelector("a.view-profile > span");

    // Navigate to profile
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

    // Utility
    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
