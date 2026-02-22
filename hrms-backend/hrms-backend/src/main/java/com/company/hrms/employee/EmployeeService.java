package com.company.hrms.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.access.prepost.PreAuthorize;
import com.company.hrms.employee.EmployeeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee emp) {
        Employee e = employeeRepository.findById(id).orElseThrow();
        e.setFullName(emp.getFullName());
        e.setDepartment(emp.getDepartment());
        e.setPosition(emp.getPosition());
        return employeeRepository.save(e);
    }


    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
