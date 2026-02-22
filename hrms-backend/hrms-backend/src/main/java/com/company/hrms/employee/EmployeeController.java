package com.company.hrms.employee;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> all() { return employeeService.getAllEmployees(); }

    // In your controller or service
    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        // Don't set employee.setId(0) or any ID
        // Let JPA auto-generate it
        Employee saved = employeeService.createEmployee(employee);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee emp) {
        return employeeService.updateEmployee(id, emp);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { employeeService.deleteEmployee(id); }



}
