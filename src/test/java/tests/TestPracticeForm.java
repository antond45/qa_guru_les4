package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class TestPracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
    }

    @Test
    void TestPracticeForm() {
        open("/automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        //name-email
        $("#firstName").setValue("Anton");
        $("#lastName").setValue("Test");
        $("#userEmail").setValue("anton@tests.test");

        //gender
        $("#genterWrapper").$(byText("Male")).click();

        //Number
        $("#userNumber").setValue("89175555758");

        //Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").$(byText("1997")).click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").$(byText("February")).click();
        $(".react-datepicker__month").$(byText("14")).click();

        //Subjects/Hobbies
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();

        //Picture
        $("#uploadPicture").uploadFromClasspath("Screenshot_5.png");

        //Address
        $("#currentAddress").setValue("Some address");
        $("#stateCity-wrapper").$(byText("Select State")).click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#stateCity-wrapper").$(byText("Select City")).click();
        $("#stateCity-wrapper").$(byText("Agra")).click();

        $("#submit").click();

        //form-reg
        $(".table-responsive").shouldHave(text("Anton Test"));
        $(".table-responsive").shouldHave(text("anton@tests.test"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("8917555575"));
        $(".table-responsive").shouldHave(text("14 February,1997"));
        $(".table-responsive").shouldHave(text("Maths"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("Screenshot_5.png"));
        $(".table-responsive").shouldHave(text("Some address"));
        $(".table-responsive").shouldHave(text("Uttar Pradesh Agra"));
    }

}
