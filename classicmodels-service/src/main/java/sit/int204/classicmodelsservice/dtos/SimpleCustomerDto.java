package sit.int204.classicmodelsservice.dtos;

import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

@Getter
@Setter
public class SimpleCustomerDto {
    private String customerName;
    private String phone;
    private String city;
    private String country;
    //    private String sales; //ดูว่าเป็นส่วนหนึ่งของsalesrep
    @JsonIgnore
    private SimpleEmployeeDto salesRepEmployee;
public String getSalesPerson(){
    return salesRepEmployee == null ? "-" : salesRepEmployee.getName();}
}


