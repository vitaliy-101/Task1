package org.example.Jobs;


import java.util.HashMap;
import lombok.NoArgsConstructor;
import org.example.UserGroup;
@NoArgsConstructor
public class Developer extends User {
    private Integer yearSalary;
    public Developer(HashMap<String, String> dataUsers,  UserGroup group) {
        super(dataUsers, group);
    }
    @Override
    public Integer calculateSalary() {
        Integer yearSalary = getSalary() * 12 + getSalary() + getSalary() / 2;
        setYearSalary(yearSalary);
        return yearSalary;
    }
}
