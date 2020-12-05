package components;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Selenide.$;

public class FooterComponent {

    private SelenideElement inputNewsletter = $("#newsletter-input");

    public MainPage subscribeNewsletter(String email) {
        inputNewsletter.setValue(email).pressEnter();
        return new MainPage();
    }

    public MainPage subscribeNewsletterWithRandomEmail() {
        Faker faker = new Faker();
        inputNewsletter.setValue(faker.internet().emailAddress()).pressEnter();
        return new MainPage();
    }
}
