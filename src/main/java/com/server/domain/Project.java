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
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long budget;

    @ManyToMany
    @JoinTable(name = "manager_project", joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "manager_id"))
    private Set<Manager> managers = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "project_id")
    private Set<Employee> employees =  new HashSet<>();


}
