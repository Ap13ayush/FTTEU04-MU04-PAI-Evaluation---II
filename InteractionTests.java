import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InteractionTests {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testHandleAlerts() {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.id("alertButton")).click();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You clicked a button");
        alert.accept();

        // Optionally verify alert was accepted (can check for page changes)
    }

    @Test
    public void testHandlingIframes() {
        driver.get("https://demoqa.com/frames");
        driver.switchTo().frame("frame1");
        String heading = driver.findElement(By.id("sampleHeading")).getText();
        Assert.assertEquals(heading, "This is a sample page");
        driver.switchTo().defaultContent();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
