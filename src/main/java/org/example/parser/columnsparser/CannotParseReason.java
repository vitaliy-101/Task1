package org.example.parser.columnsparser;

import lombok.Getter;

@Getter
public enum CannotParseReason {
    CITY_ERROR("The city must have a name"),
    AGE_ERROR("The age must be greater than zero and less than 200"),
    COUNTRY_ERROR("The country must have a name"),
    NAME_ERROR("The name must have a name"),
    PROFESSION_ERROR("The profession must have a name"),
    SALARY_ERROR("The salary should not be empty"),
    USER_ID_GROUP_ERROR("The user group id must have a name"),
    USER_ID_ERROR("The user id must have a name"),
    ZIPCODE_ERROR("The zipcode should have a length of 5 or 9");
    private String title;
    CannotParseReason(String title){
        this.title = title;
    }

}
