package test;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;


public class TestMySqlJDBC {
    public static void main(String[] args) {
        var url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                Connection connection = DriverManager.getConnection(url, "root", "715952gdmY");
                Statement instruction = connection.createStatement();
                var sql = "SELECT id_person, name, lastName, cellphone, email FROM person";
                ResultSet result = instruction.executeQuery(sql);
                while(result.next()){
                    System.out.print("|Id_person:" + result.getInt("id_person"));
                    System.out.print("|Name:" + result.getString("name"));
                    System.out.print("|Lastname:" + result.getString("lastName"));
                    System.out.print("|Cellphone:" + result.getString("cellphone"));
                    System.out.print("|Email:" + result.getString("email"));
                    System.out.println();
                }
                result.close();
                instruction.close();
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}