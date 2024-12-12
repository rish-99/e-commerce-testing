import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class LoginTest {
    public static void main(String[] args) {

        // Set up WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

            // Navigate to OpenCart Demo Site
            driver.get("https://demo-opencart.com/index.php?route=common/home&language=en-gb");

            // Go to Login Page
            driver.findElement(By.linkText("My Account")).click();

            // Pause for 3 seconds
            try {
                Thread.sleep(1000); // Wait for page to load or elements to render
            } catch (InterruptedException e) {
                System.err.println("Thread was interrupted: " + e.getMessage());
            }

            driver.findElement(By.linkText("Login")).click();

            // Pause for 3 seconds
            try {
                Thread.sleep(1000); // Wait for page to load or elements to render
            } catch (InterruptedException e) {
                System.err.println("Thread was interrupted: " + e.getMessage());
            }

            // Enter valid credentials and log in
            driver.findElement(By.id("input-email")).sendKeys("test@example.com");
            driver.findElement(By.id("input-password")).sendKeys("password123");
            driver.findElement(By.xpath("//input[@value='Login']")).click();

            // Validate successful login
            String title = driver.getTitle();
            if (title.contains("My Account")) {
                System.out.println("Login Test Passed!");
            } else {
                System.out.println("Login Test Failed!");
            }
        } finally {
            driver.quit();
        }
    }
}
