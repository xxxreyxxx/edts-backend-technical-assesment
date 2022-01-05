package com.reynaldi.edtsbackendtechnicalassessment.constant;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public enum GradeEnum {

    MANAGER(1, 10), SUPERVISOR(2, 6), STAFF(3, 3);

    private int code;
    private int percentage;

    @JsonCreator
    public static GradeEnum getByCode(final int value) {
        for (final GradeEnum g : GradeEnum.values()) {
            if (g.code == value) {
                return g;
            }
        }
        return null;
    }

    @JsonValue
    public int getCode() {
        return code;
    }

    public int getPercentage() {
        return percentage;
    }
}
