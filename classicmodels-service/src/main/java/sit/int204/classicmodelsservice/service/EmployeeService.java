package sit.int204.classicmodelsservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import sit.int204.classicmodelsservice.entities.Employee;
import sit.int204.classicmodelsservice.entities.Office;
import sit.int204.classicmodelsservice.repository.EmployeeRepository;
import sit.int204.classicmodelsservice.repository.OfficeRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;


    public List<Employee> getEmployees() {
        return repository.findAll();
    }

    public Employee getEmployee(Integer employeeNumber) {
        return repository.findById(employeeNumber).orElseThrow(() ->
                new RuntimeException(employeeNumber + " dose not exist !!!"));
    }

    public Employee addNewEmployee(Employee newEmployee) {
        return repository.saveAndFlush(newEmployee);
    }

    public void removeEmployee(Integer employeeNumber) {
        Employee employee = repository.findById(employeeNumber).orElseThrow(() ->
                new HttpClientErrorException(HttpStatus.NOT_FOUND, "Employee Id " + employeeNumber + " DOES NOT EXIST !!!"));
        repository.delete(employee);
    }

    public Employee updateEmployee(Integer employeeNumber, Employee employee) {
        Employee existingEmployee = repository.findById(employeeNumber).orElseThrow(() ->
                new HttpClientErrorException(HttpStatus.NOT_FOUND, "Employee Id " + employeeNumber + " DOES NOT EXIST !!!"));
        existingEmployee.setLastname(employee.getLastname());
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setJobTitle(employee.getJobTitle());
        existingEmployee.setReportsTo(employee.getReportsTo());
        existingEmployee.setExtension(employee.getExtension());
        return repository.saveAndFlush(existingEmployee);

    }
}

