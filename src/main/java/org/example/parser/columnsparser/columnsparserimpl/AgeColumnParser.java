package org.example.parser.columnsparser.columnsparserimpl;

import lombok.NoArgsConstructor;
import org.example.parser.RowData;
import org.example.parser.columnsparser.BaseColumnParser;
import org.example.parser.ResultParser;
import org.example.parser.columnsparser.CannotParseReason;

@NoArgsConstructor
public class AgeColumnParser implements BaseColumnParser {
    @Override
    public void correction(ResultParser resultParser, RowData rowData) {
        int age = Integer.parseInt(rowData.getCurrentColumnValue());
        if (age < 0 || age > 200){
            resultParser.addErrorUsers(CannotParseReason.AGE_ERROR, rowData.getLineNumber());
        }
        else {
            rowData.getUser().setAge(age);
        }
    }
}
