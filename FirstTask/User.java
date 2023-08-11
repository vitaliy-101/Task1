package FirstTask;

import java.time.Year;

public class User {
    private String UserId, Name, Age, UserGroup, Profession, Country, City, Zipcode, Sallary;
    private String YearSalary = "0";

    public User(String[] userData){
        this.UserId = userData[0];
        this.Name = userData[1];
        this.Age = userData[2];
        this.UserGroup = userData[3];
        this.Profession = userData[4];
        this.Country = userData[5];
        this.City = userData[6];
        this.Zipcode = userData[7];
        this.Sallary = userData[8];
    }

    public String getUserId() {
        return UserId;
    }

    public String getName() {
        return Name;
    }

    public String getAge() {
        return Age;
    }

    public String getUserGroup() {
        return UserGroup;
    }

    public String getProfession() {
        return Profession;
    }

    public String getCountry() {
        return Country;
    }

    public String getCity() {
        return City;
    }

    public String getZipcode() {
        return Zipcode;
    }

    public String getSallary() {
        return Sallary;
    }

    public String getYearSalary() {
        return YearSalary;
    }

    public void setYearSalary() {
        if (!Profession.isEmpty()){
            if (Profession.equals("Student")){
                YearSalary = Sallary;
            }
            else if(Profession.equals("Developer")){
                YearSalary = String.valueOf((Integer.valueOf(Sallary) * 2 + Float.valueOf(Sallary.toString()) / 2));
            }
            else{
                YearSalary = String.valueOf(Integer.valueOf(Sallary) + 100);
            }
        }
        else{
            YearSalary = Sallary;
        }
    }

}
