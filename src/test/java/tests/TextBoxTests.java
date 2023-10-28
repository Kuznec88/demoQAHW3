package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests
{
    @BeforeAll
    static void beforeAll()
    {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
     void fillFormTest()
    {
        open("/automation-practice-form");
        $("#firstName").setValue("someFirstName");
        $("#lastName").setValue("someLastName");
        $("#userEmail").setValue("someUser@mail.ru");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("1234567891");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $(byValue("1992")).click();
        $(".react-datepicker__month-select").selectOption("November");
        $("[aria-label='Choose Tuesday, November 17th, 1992']").click();
        $("#subjectsInput").val("English").pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("[for='hobbies-checkbox-2']").click();
        $("[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFromClasspath("exceptionsInJavaHierarchy.png");
        $("#currentAddress").setValue("someAddress");
        $("#state").scrollTo().click();
        $("#react-select-3-input").val("NCR").pressEnter();
        $("#city").click();
        $("#react-select-4-input").val("Delhi").pressEnter().pressTab().pressEnter();

        //Проверка значений
        $x("//td[text()='Student Name']/following::td[text()='someFirstName someLastName']").shouldBe(visible);
        $x("//td[text()='Student Email']/following::td[text()='someUser@mail.ru']").shouldBe(visible);
        $x("//td[text()='Gender']/following::td[text()='Male']").shouldBe(visible);
        $x("//td[text()='Mobile']/following::td[text()='1234567891']").shouldBe(visible);
        $x("//td[text()='Date of Birth']/following::td[text()='17 November,1992']").shouldBe(visible);
        $x("//td[text()='Subjects']/following::td[text()='English']").shouldBe(visible);
        $x("//td[text()='Hobbies']/following::td[text()='Sports, Reading, Music']").shouldBe(visible);
        $x("//td[text()='Picture']/following::td[text()='exceptionsInJavaHierarchy.png']").shouldBe(visible);
        $x("//td[text()='Address']/following::td[text()='someAddress']").shouldBe(visible);
        $x("//td[text()='State and City']/following::td[text()='NCR Delhi']").shouldBe(visible);
    }
}