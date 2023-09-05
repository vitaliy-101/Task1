package org.example.parser.columnsparser.columnsparserimpl;

import java.util.Optional;
import lombok.NoArgsConstructor;
import org.example.Jobs.Developer;
import org.example.Jobs.Student;
import org.example.Jobs.Teacher;
import org.example.Jobs.User;
import org.example.parser.RowData;
import org.example.parser.columnsparser.BaseColumnParser;
import org.example.parser.ResultParser;
import org.example.parser.columnsparser.CannotParseReason;

@NoArgsConstructor
public class ProfessionColumnParser implements BaseColumnParser {

    @Override
    public void correction(ResultParser resultParser, RowData rowData) {
        String profession = rowData.getCurrentColumnValue();

        if (profession.isEmpty()) {
            resultParser.addErrorUsers(CannotParseReason.PROFESSION_ERROR, rowData.getLineNumber());
        } else {
            switch (profession) {
                case "Student" -> rowData.setUser(new Student());
                case "Developer" -> rowData.setUser(new Developer());
                case "Teacher" -> rowData.setUser(new Teacher());
                default -> resultParser.addErrorUsers(CannotParseReason.PROFESSION_ERROR, rowData.getLineNumber());
            }

        }

    }
}
