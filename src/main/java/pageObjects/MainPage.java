package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import components.FooterComponent;
import components.HeaderComponent;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    public HeaderComponent header;
    public FooterComponent footer;

    private SelenideElement alertSuccess = $("p[class='alert alert-success']");

    public MainPage() {
        header = new HeaderComponent();
        footer = new FooterComponent();
    }

    public MainPage goTo() {
        open("http://automationpractice.com/index.php");
        return this;
    }

    public MainPage assertThatSuccessAlertHaveCorrectContent(String expectedContent) {
        alertSuccess.shouldHave(Condition.text(expectedContent));
        return this;
    }
}
