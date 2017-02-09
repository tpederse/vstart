package vtester.loanrequest;

import vtester.db.DbApi;
import vtester.db.ServiceLocator;
import vtester.db.unchecked.UncheckedPreparedStatement;
import vtester.db.unchecked.UncheckedResultSet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoanRequestRepo {
    public static List getAll() {
        List returnValue = new ArrayList();
        UncheckedResultSet fromDb = DbApi.executeQuery("select * from offers");
        while(fromDb.next()){
            returnValue.add(fromDb.getString("Name"));
        }
        return returnValue;
    }

    public static void addLoanRequest(String title) {
        UncheckedPreparedStatement updateStatement = DbApi
                .getUpdateStatement("insert into offers (id, name) values (?,?)");
        updateStatement.setLong(1,DbApi.getId());
        updateStatement.setString(2,title);
        updateStatement.executeUpdate();

    }
}
