import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayTest extends BaseTest{

    @Test
    public void playSong() throws InterruptedException {
        navigateToPage();
        provideEmail("anita.surewicz@testpro.io");
        providePassword("AnitaAnita1029");
        clickLoginButton();
        Thread.sleep(3000);

        clickPlayNextSong();
        clickPlayBtn();
        soundBarVisible();
    }

    public void clickPlayNextSong() throws InterruptedException {
        WebElement playNext = driver.findElement(By.xpath("//i[@role='button' and @title='Play next song']"));
        playNext.click();
        Thread.sleep(3000);
    }

    public void clickPlayBtn() throws InterruptedException {
        WebElement clickPlay = driver.findElement(By.xpath("//span[@role='button' and @title='Play or resume']"));
        clickPlay.click();
        Thread.sleep(3000);
    }

    public void soundBarVisible() {
        WebElement soundBar = driver.findElement(By.xpath("//img[@alt='Sound bars']"));
        Assert.assertTrue(soundBar.isDisplayed(), "If sound bar is visible, song is playing");
    }


}
