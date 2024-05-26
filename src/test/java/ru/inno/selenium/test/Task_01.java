package ru.inno.selenium.test;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class Task_01 {

    Faker faker = new Faker();

    public static final String GREEN_COLOR = "rgba(209, 231, 221, 1)";
    public static final String RED_COLOR = "rgba(248, 215, 218, 1)";

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void sucessfullAuth() {
        open("http://uitestingplayground.com/sampleapp");
        $("[name='UserName']").setValue("inno");
        $("[name='Password']").setValue("pwd");
        $("#login").click();
        $("#loginstatus").shouldHave(text("Welcome, inno!"));
    }

    @Test
    void renamingAButton() {
        open("http://uitestingplayground.com/textinput");
        $("#newButtonName").setValue("Привет");
        $("#updatingButton").click();
        $("#updatingButton").shouldHave(text("Привет"));
    }

    @Test
    void fillingOutTheForm() {
        open("https://bonigarcia.dev/selenium-webdriver-java/data-types.html");
        $("[name='first-name']").setValue(faker.name().firstName());
        $("[name='last-name']").setValue(faker.name().lastName());
        $("[name='address']").setValue(faker.address().fullAddress());
        $("[name='city']").setValue(faker.address().city());
        $("[name='country']").setValue(faker.address().country());
        $("[name='job-position']").setValue(faker.job().title());
        $("[name='company']").setValue(faker.company().name());
        $("[type='submit']").click();

        $("#first-name").shouldHave(cssValue("background-color", GREEN_COLOR));
        $("#last-name").shouldHave(cssValue("background-color", GREEN_COLOR));
        $("#address").shouldHave(cssValue("background-color", GREEN_COLOR));
        $("#city").shouldHave(cssValue("background-color", GREEN_COLOR));
        $("#country").shouldHave(cssValue("background-color", GREEN_COLOR));
        $("#job-position").shouldHave(cssValue("background-color", GREEN_COLOR));
        $("#company").shouldHave(cssValue("background-color", GREEN_COLOR));

        $("#zip-code").shouldHave(cssValue("background-color", RED_COLOR));
        $("#e-mail").shouldHave(cssValue("background-color", RED_COLOR));
        $("#phone").shouldHave(cssValue("background-color", RED_COLOR));
    }

    @Test
    void waitForThePicture() {
        open("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
        $("#text").shouldHave(exactText("Done!"), Duration.ofSeconds(10));
        $$("#image-container img").shouldHave(CollectionCondition.size(4));
        List<SelenideElement> images = $$("#image-container img");
        for (SelenideElement image : images) {
            image.shouldHave(Condition.attributeMatching("src", ".*award\\.png$"));
        }
    }
}
