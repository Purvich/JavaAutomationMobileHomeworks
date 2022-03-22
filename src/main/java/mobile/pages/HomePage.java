package mobile.pages;

import io.qameta.allure.Step;
import mobile.base.BaseView;
import mobile.locators.HomePageLocators;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BaseView {

    private HomePageLocators locators () {
        return new HomePageLocators(driver);
    }

    @Step("Тап по кнопке \"Login\" в меню")
    public LoginPage clickOnButtonLoginInMenuBar() throws InterruptedException {
        $(locators().loginMenuButton()).click();
        return new LoginPage();
    }
}
