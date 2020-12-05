package components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pageObjects.MyAccountPage;

import static com.codeborne.selenide.Selenide.$;

public class HeaderComponent {

    private SelenideElement userName = $("div[class='nav']>div>div>nav>div[class='header_user_info']>a>span");

    public MyAccountPage assertThatUserNameIsDisplayed(String firstName, String lastName) {
        userName.shouldBe(Condition.text(firstName)).shouldBe(Condition.text(lastName));
        return new MyAccountPage();
    }
}
