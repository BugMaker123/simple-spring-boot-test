package com.example.simplespringboottest.prac.practice.demos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库字段大小写转换
 * @ ClassName: Demo
 * @Author: legen
 * @Date: 2020/10/27
 */
public class DatabaseParamterConvert2Entity {
    private static final String userName="ggs";
    private static final String psw="eKZKgHqn42tad8mxLNPb";
    private static String driverClassName="com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://10.19.156.193:3306/dictionary?serverTimezone=UTC";
    public static void main(String[] args) throws SQLException {
        Class<?> aClass = null;
        Connection conn =null;
       List<String> paramterLists = new ArrayList<>();
       List<String> tableNameList = new ArrayList<>();
        try {
            aClass = Class.forName(driverClassName);
            conn = DriverManager.getConnection(url, userName, psw);
            Statement stat = conn.createStatement();
            Statement stmt = conn.createStatement();
            DatabaseMetaData metaData = conn.getMetaData();
            // 获取dictionary库下所有表的名字
            ResultSet set = metaData.getTables("dictionary", "%","",new String[]{"TABLE"});
            //3. 提取表的名字。
            while(set.next()){
                tableNameList.add(set.getString("TABLE_NAME"));
                System.out.println(set.getString("TABLE_NAME"));
            }
/*
            // 4.获取表中的字段
            String columnName;
            String columnType;
            ResultSet colRet = metaData.getColumns(null,"%", m_TableName,"%");
            while(colRet.next()) {
                columnName = colRet.getString("COLUMN_NAME");
                columnType = colRet.getString("TYPE_NAME");
                int datasize = colRet.getInt("COLUMN_SIZE");
                int digits = colRet.getInt("DECIMAL_DIGITS");
                int nullable = colRet.getInt("NULLABLE");
                System.out.println(columnName+" "+columnType+" "+datasize+" "+digits+" "+ nullable);
            }*/


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            conn.close();
        }
        for (int i = 0; i <paramterLists.size() ; i++) {
            System.out.println(paramterLists.get(i));
        }


        System.out.println("=========================================");
        String str =" start_org_code,end_org_code,start_org_name,start_org_longitude,start_org_latitude,end_org_name,end_org_longitude,end_org_latitude,speed_priority,cost_priority,distance_priority,multiple_priority,line_type,station_type,update_time,type,enter_type";
        String[] paramters = str.split(",");
        String words=null;
        List<String> list = new ArrayList<>();
        for (int i = 0; i <paramters.length ; i++) {
            char[] chars = paramters[i].toCharArray();
            for (int j = 0; j <chars.length ; j++) {
                if (chars[j]=='_'){
                    chars[j+1]= (char) (chars[j+1]-32);
                }
            }
            words= String.valueOf(chars);
            words = words.replace("_","");
            System.out.println(words);
            list.add(words);
        }
        for (int i = 0; i < list.size() ; i++) {
            System.out.println(list.get(i));
        }
        conn.close();
    }
}
