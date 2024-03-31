package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TetsGitHub {

    @BeforeAll()
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
    }

    @Test
    void checkForJUnit5InSoftAssertions(){
        // Откройте страницу Selenide в Github
        open("/selenide/selenide");

        // Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();

        // Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $(".js-wiki-more-pages-link").click();
        $(".wiki-rightbar").shouldHave(text("SoftAssertions"));

        // Откройте страницу SoftAssertions
        $(byId("wiki-pages-box")).$(byText("SoftAssertions")).click();
        // Проверьте что внутри есть пример кода для JUnit5
        $("#wiki-body").shouldHave(text("""
                @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                  @Test
                  void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");

                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                  }
                }
                """)).shouldBe(visible);
    }
}
