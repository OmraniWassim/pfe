package com.ltms.pfe.registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


public record LoginRequest(String email, String password) {
}
