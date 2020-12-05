package pageObjects;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthenticationPage {

    private SelenideElement inputEmailCreate = $("#email_create"),
            buttonCreateAccount = $("#SubmitCreate"),
            inputEmailLogin = $("#email"),
            inputPasswordLogin = $("#passwd"),
            buttonLogin = $("#SubmitLogin");

    public AuthenticationPage goTo() {
        open("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        return this;
    }

    public RegisterPage registerUserWithRandomEmail() {
        Faker faker = new Faker();
        inputEmailCreate.setValue(faker.internet().emailAddress());
        buttonCreateAccount.click();
        return new RegisterPage();
    }

    public AuthenticationPage loginUser(String email, String password) {
        inputEmailLogin.setValue(email);
        inputPasswordLogin.setValue(password);
        return this;
    }
}
