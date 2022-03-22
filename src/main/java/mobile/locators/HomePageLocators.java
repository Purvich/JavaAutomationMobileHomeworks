package mobile.locators;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import mobile.base.BaseView;
import org.openqa.selenium.By;

public class HomePageLocators extends BaseView {

    //Кнопка "Login" в меню
    public By loginMenuButton() {
        return MobileBy.xpath("//android.view." +
                "ViewGroup[@content-desc=\"Login\"]/android.view.ViewGroup/android.widget.TextView");
    }

    public HomePageLocators(MobileDriver driver) {
        super();
    }
}
