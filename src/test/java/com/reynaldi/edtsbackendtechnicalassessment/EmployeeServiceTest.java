package com.reynaldi.edtsbackendtechnicalassessment;

import com.reynaldi.edtsbackendtechnicalassessment.constant.GradeEnum;
import com.reynaldi.edtsbackendtechnicalassessment.dto.AddEditEmployeeDto;
import com.reynaldi.edtsbackendtechnicalassessment.dto.EmployeeDataWithBonusDto;
import com.reynaldi.edtsbackendtechnicalassessment.model.Employee;
import com.reynaldi.edtsbackendtechnicalassessment.repository.EmployeeRepository;
import com.reynaldi.edtsbackendtechnicalassessment.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    private final String mockName = "John Doe";
    private final long mockId = 10001;
    private final BigDecimal mockSalary = new BigDecimal(1000000);

    AddEditEmployeeDto mockEmployeeDto = AddEditEmployeeDto.builder()
            .employeeId(mockId)
            .name(mockName)
            .salary(mockSalary)
            .grade(GradeEnum.MANAGER)
            .build();

    Employee mockEmployee = Employee.builder()
            .employeeId(mockEmployeeDto.getEmployeeId())
            .name(mockEmployeeDto.getName())
            .salary(mockEmployeeDto.getSalary())
            .grade(mockEmployeeDto.getGrade())
            .build();


    @Test
    void createUpdateEmployee_success() {

        when(employeeRepository.save(any())).thenReturn(mockEmployee);
        when(employeeRepository.findByEmployeeId(mockId)).thenReturn(Optional.of(mockEmployee));

        AddEditEmployeeDto actualResult = employeeService.addEditEmployeeService(
                mockEmployeeDto
        );
        assertNotNull(actualResult);
        assertEquals("John Doe", actualResult.getName());
    }

    @Test
    void getAllDataEmployeeWithBonusTest(){
        when(employeeRepository.findAll())
                .thenReturn(List.of(mockEmployee));

        List<EmployeeDataWithBonusDto> actualResult = employeeService.getAllEmployeeDataWithBonusService();
        assertNotNull(actualResult);
        assertEquals(1, actualResult.size());
    }
}
