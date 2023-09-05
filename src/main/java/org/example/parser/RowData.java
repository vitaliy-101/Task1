package org.example.parser;

import java.util.HashMap;
import lombok.Getter;
import lombok.Setter;
import org.example.Jobs.User;

@Getter
@Setter
public class RowData {
    private long lineNumber;
    private User user;
    private String currentColumnValue;

    public RowData(long lineNumber) {
        this.lineNumber = lineNumber;

    }
}
