package com.example.picture.model.enums;

import lombok.Getter;

@Getter
public enum PictureReviewStatusEnum {

    REVIEWING("待审核", 0),
    PASS("审核通过", 1),
    REJECT("审核拒绝", 2);

    private final String text;
    private final int value;

    PictureReviewStatusEnum(String text, int value) {
        this.text = text;
        this.value = value;
    }

    public static PictureReviewStatusEnum getByValue(int value) {
        for (PictureReviewStatusEnum status : PictureReviewStatusEnum.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        return null;


    }
}
