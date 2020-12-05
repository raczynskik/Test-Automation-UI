package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.MainPage;

public class RegisterNewsletterSteps {

    private MainPage mainPage = new MainPage();

    @When("The user subscribes to the newsletter")
    public void theUserSubscribesToTheNewsletter() {
        mainPage.footer.subscribeNewsletterWithRandomEmail();
    }

    @Then("The user receives confirmation of subscribing to the newsletter")
    public void theUserReceivesConfirmationOfSubscribingToTheNewsletter() {
        mainPage.assertThatSuccessAlertHaveCorrectContent(" Newsletter : You have successfully subscribed to this newsletter.");
    }
}