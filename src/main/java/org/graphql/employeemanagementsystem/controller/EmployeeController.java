package org.graphql.employeemanagementsystem.controller;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.graphql.employeemanagementsystem.model.Employee;
import org.graphql.employeemanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController  implements GraphQLMutationResolver {

    @Autowired
    private EmployeeRepository employeeRepository;

    @QueryMapping
    public Optional<Employee> findEmployeeById(@Argument Long id) {
        return employeeRepository.findById(id);
    }

    @QueryMapping
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @MutationMapping
    public Employee createEmployee(@Argument Employee addedEmployee){
        return employeeRepository.save(addedEmployee);
    }

    @MutationMapping
    public Employee updateEmployee(@Argument Long id, @Argument Employee updatedEmployee){
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("No employee found"));

        existingEmployee.setFirstName(updatedEmployee.getFirstName());
        existingEmployee.setLastName(updatedEmployee.getLastName());
        existingEmployee.setDepartment(updatedEmployee.getDepartment());
        existingEmployee.setDesignation(updatedEmployee.getDesignation());

        return employeeRepository.save(existingEmployee);

    }

    @MutationMapping
    public boolean deleteEmployee(@Argument Long id) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee does not exist"));
        employeeRepository.delete(existingEmployee);

        return true;
    }
}
