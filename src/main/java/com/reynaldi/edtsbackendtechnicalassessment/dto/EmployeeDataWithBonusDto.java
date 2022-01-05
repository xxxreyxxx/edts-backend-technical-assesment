package com.reynaldi.edtsbackendtechnicalassessment.dto;

import com.reynaldi.edtsbackendtechnicalassessment.constant.GradeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDataWithBonusDto {

    private long employeeId;
    private String name;
    private BigDecimal salary;
    private GradeEnum gradeCode;
    private BigDecimal totalBonus;
}
