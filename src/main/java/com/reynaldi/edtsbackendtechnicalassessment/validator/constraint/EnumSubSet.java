package com.reynaldi.edtsbackendtechnicalassessment.validator.constraint;

import com.reynaldi.edtsbackendtechnicalassessment.constant.GradeEnum;
import com.reynaldi.edtsbackendtechnicalassessment.validator.EnumNotExistsValidator;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = { EnumNotExistsValidator.class })
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface EnumSubSet {
  GradeEnum[] anyOf();
  String message() default "grade must be any of 1,2,3";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
