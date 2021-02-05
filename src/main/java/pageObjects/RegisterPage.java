package pageObjects;

import builder.userBuilder.UserBuilder;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RegisterPage {

    Faker faker = new Faker();

    private SelenideElement inputFirstNamePersonalInformation = $("#customer_firstname"),
            inputLastNamePersonalInformation = $("#customer_lastname"),
            inputEmailPersonalInformation = $("#email"),
            inputPasswordPersonalInformation = $("#passwd"),
            inputFirstNameUserAddress = $("input[id='firstname']"),
            inputLastNameUserAddress = $("input[id='lastname']"),
            inputCompanyUserAddress = $("input[name='company']"),
            inputAddress1 = $("#address1"),
            inputAddress2 = $("#address2"),
            inputCity = $("#city"),
            selectState = $("#id_state"),
            inputPostalCode = $("input[name='postcode']"),
            selectCounty = $("#id_country"),
            textAreaOther = $("#other"),
            inputHomePhone = $("#phone"),
            inputMobilePhone = $("#phone_mobile"),
            inputReferenceAlias = $("#alias"),
            buttonRegister = $("#submitAccount");



    private ElementsCollection stateCollection(){
        return $$("#id_state>option");
    }

    private ElementsCollection countryCollection() {
        return $$("#id_country>option");
    }

    private RegisterPage selectState(String stateName) {
        selectState.click();
        stateCollection().findBy(text(stateName)).click();
        return this;
    }

    private RegisterPage selectCountry(String countryName) {
        selectCounty.click();
        countryCollection().findBy(text(countryName)).click();
        return this;
    }

    public RegisterPage registerUser(String firstName, String lastName, String password, String address,String city, String stateName, String zipPostal, String countryName, String mobilePhone) {
        inputFirstNamePersonalInformation.setValue(firstName);
        inputLastNamePersonalInformation.setValue(lastName);
        inputPasswordPersonalInformation.setValue(password);
        inputAddress1.setValue(address);
        inputCity.setValue(city);
        selectState(stateName);
        inputPostalCode.setValue(zipPostal);
        selectCountry(countryName);
        inputMobilePhone.setValue(mobilePhone);
        buttonRegister.click();
        return this;
    }

    public RegisterPage registerUser(UserBuilder user) {
        inputFirstNamePersonalInformation.setValue(user.getPersonalInformationFirstName());
        inputLastNamePersonalInformation.setValue(user.getPersonalInformationLastName());
        inputPasswordPersonalInformation.setValue(user.getPassword());
        inputAddress1.setValue(user.getAddress());
        inputCity.setValue(user.getCityUserAddress());
        selectState(String.valueOf(user.getUserState()));
        inputPostalCode.setValue(user.getZipCodeUserAddress());
        selectCountry(user.getCountry());
        inputMobilePhone.setValue(user.getMobilePhone());
        buttonRegister.click();
        return this;
    }
}