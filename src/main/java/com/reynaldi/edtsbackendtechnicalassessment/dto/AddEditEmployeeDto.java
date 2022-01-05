package com.reynaldi.edtsbackendtechnicalassessment.dto;

import com.reynaldi.edtsbackendtechnicalassessment.constant.GradeEnum;
import com.reynaldi.edtsbackendtechnicalassessment.validator.constraint.EnumSubSet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddEditEmployeeDto {
    @NotNull(message = "ID must not be null")
    private Long employeeId;

    @NotNull(message = "name must not be null")
    @NotEmpty(message = "name must not be empty")
    private String name;

    @NotNull(message = "salary must not be null")
    private BigDecimal salary;

    @EnumSubSet(anyOf = {GradeEnum.MANAGER, GradeEnum.STAFF, GradeEnum.SUPERVISOR})
    private GradeEnum grade;
}
