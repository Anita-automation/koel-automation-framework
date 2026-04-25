package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // Existing locator
    By userAvatarIcon = By.cssSelector("img.avatar");

    public WebElement getUserAvatar() {
        return findElement(userAvatarIcon);
    }

    // NEW LOCATORS
    By playNextSongBtn = By.xpath("//i[@role='button' and @title='Play next song']");
    By playBtn = By.xpath("//span[@role='button' and @title='Play or resume']");
    By soundBar = By.xpath("//img[@alt='Sound bars']");

    // NEW METHODS
    public void clickPlayNextSong() {
        findElement(playNextSongBtn).click();
    }

    public void clickPlayButton() {
        findElement(playBtn).click();
    }

    public boolean isSoundBarVisible() {
        return findElement(soundBar).isDisplayed();
    }
}