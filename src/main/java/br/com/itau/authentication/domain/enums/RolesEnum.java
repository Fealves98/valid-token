package br.com.itau.authentication.domain.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum RolesEnum {

    ADMIN("Admin"), MEMBER("Member"), EXTERNAL("External");

    private String value;

    public static boolean contains(String value) {
        for (RolesEnum role : RolesEnum.values()) {
            if (role.value.equals(value)) {
                return true;
            }
        }
        return false;
    }
}
