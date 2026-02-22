package com.company.hrms.employee;

import com.company.hrms.user.User;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
@Schema(description = "Employee entity representing a company employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Schema(hidden = true) // Hide from Swagger
    private Long id;


    private String fullName;


    private String department;


    private String position;

    @OneToOne
    @JsonIgnore
    @Schema(hidden = true) // Hide User reference from Swagger
    private User user;
}
