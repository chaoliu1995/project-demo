package com.example.demo;

public class ColumnUtils {

    public static String getYearMonthColumn(String tableName){
        if(tableName.contains("income")){
            return "data_ym";
        }
        throw new RuntimeException("未找到对应的表");
    }

}
