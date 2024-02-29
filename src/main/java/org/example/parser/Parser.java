package org.example.parser;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.experimental.UtilityClass;
import lombok.extern.java.Log;
import org.example.Jobs.User;
import org.example.UserGroup;
import org.example.parser.columnsparser.BaseColumnParser;
import org.example.parser.columnsparser.ColumnsParserFactory;

@UtilityClass
@Log
public class Parser {
    private static final List<String> COLUMN_NAMES = List.of("Profession", "UserId", "Name", "Age", "UserGroupId", "Country", "City", "Zipcode", "Sallary(euro)");

    public static void parse() throws IOException {
        //чтение файла
        String file = "src\\main\\resources\\UserParser.csv";
        FileReader filereader = new FileReader(file);
        CSVReader csvReader = new CSVReader(filereader);
        String[] nextRecord;
        log.info("Start of the program");


        Map<String, Integer> headerMap = getHeaderMap(csvReader, COLUMN_NAMES);

        ResultParser resultParser = new ResultParser();

        while ((nextRecord = csvReader.readNext()) != null) {
            RowData rowData = new RowData(csvReader.getLinesRead());
            for (String key : COLUMN_NAMES){
                try { //TODO
                    rowData.setCurrentColumnValue(nextRecord[headerMap.get(key)]);
                }
                catch (NullPointerException e){
                    throw new NullPointerException("The required column does not exist");
                }
                BaseColumnParser baseColumnParser = ColumnsParserFactory.createColumnParser(key);
                baseColumnParser.correction(resultParser, rowData);
                if (resultParser.findLineError(rowData.getLineNumber())){
                    break;
                }
            }
            resultParser.createResult(rowData);
        }
        output(resultParser);

    }

    private static Map<String, Integer> getHeaderMap(CSVReader csvReader, List<String> names){
        log.info("Possible error in table field names");
        List<String> columnNames;
        if (csvReader.getLinesRead() != 0){
            throw new RuntimeException("No Header Error");
        }
        try {
            columnNames = new ArrayList<>(Arrays.asList(csvReader.readNext()));
        }
        catch (Exception exception){
            throw new RuntimeException("No Header Error");
        }
        Map<String, Integer> headerMap = new HashMap<>();
        for (String name : names) {
            for (int j = 0; j < columnNames.size(); j++) {
                if (name.equals(columnNames.get(j))) {
                    headerMap.put(name, j);
                }
            }
        }
        return headerMap;
    }
    private static void output(ResultParser resultParser){
        resultParser.getUsersList().forEach(s -> System.out.println(s.getSalary() + " " + s.getYearSalary() + " " + s.getId()));
        for (Long userGroupId : resultParser.getGroups().keySet()) {
            UserGroup group = resultParser.getGroups().get(userGroupId);
            List<User> users = group.getUsers();
            System.out.println("GroupId: " + userGroupId);
            users.forEach(s -> System.out.print(s.getId() + " "));
            System.out.println();
        }
    }

}
