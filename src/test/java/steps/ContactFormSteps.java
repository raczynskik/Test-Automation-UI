package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ContactUsPage;

public class ContactFormSteps {


    private ContactUsPage contactUsPage = new ContactUsPage();

    @Given("The user on contact page")
    public void theUserOnContactPage() {
        contactUsPage.goTo();
    }

    @When("The user completes the contact form")
    public void theUserCompletesTheContactForm() {
        contactUsPage.sendFormWithBasicData("Webmaster","example@test.com","test message content");
    }

    @Then("The user sees a message that the message has been successfully sent")
    public void theUserSeesAMessageThatTheMessageHasBeenSuccessfullySent() {
        contactUsPage.assertThatAlertSuccessContainsGivenText("Your message has been successfully sent to our team.");
    }

    @When("The user completes the contact form without message content")
    public void theUserCompletesTheContactFormWithoutMessageContent() {
        contactUsPage.sendFormWithBasicData("Webmaster","example@test.com");
    }

    @Then("The user sees the message that the message was not sent")
    public void theUserSeesTheMessageThatTheMessageWasNotSent() {
        contactUsPage.assertThatErrorAlertContainsGivenText("The message cannot be blank.");
    }

    @When("The user completes the contact form without email address")
    public void theUserCompletesTheContactFormWithoutEmailAddress() {
        contactUsPage.sendFormWithBasicDataWithoutEmail("Webmaster","example@tst.com");
    }

    @Then("The user sees the alert message that the message was not sent")
    public void theUserSeesTheAlertMessageThatTheMessageWasNotSent() {
        contactUsPage.assertThatErrorAlertContainsGivenText("Invalid email address.");
    }

    @When("The user completes the contact form without subject heading")
    public void theUserCompletesTheContactFormWithoutSubjectHeading() {
        contactUsPage.sendFormWithBasicData(" ","example@test.com","test content");
    }

    @Then("The user sees the alert message that subject of the report isn't selected")
    public void theUserSeesTheAlertMessageThatSubjectOfTheReportIsnTSelected() {
        contactUsPage.assertThatErrorAlertContainsGivenText("Please select a subject from the list provided. ");
    }
}
