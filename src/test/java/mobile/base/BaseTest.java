package mobile.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.android.AndroidDriver;
import mobile.pages.HomePage;
import mobile.data.CapabilitiesData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.close;

public class BaseTest {

    public HomePage openApp() {
        WebDriver driver = null;
        try {
            driver = getAndroidDriver();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("Opps, we have problems with URL for driver!");
        }

        WebDriverRunner.setWebDriver(driver);
        return new HomePage();
    }

    public static WebDriver getAndroidDriver() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(CapabilitiesData.platformName, CapabilitiesData.platformNameValue);
        capabilities.setCapability(CapabilitiesData.deviceName, CapabilitiesData.deviceNameValue);
        capabilities.setCapability(CapabilitiesData.platformVersion, CapabilitiesData.platformVersionValue);
        capabilities.setCapability(CapabilitiesData.udid, CapabilitiesData.udidValue);
        capabilities.setCapability(CapabilitiesData.automationName, CapabilitiesData.automationNameValue);
        capabilities.setCapability(CapabilitiesData.app, CapabilitiesData.appValue);

        Configuration.reportsFolder = "screenshots/actual";
        return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @AfterClass
    static void setDown() {
        close();
    }
}
