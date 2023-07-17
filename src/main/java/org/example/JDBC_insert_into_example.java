package org.example;

import java.sql.*;

public class JDBC_insert_into_example {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            connection =
                    DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test",
                            "root","");
            if (connection == null){
                System.out.println("brak połaczernia z baza danych");
            } else {
                System.out.println("jest połaczenie");
            }

            statement = connection.createStatement();

            String sqlInsert = "Insert INTO employees (name,address,salary) VALUES "
                    +"('Rafal','bydugosz', 10000),"
                    +"('Rafal','krakow', 10000),"
                    +"('ala','bydugosz', 10000)";

            statement.executeUpdate(sqlInsert);

            String sqlSelect = "SELECT * FROM employees;";

            resultSet = statement.executeQuery(sqlSelect);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                int salary = resultSet.getInt("salary");
                System.out.println("id "+id+" name "+name+" salary "+salary);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                resultSet.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            try {
                statement.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            try {
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
