package parallelTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.URL;

public class SeleniumTest {

    WebDriver driver;

    @BeforeTest
    @Parameters("browserType")
    public void setup(String browser) throws Exception {

        String hubUrl = System.getenv("HUB_URL") != null
                ? System.getenv("HUB_URL")
                : "http://localhost:4444";

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new RemoteWebDriver(new URL(hubUrl), new ChromeOptions());
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new RemoteWebDriver(new URL(hubUrl), new FirefoxOptions());
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new RemoteWebDriver(new URL(hubUrl), new EdgeOptions());
        }
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