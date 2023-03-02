package com.ltms.pfe.app.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
public enum AppUserRole {
    RESPONSABLE("RESPONSABLE"),
    CHAUFFEUR("CHAUFFEUR"),
    RH("RH");
    private final String appUserRole;
    AppUserRole(String appUserRole){
        this.appUserRole=appUserRole;
    }
}
