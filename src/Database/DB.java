package Database;

import Database.Interfaces.IDB;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DB implements IDB {

    private static DB instance;
    private Connection conn;

    public Statement statement;

    private DB() {
        String connectionUrl = "jdbc:postgresql://localhost:5432/collection";

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(connectionUrl, "postgres", "postgres");
            System.out.println("Connected successfully");
//            Statement stmt = conn.createStatement();
//            stmt.execute("CREATE TABLE table");
//            stmt.executeUpdate("insert into table values ()");
        } catch (SQLException e) {
            System.out.println("Error in connecting to server");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public Connection getConnection() {
        return conn;
    }

    public void GetStatement() {
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized static DB getInstance() {
        if (instance == null) {
            instance = new DB();
        }
        return instance;
    }

    public void InsertIntoBooksTable(String name, int price, ArrayList<String> features) {
        String sql = "insert into collection (name, price) values ('" + name + "', " + price + ", '{";

        for (String f : features) {
            if (f == features.get(features.size())) {
                sql += "'" + f + "'}'";
                break;
            }
            sql += "'" + f + "', ";
        }
        sql += ");";

        try {
            int rows = statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}