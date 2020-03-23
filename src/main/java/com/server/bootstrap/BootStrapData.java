package com.server.bootstrap;

import com.server.domain.Employee;
import com.server.domain.Manager;
import com.server.domain.Project;
import com.server.repositories.EmployeeRepository;
import com.server.repositories.ManagerRepository;
import com.server.repositories.ProjectRepository;
import org.springframework.boot.CommandLineRunner;

public class BootStrapData implements CommandLineRunner {

    private EmployeeRepository employeeRepository;
    private ManagerRepository managerRepository;
    private ProjectRepository projectRepository;

    public BootStrapData(EmployeeRepository employeeRepository, ManagerRepository managerRepository, ProjectRepository projectRepository) {
        this.employeeRepository = employeeRepository;
        this.managerRepository = managerRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");

        Employee employee = new Employee();
        employee.setFirstName("Tim");
        employee.setLastName("Koar");
        employee.setSalary(57000L);

        employeeRepository.save(employee);

        Manager manager =  new Manager();
        manager.setFirstName("Sachin");
        manager.setLastName("Pandhare");
        manager.getEmployees().add(employee);
        managerRepository.save(manager);

        Project project = new Project();
        project.setBudget(10000000L);
        project.setName("IBM");


    }
}
