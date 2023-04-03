package sit.int204.demotest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import sit.int204.demotest.Entity.Student;
import sit.int204.demotest.Services.StudentService;

import java.util.ArrayList;
import java.util.List;

@Controller
public
class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping("/initialize")
    public ResponseEntity<String> init() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1001, "Somchai", 3.20));
        studentList.add(new Student(1002, "Somsak", 3.50));
        studentList.add(new Student(1003, "Somsri", 2.50));
        studentList.add(new Student(1004, "Somkiat", 3.75));
        studentList.add(new Student(1005, "Somchoke", 2.80));
        service.saveAll(studentList);
        String message = "5 new Students have added !!!";
        return new ResponseEntity(message, HttpStatus.OK);
    }
}