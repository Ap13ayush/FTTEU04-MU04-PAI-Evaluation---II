import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenStudentFormTests {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @DataProvider(name = "studentData")
    public Object[][] studentDataProvider() {
        return new Object[][]{
                {"Ayush", "Patel", "Ayushpatel@example.com", "Male", "9876543210"},
                {"Harsh", "patel", "harshpatel@example.com", "Male", "9123456780"}
        };
    }

    @Test(dataProvider = "studentData")
    public void testFormSubmission(String firstName, String lastName, String email, String gender, String mobile) {
        driver.get("https://demoqa.com/automation-practice-form");
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.xpath("//label[text()='" + gender + "']")).click();
        driver.findElement(By.id("userNumber")).sendKeys(mobile);

        // Submit
        driver.findElement(By.id("submit")).click();

        // Assertion can be customized depending on confirmation/modal
        WebElement confirmation = driver.findElement(By.className("modal-content"));
        Assert.assertTrue(confirmation.getText().contains(firstName));
        Assert.assertTrue(confirmation.getText().contains(email));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
