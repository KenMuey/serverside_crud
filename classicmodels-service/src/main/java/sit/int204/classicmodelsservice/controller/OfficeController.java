package sit.int204.classicmodelsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodelsservice.entities.Employee;
import sit.int204.classicmodelsservice.entities.Office;
import sit.int204.classicmodelsservice.service.OfficeService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/offices")
public class OfficeController {
    @Autowired
    private OfficeService service;

    @GetMapping("")
    public List<Office> getOffice() {
        return service.getOffices();
    }

    @GetMapping("/{officeCode}/employees")
    public Set<Employee> getEmployees(@PathVariable String officeCode) {

        return service.getEmployees(officeCode);
    }

//    @GetMapping("/{officeCode}")
//    public Office getOfficeById(@PathVariable String officeCode) {
//
//        return service.getOffice(officeCode);
//    }
        @GetMapping("/{officeCode}")
    public Office getOfficeById(@PathVariable String officeCode) {

        return service.getOfficeByIdExcept(officeCode);
    }

    @PostMapping( "/{officeCode}/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee crateemp( @PathVariable String officeCode,@RequestBody Employee newEmployee) {
        return service.addnewemp(officeCode,newEmployee);
    }
//
//    @PostMapping(value = "/{officeCode}/employees")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Employee addNewEmployeeToOffice(@PathVariable String officeCode, @RequestBody Employee newEmployee) {
//        return service.addNewEmployeeToOffice(officeCode, newEmployee);
//    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Office crate(@RequestBody Office newOffice) {
        return service.addNewOffice(newOffice);
    }

    @PutMapping("/{officeCode}")
    public Office updateOffice(@RequestBody Office office, @PathVariable String officeCode) {
        return service.updateOffice(officeCode, office);
    }

    @DeleteMapping("/{officeCode}")
    public void removeOffice(@PathVariable String officeCode) {
        service.removeOffice(officeCode);
    }



}
