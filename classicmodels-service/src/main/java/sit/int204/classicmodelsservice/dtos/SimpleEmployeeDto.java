package sit.int204.classicmodelsservice.dtos;

import lombok.Getter;
import lombok.Setter;

//@Setter
//@Getter
//public class SimpleEmployeeDto {
//    private String lastName;
//    private String firstName;
//}

//แยกชื่อ นามสกุล คนละบรรทัด
@Setter
//@Getter
public class SimpleEmployeeDto {
    private String lastName;
    private String firstName;

    public String getName() {
        return firstName + " " + lastName;
    }
}
//จะรวมเป็นบรรทัดเดียวกัน

//@Setter
//public class SimpleEmployeeDto {
//    private String lastName;
//    private String firstName;
//
//    public String getName() {
//        return firstName + " " + lastName;
//    }
//}