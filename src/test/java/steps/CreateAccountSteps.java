package steps;

import builder.userBuilder.UserBuilder;
import builder.userBuilder.UserState;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AuthenticationPage;
import pageObjects.MyAccountPage;

public class CreateAccountSteps {


    private AuthenticationPage authenticationPage = new AuthenticationPage();
    private MyAccountPage myAccountPage = new MyAccountPage();

    @Given("User on authentication page")
    public void userOnAuthenticationPage() {
        authenticationPage
                .goTo();
    }

    @When("User fills all data required to register")
    public void userFillsAllDataRequiredToRegister() {
        UserBuilder user = UserBuilder.builder()
                .personalInformationFirstName("Fred")
                .personalInformationLastName("L. Brown")
                .password("{4EdsTKHah.c49")
                .firstNameUserAddress("Fred")
                .lastNameUserAddress("L. Brown")
                .address("One Infinite Loop")
                .cityUserAddress("California")
                .userState(UserState.California)
                .zipCodeUserAddress("95014")
                .country("United states")
                .mobilePhone("(408) 606-5775")
                .build();


        authenticationPage
                .registerUserWithRandomEmail()
                    .registerUser(user);
    }

    @Then("User sees panel after login")
    public void userSeesPanelAfterLogin() {
        myAccountPage.header
                .assertThatUserNameIsDisplayed("Fred","L. Brown");
    }
}
