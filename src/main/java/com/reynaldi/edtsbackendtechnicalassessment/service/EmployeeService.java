package com.reynaldi.edtsbackendtechnicalassessment.service;

import com.reynaldi.edtsbackendtechnicalassessment.dto.AddEditEmployeeDto;
import com.reynaldi.edtsbackendtechnicalassessment.dto.EmployeeDataWithBonusDto;
import com.reynaldi.edtsbackendtechnicalassessment.model.Employee;
import com.reynaldi.edtsbackendtechnicalassessment.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public AddEditEmployeeDto addEditEmployeeService(AddEditEmployeeDto employeeDto) {

        Optional<Employee> employeeOptional = employeeRepository.findByEmployeeId(employeeDto.getEmployeeId());

        Employee employee = new Employee();

        if (employeeOptional.isPresent()) {
            employee = employeeOptional.get();
        }

        employee.setEmployeeId(employeeDto.getEmployeeId());
        employee.setName(employeeDto.getName());
        employee.setSalary(employeeDto.getSalary());
        employee.setGrade(employeeDto.getGrade());

        employeeRepository.save(employee);

        return employeeDto;
    }

    public List<EmployeeDataWithBonusDto> getAllEmployeeDataWithBonusService() {
        Iterable<Employee> employees = employeeRepository.findAll();

        List<EmployeeDataWithBonusDto> employeeDataWithBonusDtos = new ArrayList<>();
        employees.forEach(employee -> {
            BigDecimal salary = employee.getSalary();
            BigDecimal bonus = salary.multiply(new BigDecimal(employee.getGrade().getPercentage())).divide(BigDecimal.valueOf(100));
            BigDecimal totalBonus = salary.add(bonus);
            EmployeeDataWithBonusDto employeeDataWithBonusDto = EmployeeDataWithBonusDto.builder()
                    .employeeId(employee.getEmployeeId())
                    .name(employee.getName())
                    .salary(salary)
                    .gradeCode(employee.getGrade())
                    .totalBonus(totalBonus)
                    .build();
            employeeDataWithBonusDtos.add(employeeDataWithBonusDto);
        });
        return employeeDataWithBonusDtos;
    }
}
