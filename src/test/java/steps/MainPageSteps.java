package steps;

import io.cucumber.java.en.Given;
import pageObjects.MainPage;

public class MainPageSteps {

    private MainPage mainPage = new MainPage();

    @Given("The user on main page")
    public void theUserOnMainPage() {
        mainPage.goTo();
    }
}
