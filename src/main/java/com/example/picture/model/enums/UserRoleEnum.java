package com.example.picture.model.enums;

import lombok.Getter;

@Getter
public enum UserRoleEnum {
    ADMIN("管理员", "admin"),
    USER("用户", "user");
    private String text;
    private String value;
    UserRoleEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    public static UserRoleEnum getEnumByValue(String value) {
        for (UserRoleEnum userRoleEnum : UserRoleEnum.values()) {
            if (userRoleEnum.getValue().equals(value)) {
                return userRoleEnum;
            }
        }
        return null;
    }


}
