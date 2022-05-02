package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class MainPage {

    public SelenideElement HamburgerMenu = $("a#nav-hamburger-menu");
    public SelenideElement SelectHighRating = $(".a-star-medium-4");

    public SelenideElement SelectSortByElement  = $(".a-dropdown-prompt");

    public SelenideElement SelectLowToHighPrice() {
        return $(By.linkText("Price: Low to High"));
    }

    public  SelenideElement selectMenuItem(String menuItem) {
        return $(By.linkText(""+menuItem+""));
    }

    public SelenideElement selectSubMenuItem(String subMenuItem) {
        return $(By.xpath("//a[@class='hmenu-item' and contains(.,'"+subMenuItem+"')]"));
    }

    public SelenideElement sideMenuSelector(String sideMenuText) {
        return $(By.xpath("//span[@class='a-size-base a-color-base' and contains(.,'"+sideMenuText+"')]"));
    }

    public SelenideElement scrollElement(String element) {
        return $(By.xpath("//span[@class='a-size-base a-color-base' and contains(.,'"+element+"')]")).scrollIntoView(true);
    }

    public SelenideElement selectProduct() {
        return $(By.xpath("(//span[@class='a-icon-alt' and contains (.,'5.0 out')])[1]//..//..//..//..//..//..//.."));
    }

    public String getProductText() {
        return $(By.xpath("(//span[@class='a-icon-alt' and contains (.,'5.0 out')])[1]//..//..//..//..//..//..//..//h2")).getText();
    }





}

