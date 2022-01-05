package com.reynaldi.edtsbackendtechnicalassessment.validator;

import com.reynaldi.edtsbackendtechnicalassessment.constant.GradeEnum;
import com.reynaldi.edtsbackendtechnicalassessment.validator.constraint.EnumSubSet;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EnumNotExistsValidator
  implements ConstraintValidator<EnumSubSet, GradeEnum> {
  private GradeEnum[] subset;

  @Override
  public void initialize(EnumSubSet constraint) {
    this.subset = constraint.anyOf();
  }

  @Override
  public boolean isValid(GradeEnum value, ConstraintValidatorContext context) {

    if (value == null) {
      return false;
    }
    List<? extends Enum> matchEnumList = Arrays
            .stream(subset)
            .filter(anEnum -> anEnum == value)
            .collect(Collectors.toList());
    return !matchEnumList.isEmpty();
  }
}
