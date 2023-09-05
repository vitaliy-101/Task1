package org.example.parser.columnsparser.columnsparserimpl;

import java.util.List;
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
        if (!usersList.isEmpty()){
            for(int i = 0; i < usersList.size(); i ++) {
                if (usersList.get(i).getId().equals(userId)) {
                    resultParser.addErrorUsers(CannotParseReason.USER_ID_ERROR, rowData.getLineNumber());
                    break;
                }
            }
        }

    }
}
