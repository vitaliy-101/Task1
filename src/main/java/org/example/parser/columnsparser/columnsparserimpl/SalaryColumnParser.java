package org.example.parser.columnsparser.columnsparserimpl;

import org.example.parser.ResultParser;
import org.example.parser.RowData;
import org.example.parser.columnsparser.BaseColumnParser;
import org.example.parser.columnsparser.CannotParseReason;

public class SalaryColumnParser implements BaseColumnParser {

    @Override
    public void correction(ResultParser resultParser, RowData rowData) {
        String salary = rowData.getCurrentColumnValue();
        if (salary.isEmpty()){
            resultParser.addErrorUsers(CannotParseReason.SALARY_ERROR, rowData.getLineNumber());
        }
        else{
            rowData.getUser().setSalary(Integer.valueOf(salary));
        }
    }
}
