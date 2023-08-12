package FirstTask.Jobs;

import FirstTask.Jobs.User;
import FirstTask.UserGroup;

public class Developer extends User {
    private Integer yearSalary;
    public Developer(String id, String name, String age, String profession, String country, String city, String zipcode, String salary, UserGroup group) {
        super(id, name, age, profession, country, city, zipcode, salary, group);
    }
    @Override
    public Integer calculateSalary() {
        Integer yearSalary = getSalary() * 12 + getSalary() + getSalary() / 2;
        setYearSalary(yearSalary);
        return yearSalary;
    }
}
