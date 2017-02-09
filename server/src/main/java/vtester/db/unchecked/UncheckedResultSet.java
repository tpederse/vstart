package vtester.db.unchecked;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Wrapper rundt ResultSet for å:
 * - slippe checked exceptions,
 * - støtte Column
 */
public class UncheckedResultSet {
    private final ResultSet subject;


    public UncheckedResultSet(ResultSet subject) {
        this.subject = subject;
    }

    public boolean next() {
        try {
            return subject.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public long getLong(String columnName) {
        try {
            return subject.getLong(columnName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getInt(String columnName) {
        try {
            return subject.getInt(columnName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean getBoolean(String columnName) {
        try {
            return subject.getBoolean(columnName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getString(String columnName) {
        try {
            return subject.getString(columnName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Timestamp getTimestamp(String columnNameLabel) {
        try {
            return subject.getTimestamp(columnNameLabel);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] getBytes(String columnName) {
        try {
            return subject.getBytes(columnName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public long getLong(int i) {
        try {
            return subject.getLong(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getString(int i) {
        try {
            return subject.getString(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
