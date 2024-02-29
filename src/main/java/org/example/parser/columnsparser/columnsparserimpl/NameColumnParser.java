package org.example.parser.columnsparser.columnsparserimpl;

import lombok.NoArgsConstructor;
import org.example.parser.RowData;
import org.example.parser.columnsparser.BaseColumnParser;
import org.example.parser.ResultParser;
import org.example.parser.columnsparser.CannotParseReason;

@NoArgsConstructor
public class NameColumnParser implements BaseColumnParser {

    @Override
    public void correction(ResultParser resultParser, RowData rowData) {
        String name = rowData.getCurrentColumnValue();
        if (name.isEmpty()){
            resultParser.addErrorUsers(CannotParseReason.NAME_ERROR, rowData.getLineNumber());
        }
        else{
            rowData.getUser().setName(name);
        }
    }
}
