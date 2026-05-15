package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage extends BasePage { /*HomePage is a child of BasePage.
It inherits: driver wait and actions and helper methods*/


    public HomePage(WebDriver givenDriver) {
        super(givenDriver); /*the constructor for home page, when create home page object, pass driver into it, connects home page to the driver*/
    }

    // locator, tells selenium how to find avatar on the page
    By userAvatarIcon = By.cssSelector("img.avatar");

    //and the method for it, uses find element from BasePage, waits until it becomes visible, retuns the avator elemnt
    public WebElement getUserAvatar() {
        return findElement(userAvatarIcon);
    }

    //locator
    By playerFooter = By.cssSelector("footer.player");

    //method
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
    By profileMenu = By.cssSelector("a[title='View/edit user profile']");
    By logoutBtn = By.cssSelector("a[data-testid='btn-logout']");


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



    public boolean verifyLogoutBtnIsVisible() {

        return driver.findElement(logoutBtn).isDisplayed();
    }

    public void openProfile() {
        waitForClickable(profileMenu).click();
    }

    public boolean isRecentlyPlayedVisible() {
        return driver.findElement(recentlyPlayedSection).isDisplayed();

    }

    By recentlyPlayedSection = By.cssSelector("section.recent h1");

    public boolean isViewAllVisible() {
        return driver.findElement(viewAllButton).isDisplayed();
    }

    By viewAllButton = By.cssSelector("[data-testid='home-view-all-recently-played-btn']");

    public boolean isRecentlyAddedVisible() {
        return driver.findElement(recentlyAdded).isDisplayed();
    }

    By recentlyAdded = By.xpath("//h1[text()='Recently Added']");

    public LoginPage clickLogOutBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); //this is a variable - needs wait title
        wait.until(ExpectedConditions.elementToBeClickable(logoutBtn));
        findElement(logoutBtn).click();
        return new LoginPage(driver);}

    public WebElement getProfileButton() {
        return driver.findElement(profileMenu);
    }

    public WebElement getLogoutButton() {
        return driver.findElement(logoutBtn);
    }

    public WebElement getRecentlyPlayedSection() {
        return driver.findElement(recentlyPlayedSection);
    }

    public WebElement getViewAllButton() {
        return driver.findElement(viewAllButton);
    }

}