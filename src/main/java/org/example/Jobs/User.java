package org.example.Jobs;


import java.util.HashMap;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.UserGroup;
@Getter
@Setter
@NoArgsConstructor
public abstract class User {
    private Long id;
    private String name;
    private Integer age;
    private UserGroup group;
    private String profession;
    private String country;
    private String city;
    private String zipcode;
    private Integer salary;
    private Integer yearSalary;

    public User(HashMap<String, String> dataUsers,  UserGroup group){
        this.id = Long.valueOf(dataUsers.get("UserId"));
        this.name = dataUsers.get("Name");
        this.age = Integer.valueOf(dataUsers.get("Age"));
        this.profession = dataUsers.get("Profession");
        this.country = dataUsers.get("Country");
        this.city = dataUsers.get("City");
        this.zipcode = dataUsers.get("Zipcode");
        this.salary = Integer.valueOf(dataUsers.get("Sallary(euro)"));
        this.yearSalary =Integer.valueOf(dataUsers.get("Sallary(euro)"));
        this.group = group;
    }

    public abstract Integer calculateSalary();


}
