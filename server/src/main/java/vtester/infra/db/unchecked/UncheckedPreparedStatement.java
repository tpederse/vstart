package vtester.infra.db.unchecked;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class UncheckedPreparedStatement {

    private final PreparedStatement subject;

    public UncheckedPreparedStatement(PreparedStatement toBeWraped){
        subject= toBeWraped;
    }

    public void setObject(int parameterIndex, Object x) {
        try {
            subject.setObject(parameterIndex, x);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int executeUpdate() {
        try {
            return subject.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setLong(int parameterIndex, long x) {
        try {
            subject.setLong(parameterIndex, x);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setString(int parameterIndex, String x) {
        try {
            subject.setString(parameterIndex, x);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setBoolean(int parameterIndex, boolean x) {
        try {
            subject.setBoolean(parameterIndex, x);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setTimestamp(int parameterIndex, Timestamp x) {
        try {
            subject.setTimestamp(parameterIndex, x);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setBytes(int parameterIndex, byte x[]) {
        try {
            subject.setBytes(parameterIndex, x);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public UncheckedResultSet executeQuery() {
        try {
            return new UncheckedResultSet(subject.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
