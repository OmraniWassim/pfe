package com.ltms.pfe.registration;

import com.ltms.pfe.app.user.AppUserRole;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String first_name;
    private final String last_name;
    private final String email;
    private final AppUserRole app_user_role;
    private final String password;


}
