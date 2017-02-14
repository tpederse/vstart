package vtester.loanrequest;

import vtester.infra.db.DbApi;
import vtester.infra.db.unchecked.UncheckedPreparedStatement;
import vtester.infra.db.unchecked.UncheckedResultSet;

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

    public static void addLoanRequest(LoanRequestCommand createCommand) {
        UncheckedPreparedStatement updateStatement = DbApi
                .getUpdateStatement("insert into offers (id, name) values (?,?)");
        updateStatement.setLong(1,DbApi.getId());
        updateStatement.setString(2, createCommand.requestLoanName);
        updateStatement.executeUpdate();

    }
}
