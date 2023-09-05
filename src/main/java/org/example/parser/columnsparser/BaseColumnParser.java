package org.example.parser.columnsparser;

import org.example.parser.ResultParser;
import org.example.parser.RowData;

@FunctionalInterface
public interface BaseColumnParser{
    public void correction(ResultParser resultParser, RowData rowData);

}
