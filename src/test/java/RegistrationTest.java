import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegistrationTest extends BaseTest {
    @Test
    public void registrationNavigation() {
        driver.get ("https://qa.koel.app/");
        driver.findElement(By.xpath("//a[@href='registration']")).click();

        String actualUrl = driver.getCurrentUrl();
        String expectedRegistrationUrl = "https://qa.koel.app/registration";

        Assert.assertEquals (actualUrl, expectedRegistrationUrl);

    }
}
