package parallelTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumTest {
    WebDriver driver;

    @BeforeTest
    @Parameters("browserType")
    public void setup(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if(browser.equalsIgnoreCase("firefox")){
            capabilities.setBrowserName("firefox");
        }

        if(browser.equalsIgnoreCase("chrome")){
            capabilities.setBrowserName("chrome");
        }

        if(browser.equalsIgnoreCase("edge")){
            capabilities.setBrowserName("MicrosoftEdge");
        }

        driver = new RemoteWebDriver(new URL("http://localhost:4444"), capabilities);
    }

    @Test
    public void SeleniumCrossBrowserTests() throws InterruptedException {

        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
        driver.findElement(By.cssSelector("#menuToggle > input:nth-child(1)")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.cssSelector("#menu > a:nth-child(2) > li:nth-child(1)")).click();
//        driver.findElement(By.cssSelector("#usr")).sendKeys("sa");
//        driver.findElement(By.cssSelector("#usr")).sendKeys("sa");
//        driver.findElement(By.cssSelector("#pwd")).sendKeys("sa");
//        driver.findElement(By.cssSelector("input.btn")).click();
//
//        WebElement webElement = driver.findElement(By.cssSelector("#SmokeTests > center:nth-child(3) > h3:nth-child(1)"));
//
//        String expectedFirstProductCategory = "Formal Shoes";
//
//        Assert.assertEquals(webElement.getText(), expectedFirstProductCategory);

        driver.close();
    }


}
