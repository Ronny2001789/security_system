package com.company.hrms.leave;

import com.company.hrms.employee.Employee;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class LeaveRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;

    private String status; // PENDING, APPROVED, REJECTED

    @ManyToOne
    private Employee employee;
}
