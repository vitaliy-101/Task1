package org.example.parser;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.experimental.UtilityClass;
import org.example.Jobs.User;
import org.example.UserGroup;
import org.example.parser.columnsparser.BaseColumnParser;
import org.example.parser.columnsparser.ColumnsParserFactory;

@UtilityClass
public class Parser {
    private static final List<String> COLUMN_NAMES = List.of("Profession", "UserId", "Name", "Age", "UserGroupId", "Country", "City", "Zipcode", "Sallary(euro)");
    public static void parse() throws IOException {
        //чтение файла
        String file = "src\\main\\resources\\UserParser.csv";
        FileReader filereader = new FileReader(file);
        CSVReader csvReader = new CSVReader(filereader);
        String[] nextRecord;

        Map<String, Integer> headerMap = getHeaderMap(csvReader, COLUMN_NAMES);

        ResultParser resultParser = new ResultParser();

        while ((nextRecord = csvReader.readNext()) != null) {
            RowData rowData = new RowData(csvReader.getLinesRead());
            for (String key : COLUMN_NAMES){
                rowData.setCurrentColumnValue(nextRecord[headerMap.get(key)]);
                BaseColumnParser baseColumnParser = ColumnsParserFactory.createColumnParser(key);
                baseColumnParser.correction(resultParser, rowData);
                if (resultParser.findProfessionError(rowData.getLineNumber())){
                    break;
                }

            }
            resultParser.createResult(rowData);

        }
        output(resultParser);

    }

    private static Map<String, Integer> getHeaderMap(CSVReader csvReader, List<String> names){
        List<String> columnNames = new ArrayList<>();
        if (csvReader.getLinesRead() != 0){
            throw new RuntimeException("No Header Error");
        }
        try {
            for (String cell : csvReader.readNext()) {
                columnNames.add(cell);
            }
        }
        catch (Exception exception){
            throw new RuntimeException("No Header Error");
        }
        Map<String, Integer> headerMap = new HashMap<>();
        for (int i = 0; i < names.size(); i ++){
            for (int j = 0; j < columnNames.size(); j ++){
                if (names.get(i).equals(columnNames.get(j))){
                    headerMap.put(names.get(i), j);
                }
            }
        }
        return headerMap;
    }
    private static void output(ResultParser resultParser){
        for (int i = 0; i < resultParser.getUsersList().size(); i++) {
            System.out.println(resultParser.getUsersList().get(i).getSalary() + " " + resultParser.getUsersList().get(i).getYearSalary() + " " + resultParser.getUsersList().get(i).getId());
        }

        for (Long userGroupId : resultParser.getGroups().keySet()) {
            UserGroup group = resultParser.getGroups().get(userGroupId);
            List<User> users = group.getUsers();
            System.out.println(userGroupId);
            for (int i = 0; i < users.size(); i++) {
                System.out.print(users.get(i).getId() + " ");
            }
            System.out.println();
            System.out.println("---------------");
        }
    }

}
