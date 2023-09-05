package org.example.parser;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.example.Jobs.User;
import org.example.UserGroup;
import org.example.parser.columnsparser.CannotParseReason;

@Getter
@Setter
public class ResultParser {
    private Map<CannotParseReason, List<Long>> errorUsers = new HashMap<>();
    private List<User> usersList = new ArrayList<>();
    private HashMap<Long, UserGroup> groups = new HashMap<>();

    public void addErrorUsers(CannotParseReason columnNameError, Long lineNumber){
        if (!this.errorUsers.containsKey(columnNameError)) {
            List<Long> newError = new ArrayList<>();
            newError.add(lineNumber);
            this.errorUsers.put(columnNameError, newError);
        }
        else{
            List<Long> updateError = this.errorUsers.get(columnNameError);
            updateError.add(lineNumber);
            this.errorUsers.put(columnNameError, updateError);
        }

    }
    public void createResult(RowData rowData){
        if (!findLineError(this.errorUsers, rowData)){
            addServiceableGroupAndUser(rowData);
        }
    }

    public boolean findProfessionError(long lineNumber){
        for (CannotParseReason keyError : this.errorUsers.keySet()) {
            List<Long> errorLines = this.errorUsers.get(keyError);
            for (int i = 0; i < errorLines.size(); i ++){
                if (errorLines.get(i).equals(lineNumber)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean findLineError(Map<CannotParseReason, List<Long>> errorUsers, RowData rowData){
        Long lineNumber = rowData.getLineNumber();
        Boolean permission = true;
        for (CannotParseReason keyError : this.errorUsers.keySet()) {
            List<Long> errorLines = this.errorUsers.get(keyError);
            for (int i = 0; i < errorLines.size(); i ++){
                if (errorLines.get(i).equals(lineNumber)){
                    return true;
                }
            }
        }
        return false;
    }
    private void addServiceableGroupAndUser(RowData rowData){
        Long userGroupId = rowData.getUser().getGroup().getId();
        if (!this.groups.containsKey(userGroupId)) {
            rowData.getUser().getGroup().addUser(rowData.getUser());
            this.groups.put(rowData.getUser().getGroup().getId(), rowData.getUser().getGroup());
        }
        else{
            UserGroup group = this.groups.get(userGroupId);
            group.addUser(rowData.getUser());
            this.groups.put(userGroupId, group);
        }
        rowData.getUser().calculateSalary();
        this.usersList.add(rowData.getUser());
    }

}
