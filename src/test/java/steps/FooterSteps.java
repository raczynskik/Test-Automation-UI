package steps;

import components.FooterComponent;
import io.cucumber.java.en.Then;

public class FooterSteps {

    FooterComponent footerComponent = new FooterComponent();

    @Then("The {int} link has href value value {string}")
    public void theLinkHasHrefValueValue(int index, String hrefValue) {
        footerComponent.assertThatInformationLinkCollectionContains(index,hrefValue);
    }
}
