import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Firefox {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
    }
    @Test
    public void isLogoDisplayedGoogle_Firefox(){
        boolean isLogoDisplayed = driver.findElement(By.cssSelector("#hplogo")).isDisplayed();
        Assert.assertTrue(isLogoDisplayed);
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
