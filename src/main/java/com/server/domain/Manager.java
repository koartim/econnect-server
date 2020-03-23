package com.server.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
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

    @ManyToMany(mappedBy = "managers")
    private Set<Project> projects = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "manager_id")
    private Set<Employee> employees = new HashSet<>();

}
