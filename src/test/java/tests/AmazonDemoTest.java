package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.*;


public class AmazonDemoTest {
    MainPage mainPage = new MainPage();

    @BeforeClass
    public static void setUpAll() {
        Configuration.headless = false;
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        // TODO: Add browser settings (no cookie)
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeMethod
    public void setUp() {
        open("https://www.amazon.co.uk");
    }

    @Test
    public void scenario() {
        // Click All menu item
        mainPage.HamburgerMenu.click();
        // Select Electronics & Computers menu item
        mainPage.selectMenuItem("Electronics & Computers").click();
        sleep(3000);
        // Select LapTop menu item
        mainPage.selectSubMenuItem("Laptops").click();
        // Assestion for Laptop page
        assert title().contains("Laptops");
        // Select Display Size 15" - 16"
        mainPage.sideMenuSelector("15 to 16 in (38 to 41 cm)").click();
        //assert title().contains("RESULTS");
        sleep(3000);
        // Select Storage Type SSD
        mainPage.scrollElement("AMD Ryzen");
        sleep(3000);
        mainPage.sideMenuSelector("SSD").click();
        // Select CPU Type - Intel Core i5
        mainPage.scrollElement("AMD Ryzen");
        mainPage.sideMenuSelector("Intel Core i5").click();
        sleep(3000);
        // Select a five stared Laptop with the lowest price.
        sleep(3000);
        mainPage.SelectHighRating.click();
        sleep(3000);
        mainPage.SelectSortByElement.click();
        sleep(1000);
        mainPage.SelectLowToHighPrice().click();
        sleep(3000);
        // Click product and check text
        String text = mainPage.getProductText();
        mainPage.selectProduct().click();
        sleep(10000);
        assert title().contains(text);
    }
}
