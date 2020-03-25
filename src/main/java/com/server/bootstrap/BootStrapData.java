package com.server.bootstrap;

import com.server.domain.Employee;
import com.server.domain.Manager;
import com.server.domain.Project;
import com.server.repositories.EmployeeRepository;
import com.server.repositories.ManagerRepository;
import com.server.repositories.ProjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
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

        Project project = new Project();
        project.setName("IBM");
        project.setBudget(1000000L);
        project.getEmployees().add(employee);
        projectRepository.save(project);

        Manager manager = new Manager();
        manager.setFirstName("Sachin");
        manager.setLastName("Pandhare");
        manager.setSalary(120000L);
        manager.getProjects().add(project);
        manager.getEmployees().add(employee);
        managerRepository.save(manager);







    }
}
