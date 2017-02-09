package vtester.db;

import vtester.db.unchecked.UncheckedPreparedStatement;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection implements AutoCloseable {
    private static DataSource dataSource= Postgres.createSource();
    private final Connection connection;

    public static DbConnection ny() {
        try {
            Connection conn = dataSource.getConnection();
            conn.setAutoCommit(false);
            return new DbConnection(conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public DbConnection(Connection connection) {
        this.connection = connection;
    }


    public void close() {
        try {
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public UncheckedPreparedStatement prepareStatement(String sql) {
        try {
            return new UncheckedPreparedStatement(connection.prepareStatement(sql));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Statement createStatement() {
        try {
            return connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void rollBack() {
        try {
            System.out.println("Blir bedt om å rulle tilbake");
            connection.rollback();
        } catch (SQLException e) {
            System.out.println("Greide ikke å rulle tilbake transaksjon!");
        }
    }
}
