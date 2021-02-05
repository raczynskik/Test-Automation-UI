package builder.userBuilder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserBuilder {
    UserTitle userTitle;
    String personalInformationFirstName;
    String personalInformationLastName;
    String password;
    String firstNameUserAddress;
    String lastNameUserAddress;
    String companyUserAddress;
    String address;
    String additionalAddress;
    String cityUserAddress;
    UserState userState;
    String zipCodeUserAddress;
    String country;
    String additionalInformationUserAddress;
    String homePhone;
    String mobilePhone;
    String aliasReference;
}