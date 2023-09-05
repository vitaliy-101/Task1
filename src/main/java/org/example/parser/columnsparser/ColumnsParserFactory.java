package org.example.parser.columnsparser;

import lombok.experimental.UtilityClass;
import org.example.parser.columnsparser.columnsparserimpl.AgeColumnParser;
import org.example.parser.columnsparser.columnsparserimpl.CityColumnParser;
import org.example.parser.columnsparser.columnsparserimpl.CountryColumnParser;
import org.example.parser.columnsparser.columnsparserimpl.DefaultColumnParser;
import org.example.parser.columnsparser.columnsparserimpl.NameColumnParser;
import org.example.parser.columnsparser.columnsparserimpl.ProfessionColumnParser;
import org.example.parser.columnsparser.columnsparserimpl.SalaryColumnParser;
import org.example.parser.columnsparser.columnsparserimpl.UserGroupIdColumnParser;
import org.example.parser.columnsparser.columnsparserimpl.UserIdColumnParser;
import org.example.parser.columnsparser.columnsparserimpl.ZipcodeColumnParser;

@UtilityClass
public class ColumnsParserFactory {
    public static BaseColumnParser createColumnParser(String columnName){
        return switch (columnName){
            case "UserId" -> new UserIdColumnParser();
            case "Name" -> new NameColumnParser();
            case "Age" -> new AgeColumnParser();
            case "UserGroupId" -> new UserGroupIdColumnParser();
            case "Profession" -> new ProfessionColumnParser();
            case "Country" -> new CountryColumnParser();
            case "City" -> new CityColumnParser();
            case "Zipcode" -> new ZipcodeColumnParser();
            case "Sallary(euro)" -> new SalaryColumnParser();
            default -> new DefaultColumnParser();
        };
    }
}
