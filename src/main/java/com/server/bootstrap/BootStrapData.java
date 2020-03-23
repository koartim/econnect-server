package com.server.bootstrap;

import com.server.domain.Employee;
import com.server.domain.Manager;
import com.server.domain.Project;
import com.server.repositories.EmployeeRepository;
import com.server.repositories.ManagerRepository;
import com.server.repositories.ProjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
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
        project.setBudget(10000000L);
        project.setName("IBM");
        projectRepository.save(project);

        Manager manager =  new Manager();
        manager.setFirstName("Sachin");
        manager.setLastName("Pandhare");
        manager.setSalary(120000L);
        manager.getEmployees().add(employee);
        manager.getProjects().add(project);
        managerRepository.save(manager);

        project.getManagers().add(manager);
        project.getEmployees().add(employee);
        projectRepository.save(project);

        employee.setProject(project);
        employee.setManager(manager);
        employeeRepository.save(employee);

        System.out.println(managerRepository.count());
        System.out.println(projectRepository.count());
        System.out.println(employeeRepository.count());

        System.out.println("Individual entity data");

        System.out.println(project.getEmployees().size() + ": number of employees on project");

        System.out.println(manager.getEmployees().size() + ": number of employees under manager");

        System.out.println(employee.getManager().getFirstName() + ": name of tims manager");
        System.out.println(employee.getProject().getName() + ": name of the project tim is on");
    }
}
