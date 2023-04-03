package sit.int204.demotest.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.int204.demotest.Entity.Student;
import sit.int204.demotest.Repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public void saveAll(List<Student> students) {
        repository.saveAllAndFlush(students);
    }

    public List<Student> getAll() {
        return repository.findAll();
    }

    public void save(Student s) {
         repository.saveAndFlush(s);
    }
}