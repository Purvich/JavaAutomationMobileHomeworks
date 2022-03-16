import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AuthorizationTest {

    private String eMail = "test@test.com";
    private String password = "password";

    private final String deviceName = "deviceName";
    private final String deviceNameValue = "Pixel3";
    private final String udid = "udid";
    private final String udidValue = "emulator-5554";
    private final String platformName = "platformName";
    private final String platformNameValue = "Android";
    private final String platformVersion = "platformVersion";
    private final String platformVersionValue = "10";
    private final String app = "app";
    private final String appValue = "C:\\Users\\ASUS\\Stas\\Android Apk\\Android-NativeDemoApp-0.2.1.apk";
    private final String automationName = "automationName";
    private final String automationNameValue = "UiAutomator2";


    @Test
    void checkSuccessLogin() throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(deviceName, deviceNameValue);
        capabilities.setCapability(udid, udidValue);
        capabilities.setCapability(platformName,platformNameValue);
        capabilities.setCapability(platformVersion, platformVersionValue);
        capabilities.setCapability(app, appValue);
        capabilities.setCapability(automationName, automationNameValue);

        MobileDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        //Тап по кнопке "Login" в меню

        MobileElement loginMenuButton = (MobileElement) driver.findElementByXPath("//android.view." +
                "ViewGroup[@content-desc=\"Login\"]/android.view.ViewGroup/android.widget.TextView");
        loginMenuButton.click();

        Thread.sleep(2000);

        //Ввести валидный eMail

        MobileElement eMailInput = (MobileElement) driver.findElementByAccessibilityId("input-email");
        eMailInput.sendKeys(eMail);

        Thread.sleep(2000);

        //Ввод валидного пароля

        MobileElement passwordInput = (MobileElement) driver.findElementByAccessibilityId("input-password");
        passwordInput.sendKeys(password);

        Thread.sleep(2000);

        //Тап по кнопке "Login"

        MobileElement loginButton = (MobileElement) driver.findElementByXPath("//android.view." +
                "ViewGroup[@content-desc=\"button-LOGIN\"]/android.view.ViewGroup");
        loginButton.click();

        Thread.sleep(2000);

        //Проверка отображения сообщения об успешной регистрации "You are logged in!"

        MobileElement successMessage = (MobileElement) driver.findElementById("android:id/message");

        Assert.assertEquals(successMessage.getText(), "You are logged in!");
    }

    @Test
    void checkEmptyFields() throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(deviceName, deviceNameValue);
        capabilities.setCapability(udid, udidValue);
        capabilities.setCapability(platformName,platformNameValue);
        capabilities.setCapability(platformVersion, platformVersionValue);
        capabilities.setCapability(app, appValue);
        capabilities.setCapability(automationName, automationNameValue);

        MobileDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        //Тап по кнопке "Login" в меню

        MobileElement loginMenuButton = (MobileElement) driver.findElementByXPath("//android.view." +
                "ViewGroup[@content-desc=\"Login\"]/android.view.ViewGroup/android.widget.TextView");
        loginMenuButton.click();

        Thread.sleep(2000);

        //Тап по кнопке "Login"

        MobileElement loginButton = (MobileElement) driver.findElementByXPath("//android.view." +
                "ViewGroup[@content-desc=\"button-LOGIN\"]/android.view.ViewGroup");
        loginButton.click();

        Thread.sleep(2000);

        //Проверка отображения двух ошибок об обязательном заполнении полей eMail и пароль

        MobileElement errorTextEmailField = (MobileElement) driver
                .findElementByXPath("//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view" +
                        ".ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView[1]");

        MobileElement errorTextPasswordField = (MobileElement) driver
                .findElementByXPath("//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view" +
                        ".ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView[2]");

        Assert.assertEquals(errorTextEmailField.getText(), "Please enter a valid email address");
        Assert.assertEquals(errorTextPasswordField.getText(),"Please enter at least 8 characters");
    }

    @Test
    void checkEmptyPasswordField() throws MalformedURLException, InterruptedException  {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(deviceName, deviceNameValue);
        capabilities.setCapability(udid, udidValue);
        capabilities.setCapability(platformName,platformNameValue);
        capabilities.setCapability(platformVersion, platformVersionValue);
        capabilities.setCapability(app, appValue);
        capabilities.setCapability(automationName, automationNameValue);

        MobileDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        //Тап по кнопке "Login" в меню

        MobileElement loginMenuButton = (MobileElement) driver.findElementByXPath("//android.view." +
                "ViewGroup[@content-desc=\"Login\"]/android.view.ViewGroup/android.widget.TextView");
        loginMenuButton.click();

        Thread.sleep(2000);

        //Ввод валидного eMail

        MobileElement eMailInput = (MobileElement) driver.findElementByAccessibilityId("input-email");
        eMailInput.sendKeys(eMail);

        Thread.sleep(2000);

        //Тап по кнопке "Login"

        MobileElement loginButton = (MobileElement) driver.findElementByXPath("//android.view." +
                "ViewGroup[@content-desc=\"button-LOGIN\"]/android.view.ViewGroup");
        loginButton.click();

        Thread.sleep(2000);

        //Проверка отображения сообщения об ошибке "Please enter at least 8 characters"

        MobileElement errorTextPasswordField = (MobileElement) driver
                .findElementByXPath("//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view." +
                        "ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView");

        Assert.assertEquals(errorTextPasswordField.getText(), "Please enter at least 8 characters");
    }

    @Test
    void checkEmptyEmailField() throws MalformedURLException, InterruptedException  {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(deviceName, deviceNameValue);
        capabilities.setCapability(udid, udidValue);
        capabilities.setCapability(platformName,platformNameValue);
        capabilities.setCapability(platformVersion, platformVersionValue);
        capabilities.setCapability(app, appValue);
        capabilities.setCapability(automationName, automationNameValue);

        MobileDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        //Тап по кнопке "Login" в меню

        MobileElement loginMenuButton = (MobileElement) driver.findElementByXPath("//android.view." +
                "ViewGroup[@content-desc=\"Login\"]/android.view.ViewGroup/android.widget.TextView");
        loginMenuButton.click();

        Thread.sleep(2000);

        //Ввод валидного пароля

        MobileElement passwordInput = (MobileElement) driver.findElementByAccessibilityId("input-password");
        passwordInput.sendKeys(password);

        Thread.sleep(2000);

        //Тап по кнопке "Login"

        MobileElement loginButton = (MobileElement) driver.findElementByXPath("//android.view." +
                "ViewGroup[@content-desc=\"button-LOGIN\"]/android.view.ViewGroup");
        loginButton.click();

        Thread.sleep(2000);

        //Проверка отображения сообщения об ошибке "Please enter a valid email address"

        MobileElement errorTextPasswordField = (MobileElement) driver
                .findElementByXPath("//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view." +
                        "ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView");

        Assert.assertEquals(errorTextPasswordField.getText(), "Please enter a valid email address");
    }
}
