package FirstTask.Jobs;

import FirstTask.UserGroup;

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

    public User(String id, String name, String age, String profession, String country, String city, String zipcode, String salary, UserGroup group){
        this.id = Long.valueOf(id);
        this.name = name;
        this.age = Integer.valueOf(age);
        this.profession = profession;
        this.country = country;
        this.city = city;
        this.zipcode = zipcode;
        this.salary = Integer.valueOf(salary);
        this.yearSalary =Integer.valueOf(salary);
        this.group = group;
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public UserGroup getGroup() {
        return group;
    }

    public String getProfession() {
        return profession;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setGroup(UserGroup group) {
        this.group = group;
    }

    public Integer getSalary() {
        return salary;
    }

    public Integer getYearSalary() {
        return yearSalary;
    }

    public void setYearSalary(Integer yearSalary) {
        this.yearSalary = yearSalary;
    }
    public abstract Integer calculateSalary();


}
