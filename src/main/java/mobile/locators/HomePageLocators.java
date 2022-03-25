package mobile.locators;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class HomePageLocators {

    //Кнопка "Login" в меню
    public By loginMenuButton() {
        return MobileBy.xpath("//android.view." +
                "ViewGroup[@content-desc=\"Login\"]/android.view.ViewGroup/android.widget.TextView");
    }
}
