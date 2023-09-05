package org.example.Jobs;


import java.util.HashMap;
import lombok.NoArgsConstructor;
import org.example.UserGroup;
@NoArgsConstructor
public class Student extends User {
    public Student(HashMap<String, String> dataUsers, UserGroup group) {
        super(dataUsers, group);
    }


    @Override
    public Integer calculateSalary() {
        Integer yearSalary = getSalary() * 12;
        setYearSalary(yearSalary);
        return yearSalary;
    }
}
