package org.example.parser.columnsparser.columnsparserimpl;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.Jobs.User;
import org.example.parser.RowData;
import org.example.parser.columnsparser.BaseColumnParser;
import org.example.parser.ResultParser;
import org.example.parser.columnsparser.CannotParseReason;

@Getter
@Setter
@NoArgsConstructor
public class UserIdColumnParser implements BaseColumnParser {

    @Override
    public void correction(ResultParser resultParser, RowData rowData) {
        Long userId = Long.valueOf(rowData.getCurrentColumnValue());
        List<User> usersList = resultParser.getUsersList();
        rowData.getUser().setId(userId);
        if (!usersList.isEmpty() && usersList.stream().anyMatch(x -> x.getId().equals(userId))){
            resultParser.addErrorUsers(CannotParseReason.USER_ID_ERROR, rowData.getLineNumber());
        }
    }
}
