package org.example.parser.columnsparser.columnsparserimpl;

import lombok.NoArgsConstructor;
import org.example.UserGroup;
import org.example.parser.RowData;
import org.example.parser.columnsparser.BaseColumnParser;
import org.example.parser.ResultParser;
import org.example.parser.columnsparser.CannotParseReason;

@NoArgsConstructor
public class UserGroupIdColumnParser implements BaseColumnParser {
    @Override
    public void correction(ResultParser resultParser, RowData rowData) {
        String userGroupId = rowData.getCurrentColumnValue();
        if (userGroupId.isEmpty()){
            resultParser.addErrorUsers(CannotParseReason.USER_ID_GROUP_ERROR, rowData.getLineNumber());
        }
        else{
            rowData.getUser().setGroup(new UserGroup(Long.valueOf(userGroupId)));
        }
    }
}
