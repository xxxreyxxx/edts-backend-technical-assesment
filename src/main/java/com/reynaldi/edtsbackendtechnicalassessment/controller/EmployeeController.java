package com.reynaldi.edtsbackendtechnicalassessment.controller;

import com.reynaldi.edtsbackendtechnicalassessment.dto.AddEditEmployeeDto;
import com.reynaldi.edtsbackendtechnicalassessment.dto.EmployeeDataWithBonusDto;
import com.reynaldi.edtsbackendtechnicalassessment.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@Api(value = "Employee Controller")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add-update-employee")
    @ApiOperation(value = "Create or update employee")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 201, message = "CREATED", response = AddEditEmployeeDto.class),
                    @ApiResponse(code = 400, message = "Bad request due to incorrect payload")
            }
    )
    @ResponseStatus(value = HttpStatus.CREATED)
    public AddEditEmployeeDto createAccount(
            @RequestBody @Valid AddEditEmployeeDto request
    ) {
        return employeeService.addEditEmployeeService(request);
    }

    @GetMapping("/get-data-bonus-employee")
    @ApiOperation(value = "get all data employee with bonus")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "OK", response = EmployeeDataWithBonusDto.class)
            }
    )
    @ResponseStatus(value = HttpStatus.OK)
    public List<EmployeeDataWithBonusDto> getAllDataWithBonusController() {
        return employeeService.getAllEmployeeDataWithBonusService();
    }
}