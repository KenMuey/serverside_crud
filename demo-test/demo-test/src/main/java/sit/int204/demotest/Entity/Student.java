package sit.int204.demotest.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    private Integer id;
    private String name;
    private Double gpax;
}
