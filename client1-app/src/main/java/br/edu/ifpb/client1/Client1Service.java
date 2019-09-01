package br.edu.ifpb.client1;

import java.sql.*;
import java.time.LocalDate;

public class Client1Service {

    private static final String URL = "jdbc:postgresql://localhost/sd";
    private static final String USER = "postgres";
    private static final String PASS = "secret";
    private Connection connection;

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        return connection = DriverManager.getConnection(
                URL,
                USER,
                PASS
        );
    }

    public String save(String message) throws SQLException, ClassNotFoundException {

        this.connection = getConnection();

        PreparedStatement stm = this.connection.prepareStatement("INSERT INTO messages (message, date_time) VALUES (?,?)");

        stm.setString(1, message);
        stm.setDate(2, Date.valueOf(LocalDate.now()));
        stm.executeUpdate();

        stm.close();
        this.connection.close();

        return message;
    }

    public void delete(String message) throws SQLException, ClassNotFoundException {

        this.connection = getConnection();
        PreparedStatement stm = this.connection.prepareStatement("DELETE FROM message WHERE message = ?");

        stm.setString(1, message);
        stm.execute();

        stm.close();
        this.connection.close();
    }

}
