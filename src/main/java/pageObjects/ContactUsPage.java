package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

public class ContactUsPage {


    private SelenideElement subjectHeading = $("#id_contact"),
            inputEmail = $("#email"),
            textareaMessage = $("#message"),
            submitButton = $("#submitMessage"),
            alertSuccess = $("p[class='alert alert-success']");

    public ContactUsPage goTo(){
        open("http://automationpractice.com/index.php?controller=contact");
        return this;
    }

    private ElementsCollection subjectHeadingCollection(){
        return $$("#id_contact>option");
    }

    private ElementsCollection contentErrorAlertCollection(){
        return $$("div[class='alert alert-danger']>ol>li");
    }

    public ContactUsPage sendFormWithBasicDataWithoutEmail(String subjectMessage, String messageContent) {
        subjectHeading.click();
        subjectHeadingCollection().findBy(text((subjectMessage))).click();
        textareaMessage.setValue(messageContent);
        submitButton.click();
        return this;
    }

    public ContactUsPage sendFormWithBasicData(String subjectMessage, String email) {
        subjectHeading.click();
        subjectHeadingCollection().findBy(text((subjectMessage))).click();
        inputEmail.setValue(email);
        submitButton.click();
        return this;
    }

    public ContactUsPage sendFormWithBasicData(String subjectMessage, String email, String messageContent) {
        subjectHeading.click();
        subjectHeadingCollection().findBy(text((subjectMessage))).click();
        inputEmail.setValue(email);
        textareaMessage.setValue(messageContent);
        submitButton.click();
        return this;
    }

    public ContactUsPage assertThatAlertSuccessContainsGivenText(String expectedAlertText) {
        alertSuccess.shouldHave(text(expectedAlertText));
        return this;
    }

    public ContactUsPage assertThatErrorAlertContainsGivenText(String expectedAlertText) {
        contentErrorAlertCollection().get(0).shouldHave(Condition.text(expectedAlertText));
        return this;
    }
}
