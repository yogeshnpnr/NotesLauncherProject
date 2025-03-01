package tests;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.ConfigReader;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class BaseTest {
    protected AndroidDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", ConfigReader.getEnvString("deviceName"));
        capabilities.setCapability("platformName", ConfigReader.getEnvString("platformName"));
        capabilities.setCapability("automationName", ConfigReader.getEnvString("automationName"));
        capabilities.setCapability("platformVersion", ConfigReader.getEnvString("platformVersion"));
        capabilities.setCapability("app", ConfigReader.getEnvString("app"));
      //  capabilities.setCapability("chromedriverExecutable", ConfigReader.getEnvString("chromedriverExecutable"));

        URL url = URI.create(ConfigReader.getEnvString("appiumServer")).toURL();
        driver = new AndroidDriver(url, capabilities);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
