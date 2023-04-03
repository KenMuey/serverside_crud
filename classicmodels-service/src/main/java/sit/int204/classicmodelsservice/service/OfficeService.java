package sit.int204.classicmodelsservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import sit.int204.classicmodelsservice.entities.Employee;
import sit.int204.classicmodelsservice.entities.Office;
import sit.int204.classicmodelsservice.exception.ItemNotFoundException;
import sit.int204.classicmodelsservice.repository.EmployeeRepository;
import sit.int204.classicmodelsservice.repository.OfficeRepository;

import java.util.List;
import java.util.Set;

@Service
public class OfficeService {
    @Autowired
    private OfficeRepository repository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public Set<Employee> getEmployees(String officeCode) {
        Office office = repository.findById(officeCode).orElseThrow(
                () -> new HttpClientErrorException(HttpStatus.NOT_FOUND,
                        "Office Id" + officeCode + " dose not exist !!!")
        );
        return office.getEmployees();
    }


    public List<Office> getOffices() {
        return repository.findAll();
    }

    public Office getOffice(String officeCode) {
        return repository.findById(officeCode).orElseThrow(() -> new RuntimeException(officeCode + " dose not exist !!!"));
    }

    public Office addNewOffice(Office newOffice) {
        return repository.saveAndFlush(newOffice);
    }

    public void removeOffice(String officeCode) {
        Office office = repository.findById(officeCode).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Office Id " + officeCode + " DOES NOT EXIST !!!"));
        repository.delete(office);
    }

    public Office updateOffice(String officeCode, Office office) {
        Office existingOffice = repository.findById(officeCode).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Office Id " + officeCode + " DOES NOT EXIST !!!"));
        existingOffice.setCountry(office.getCountry());
        existingOffice.setAddressLine1(office.getAddressLine1());
        existingOffice.setAddressLine2(office.getAddressLine2());
        existingOffice.setPhone(office.getPhone());
        return repository.saveAndFlush(existingOffice);
    }

    public Employee addnewemp(String officeCode, Employee newEmployee) {
        Office office = repository.findById(officeCode)
                .orElseThrow(() ->
                        new HttpClientErrorException(HttpStatus.NOT_FOUND,
                                "Office Id " + officeCode + " DOES NOT EXIST !!!"));

        newEmployee.setOffice(office);
        return employeeRepository.saveAndFlush(newEmployee);

    }



    public Office getOfficeByIdExcept(String officeCode) {
        return repository.findById(officeCode).orElseThrow(() -> new ItemNotFoundException("Office code:" + officeCode + "dose not exists !!!")); }
}
