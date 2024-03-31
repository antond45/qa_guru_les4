package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class TestHoverGitHub {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
    }

    //Task1
    //На главной странице GitHub выберите меню Solutions -> Enterprise
    // с помощью команды hover для Solutions.
    // Убедитесь что загрузилась нужная страница (например что заголовок - "Build like the best."

    @Test
    void testhover(){
        open("https://github.com");
        $("header").$(withText("Solutions")).hover();
        $("[aria-labelledby=solutions-for-heading]").$(withText("Enterprise")).click();
        $(byText("The AI-powered")).shouldBe(visible);
    }

    //Task2
   // Запрограммируйте Drag&Drop с помощью Selenide.actions()

    @Test
    void testDragAndDropActions(){

        //Откройте https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");

        //Перенесите прямоугольник А на место В
        actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().perform();
        //Проверьте, что прямоугольники действительно поменялись
        $("#column-a").shouldBe(text("B"));
    }

    @Test
    void testDragAndDropsSelenide(){
        //В Selenide есть команда $(element).dragAndDrop($(to-element)), проверьте работает ли тест, если использовать её вместо actions()
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDrop(to($("#column-b")));
        $("#column-a").shouldBe(text("B"));

    }

}
