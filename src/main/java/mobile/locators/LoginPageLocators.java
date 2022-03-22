package mobile.locators;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import mobile.base.BaseView;
import org.openqa.selenium.By;

public class LoginPageLocators extends BaseView {

    //Поле "Email"
    public By eMailInput() {
        return MobileBy.AccessibilityId("input-email");
    }

    //Поле "Password"
    public By passwordInput() {
        return MobileBy.AccessibilityId("input-password");
    }

    //Кнопка "Login"
    public By loginButton() {
        return MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"button-LOGIN\"]/android.view.ViewGroup");
    }

    //Сообщения об успешной регистрации "You are logged in!"
    public By successMessage() {
        return By.id("android:id/message");
    }

    //Сообщение об обязательности заполнения поля "Email"
    public By errorTextEmailField() {
        return MobileBy.xpath("//android.widget.ScrollView[@content-desc=\"Login-screen\"]" +
                "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView[1]");
    }

    //Сообщение об обязательности заполнения поля "Password"
    public By errorTextPasswordField() {
        return MobileBy.xpath("//android.widget.ScrollView[@content-desc=\"Login-screen\"]" +
                "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView[2]");
    }

    public LoginPageLocators(MobileDriver driver) {
        super();
    }
}
