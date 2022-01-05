package com.reynaldi.edtsbackendtechnicalassessment.repository;

import com.reynaldi.edtsbackendtechnicalassessment.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmployeeId(long id);
}
