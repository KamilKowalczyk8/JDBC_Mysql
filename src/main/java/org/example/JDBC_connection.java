package org.example;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_connection {
    public static void main(String[] args) {
        Connection connection = null;
        try{
            connection =
                    DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                            "root","");
            if (connection == null){
                System.out.println("brak połaczernia z baza danych");
            } else {
                System.out.println("jest połaczenie");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
