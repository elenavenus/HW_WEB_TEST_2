import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebTest {
    @Test
    void shouldTest() {
        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");
        SelenideElement cityInput = form.find("[data-test-id=city]")
                .find("[placeholder=Город]");
        cityInput.setValue("Майкоп");

        SelenideElement dateInput = form.find("[data-test-id=date]")
                .find("[placeholder=Дата встречи]");
        LocalDate dateToInput = LocalDate.now().plusDays(3);
        dateInput.setValue(dateToInput.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));

        SelenideElement nameAndSurnameInput = form
                .find("[data-test-id=name]")
                .find("[name=name]");
        nameAndSurnameInput.setValue("Елена Колесникова");

        SelenideElement phoneInput = form
                .find("[data-test-id=phone]")
                .find("[name=phone]");
        phoneInput.setValue("+79062655137");

        SelenideElement agreementInput = form
                .find("[data-test-id=agreement]")
                .find(".checkbox__box");
        agreementInput.click();

        SelenideElement billButton = form.find(".button_theme_alfa-on-white");
        billButton.click();
        
    }

    /*@Test
    void shouldTest() {
        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");
        SelenideElement nameAndSurnameInput = form
                .find("[data-test-id=name]")
                .find("[name=name]");
        nameAndSurnameInput.setValue("Елена Колесникова");
        SelenideElement phoneInput = form
                .find("[data-test-id=phone]")
                .find("[name=phone]");
        phoneInput.setValue("+79062655137");
        SelenideElement agreementInput = form
                .find("[data-test-id=agreement]")
                .find(".checkbox__box");
        agreementInput.click();
        SelenideElement submitButton = form.find(".button_theme_alfa-on-white");
        submitButton.click();
        $("[data-test-id=order-success]").shouldHave(exactText("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }*/
}
