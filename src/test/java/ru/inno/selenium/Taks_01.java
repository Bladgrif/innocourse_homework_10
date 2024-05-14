package ru.inno.selenium;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Taks_01 {
    @Test
    void sucessfullAuth() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // WebDriver
        WebDriverManager.chromedriver().browserVersion("114").setup();
        WebDriver browser = new ChromeDriver();
        browser.get("https://habr.ru");
        browser.quit();
//        // WebElement
//        browser.quit();
//        Configuration.browserVersion = System.getProperty("browserVersion", "100.0");
//        open("https://habr.ru");
//        sleep(1000);
    }

    @Test
    public void userCanLoginByUsername() {
//        WebDriverManager.chromedriver().browserVersion("114").setup();
//        open("/login");
//        $(By.name("user.name")).setValue("johny");
//        $("#submit").click();
//        $(".loading_progress").should(disappear); // Само подождёт, пока элемент исчезнет
//        $("#username").shouldHave(text("Hello, Johny!")); // Само подождёт, пока у элемента появится нужный текст
    }
}
