package mobile.authorization;

import mobile.base.BaseTest;
import mobile.pages.LoginPage;
import mobile.data.AssertionsData;
import mobile.data.LoginData;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class AuthorizationTest extends BaseTest {

    @Test
    void checkSuccessLogin() throws InterruptedException {

        openApp()
                .clickOnButtonLoginInMenuBar()
                .fillInputEmail(LoginData.eMail)
                .fillInputPassword(LoginData.password)
                .clickOnButtonLogin();

        //Проверка popup с сообщением об успешной регистрации
        Assert.assertEquals(new LoginPage().getSuccessMessageText(), AssertionsData.successLoginText);
    }

    @Test
    void checkEmptyFields() throws InterruptedException {
        openApp()
                .clickOnButtonLoginInMenuBar()
                .clickOnButtonLogin();

        assertEquals(new LoginPage().getErrorTextEmailInput(), AssertionsData.errorTextEmail);
        assertEquals(new LoginPage().getErrorTextPasswordInput(), AssertionsData.errorTextPassword);
    }

    @Test
    void checkEmptyPasswordField() throws InterruptedException {

        openApp()
                .clickOnButtonLoginInMenuBar()
                .fillInputEmail(LoginData.eMail)
                .clickOnButtonLogin();

        //Проверка отображения сообщения об ошибке "Please enter at least 8 characters"
        assertEquals(new LoginPage().getErrorTextPasswordInput(), AssertionsData.errorTextPassword);
    }

    @Test
    void checkEmptyEmailField() throws InterruptedException {

        openApp()
                .clickOnButtonLoginInMenuBar()
                .fillInputPassword(LoginData.password)
                .clickOnButtonLogin();

        //Проверка отображения сообщения об ошибке "Please enter a valid email address"
        assertEquals(new LoginPage().getErrorTextEmailInput(), AssertionsData.errorTextEmail);
    }
}
