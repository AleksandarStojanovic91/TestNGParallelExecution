import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ParallelExecution {
    public WebDriver driver;
    @Test
    public void ChromeTest(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        boolean isLogoDisplayed = driver.findElement(By.cssSelector("#hplogo")).isDisplayed();
        Assert.assertTrue(isLogoDisplayed);

        driver.close();
    }
    @Test
    public void FirefoxTest(){
        System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        boolean isLogoDisplayed = driver.findElement(By.cssSelector("#hplogo")).isDisplayed();
        Assert.assertTrue(isLogoDisplayed);

        driver.close();
    }
}
