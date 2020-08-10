import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class SerialExecution {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
    }

    @Test
    public void isLogoDisplayedGoogle(){
        boolean isLogoDisplayed = driver.findElement(By.cssSelector("#hplogo")).isDisplayed();
        Assert.assertTrue(isLogoDisplayed);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}

