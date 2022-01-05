package com.reynaldi.edtsbackendtechnicalassessment.model;

import com.reynaldi.edtsbackendtechnicalassessment.constant.GradeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private long employeeId;

    @Column(length = 50)
    private String name;

    private BigDecimal salary = BigDecimal.ZERO;

    private GradeEnum grade;
}
