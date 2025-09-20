import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormTests {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testCheckBoxSelection() {
        driver.get("https://demoqa.com/checkbox");

        // Expand Home directory
        driver.findElement(By.cssSelector("button[title='Expand all']")).click();
        // Select "Documents" checkbox
        driver.findElement(By.cssSelector("label[for='tree-node-documents'] span.rct-checkbox")).click();

        // Assert selection result
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertTrue(result.getText().contains("documents"), "Documents not selected!");
    }


    @Test
    public void testTextBoxSubmission() {
        driver.get("https://demoqa.com/text-box");

        // Fill in Full Name and Email
        driver.findElement(By.id("userName")).sendKeys("Ayush");
        driver.findElement(By.id("userEmail")).sendKeys("ayushaptel@example.com");

        // Submit the form
        driver.findElement(By.id("submit")).click();

        // Assert the result
        String output = driver.findElement(By.id("output")).getText();
        Assert.assertTrue(output.contains("Ayush Patel"), "Name not found in output");
        Assert.assertTrue(output.contains("ayushpatel@example.com"), "Email not found in output");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
