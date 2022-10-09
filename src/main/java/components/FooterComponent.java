package components;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import pageObjects.MainPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

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

    private ElementsCollection  getHrefFromListInformation(){
        return $$("#block_various_links_footer>ul>li>a");
    }

    public void assertThatInformationLinkCollectionContains(int index, String hrefValue) {
         SelenideElement sss = getHrefFromListInformation().get(index);
         sss.shouldHave(Condition.attribute("href",hrefValue));
    }
}
