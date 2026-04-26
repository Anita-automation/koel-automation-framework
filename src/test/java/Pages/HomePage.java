package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // Existing locator
    By userAvatarIcon = By.cssSelector("img.avatar");

    public WebElement getUserAvatar() {
        return findElement(userAvatarIcon);
    }

    By playerFooter = By.cssSelector("footer.player");

    public void hoverOverPlayer() {
        hoverOver(playerFooter);
    }

    public void waitUntilLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userAvatarIcon));
    }

    // NEW LOCATORS
    By playNextSongBtn = By.cssSelector("[data-testid='play-next-btn']");
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