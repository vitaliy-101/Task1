package org.example.parser.columnsparser.columnsparserimpl;

import lombok.NoArgsConstructor;
import org.example.parser.RowData;
import org.example.parser.columnsparser.BaseColumnParser;
import org.example.parser.ResultParser;
import org.example.parser.columnsparser.CannotParseReason;

@NoArgsConstructor
public class CountryColumnParser implements BaseColumnParser {
    @Override
    public void correction(ResultParser resultParser, RowData rowData) {
        String country = rowData.getCurrentColumnValue();

        if (country.isEmpty()){
            resultParser.addErrorUsers(CannotParseReason.COUNTRY_ERROR, rowData.getLineNumber());
        }
        else{
            rowData.getUser().setCountry(country);
        }
    }
}
