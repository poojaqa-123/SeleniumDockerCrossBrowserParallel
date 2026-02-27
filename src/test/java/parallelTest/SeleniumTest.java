package parallelTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.URL;
import java.time.Duration;

public class SeleniumTest {

    WebDriver driver;

    @BeforeTest
    @Parameters("browserType")
    public void setup(String browserType) throws Exception {

        String hubUrl = System.getenv("HUB_URL") != null
                ? System.getenv("HUB_URL")
                : "http://localhost:4444";

        if (browserType.equalsIgnoreCase("chrome")) {

            driver = new RemoteWebDriver(
                    new URL(hubUrl),
                    new ChromeOptions()
            );

        } else if (browserType.equalsIgnoreCase("firefox")) {

            driver = new RemoteWebDriver(
                    new URL(hubUrl),
                    new FirefoxOptions()
            );

        } else if (browserType.equalsIgnoreCase("edge")) {

            driver = new RemoteWebDriver(
                    new URL(hubUrl),
                    new EdgeOptions()
            );

        } else {
            throw new IllegalArgumentException("Invalid browser type: " + browserType);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void SeleniumCrossBrowserTests() {

        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");

        driver.findElement(By.cssSelector("#menuToggle > input")).click();

        System.out.println("Title: " + driver.getTitle());
    }

    @AfterTest
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}