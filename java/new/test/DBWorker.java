package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBWorker {

    private final String HOST = "jdbc:mysql://127.0.0.1:3306/dbhospital";
    private final String USER = "root";
    private final String PASS = "root";

    private Connection connection;

    public DBWorker(){
        try {
            connection =DriverManager.getConnection(HOST,USER,PASS);
            if (!connection.isClosed()){
                System.out.println("Присоеденение к БД успешно!");
//                System.out.println("Не сохранять");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
