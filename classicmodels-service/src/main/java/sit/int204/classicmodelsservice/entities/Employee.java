package sit.int204.classicmodelsservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name = "employeeNumber", nullable = false)
    private Integer id;

    @Column(name = "lastName", nullable = false, length = 50)
    private String lastname;
    @Column(name = "firstName", nullable = false, length = 50)
    private String firstName;
    @Column(name = "extension", nullable = false, length = 10)
    private String extension;
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    @Column(name = "jobTitle", nullable = false, length = 50)
    private String jobTitle;
    private Integer reportsTo;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "OfficeCode")
    private Office office;

    @Override
    public String toString(){
        return jobTitle;
    }
}
