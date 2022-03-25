package mobile.pages;

import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.ImageComparisonUtil;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;
import com.github.romankh3.image.comparison.model.ImageComparisonState;
import io.qameta.allure.Step;
import mobile.locators.LoginPageLocators;

import java.awt.image.BufferedImage;
import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;

public class LoginPage {

    private LoginPageLocators locators() {
        return new LoginPageLocators();
    }

    @Step("Заполнение поле \"Email\"")
    public LoginPage fillInputEmail(String eMail) {
        $(locators().eMailInput()).sendKeys(eMail);
        return this;
    }

    @Step("Заполнение поля \"Password\"")
    public LoginPage fillInputPassword(String password) {
        $(locators().passwordInput()).sendKeys(password);
        return this;
    }

    @Step("Тап по кнопке \"Login\"")
    public LoginPage clickOnButtonLogin() {
        $(locators().loginButton()).click();
        return this;
    }

    //Получение текста сообщения
    public String getSuccessMessageText() {
        String successMessageText;
        return successMessageText = $(locators().successMessage()).getText();
    }

    //Получение текста об обязательности заполнения поля "Email"
    public String getErrorTextEmailInput() {
        String errorTextEmail = $(locators().errorTextEmailField()).getText();
        return errorTextEmail;
    }

    //Получение текста об обязательности заполнения полей "Password" и "Email"
    public String getErrorTextPasswordInputWithCheckInputEmail() {
        String errorTextPasswordWithCheckErrorEmail = $(locators().errorTextPasswordFieldWithEmptyFieldEmail())
                .getText();
        return errorTextPasswordWithCheckErrorEmail;
    }

    //Получение текста об обязательности заполнения полей "Password"
    public String getErrorTextPassword() {
        String errorTextPassword;
        return errorTextPassword = $(locators().errorTextPasswordField()).getText();
    }
}
