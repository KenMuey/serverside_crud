package sit.int204.classicmodelsservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodelsservice.entities.Employee;
import sit.int204.classicmodelsservice.entities.Office;
import sit.int204.classicmodelsservice.service.EmployeeService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping("")
    public List<Employee> getEmployee() {
        return service.getEmployees();
    }


    @GetMapping("/{employeeNumber}")
    public Employee getEmployeeById(@PathVariable Integer employeeNumber) {
        return service.getEmployee(employeeNumber);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee crate(@RequestBody Employee newEmployee) {

        return service.addNewEmployee(newEmployee);
    }

    @PutMapping("/{employeeNumber}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable Integer employeeNumber) {
        return service.updateEmployee(employeeNumber, employee);
    }


    @DeleteMapping("/{employeeNumber}")
    public void removeEmployee(@PathVariable Integer employeeNumber) {
        service.removeEmployee(employeeNumber);
    }
}


