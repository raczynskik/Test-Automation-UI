package steps;

import builder.UserBuilder;
import builder.UserState;
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
                .personalInformationFirstName("fsd")
                .personalInformationLastName("dadas")
                .password("fdfsd")
                .firstNameUserAddress("dad")
                .lastNameUserAddress("da")
                .address("da")
                .cityUserAddress("da")
                .userState(UserState.Arizona)
                .zipCodeUserAddress("dadas")
                .mobilePhone("dasda")
                .aliasReference("dasa")
                .build();


        authenticationPage
                .registerUserWithRandomEmail()
//                .registerUser("Fred","L. Brown","{4EdsTKHah.c49","One Infinite Loop","Cupertino","California","95014","United states","(408) 606-5775");
                    .registerUser(user);
    }

    @Then("User sees panel after login")
    public void userSeesPanelAfterLogin() {
        myAccountPage.header
                .assertThatUserNameIsDisplayed("Fred","L. Brown");
    }
}
