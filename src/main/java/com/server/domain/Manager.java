package com.server.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private Long Salary;

    @ManyToMany(mappedBy = "projects")
    private Set<Project> projects = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "manager_id")
    private Set<Employee> employees = new HashSet<>();

}
