package sit.int204.demotest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.demotest.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}