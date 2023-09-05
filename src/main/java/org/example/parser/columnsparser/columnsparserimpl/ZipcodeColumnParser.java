package org.example.parser.columnsparser.columnsparserimpl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.NoArgsConstructor;
import org.example.parser.RowData;
import org.example.parser.columnsparser.BaseColumnParser;
import org.example.parser.ResultParser;
import org.example.parser.columnsparser.CannotParseReason;

@NoArgsConstructor
public class ZipcodeColumnParser implements BaseColumnParser {
    @Override
    public void correction(ResultParser resultParser, RowData rowData) {
        String zipcode = rowData.getCurrentColumnValue();
        Pattern pattern = Pattern.compile("^\\d{5}(?:[-\\s]\\d{4})?$");
        Matcher matcher = pattern.matcher(zipcode);
        if (!matcher.matches()){
            resultParser.addErrorUsers(CannotParseReason.ZIPCODE_ERROR, rowData.getLineNumber());
        }
        else{
            rowData.getUser().setZipcode(zipcode);
        }


    }
}
