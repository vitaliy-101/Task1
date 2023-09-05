package org.example.Jobs;


import java.util.HashMap;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.UserGroup;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher extends User {
    private Integer yearSalary;
    public Teacher(HashMap<String, String> dataUsers, UserGroup group) {
        super(dataUsers, group);
    }
    @Override
    public Integer calculateSalary() {
        Integer yearSalary = getSalary() * 12 + 100;
        setYearSalary(yearSalary);
        return yearSalary;
    }

}
