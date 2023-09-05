package org.example.parser.columnsparser.columnsparserimpl;

import lombok.NoArgsConstructor;
import org.example.parser.RowData;
import org.example.parser.columnsparser.BaseColumnParser;
import org.example.parser.ResultParser;
import org.example.parser.columnsparser.CannotParseReason;

@NoArgsConstructor
public class CityColumnParser implements BaseColumnParser {
    @Override
    public void correction(ResultParser resultParser, RowData rowData) {
        String city = rowData.getCurrentColumnValue();
        if (city.isEmpty()){
            resultParser.addErrorUsers(CannotParseReason.CITY_ERROR, rowData.getLineNumber());
        }
        else{
            rowData.getUser().setCity(city);
        }
    }
}
