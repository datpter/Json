package com.class1.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    public static Connection getMySqlConnection()throws Exception{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/api"
                    ,"root","");
            return connection;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }
}
