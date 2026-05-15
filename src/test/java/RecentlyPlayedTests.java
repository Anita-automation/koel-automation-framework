import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class RecentlyPlayedTests extends BaseTest {
    @Test
    public void downloadShuffleIconsVisible() {
        LoginPage loginPage = new LoginPage(driver); //create a LoginPage object and give it a browser
        HomePage homePage = new HomePage(driver);

        loginPage.login();

        WebElement album = driver.findElement(By.cssSelector("[data-test='album-card']"));
        //find the first album card on the poge
        Actions actions = new Actions(driver);
        //creates a tool called actions that lets you hover, drag, etc
        actions.moveToElement(album).perform();
        //move the mouse over the album card to make shuffle and download appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //creates a wait helper, wait 5 seconds for something to appear
        WebElement shuffle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fa-random")));
        WebElement download = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fa-download")));
        //wait until the icon becomes visible and store it in a variable
        assertTrue(shuffle.isDisplayed());
        assertTrue(download.isDisplayed());
    }

    @Test
    public void downloadAndShuffleIconsVisible() {
        LoginPage loginPage = new LoginPage(driver); //create a LoginPage object and give it a browser
        HomePage homePage = new HomePage(driver);

        loginPage.login();

        homePage.hoverFirstAlbum();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='album-card']")));

        assertTrue(homePage.isShuffleVisible());
        assertTrue(homePage.isDownloadVisible());
    }
}
