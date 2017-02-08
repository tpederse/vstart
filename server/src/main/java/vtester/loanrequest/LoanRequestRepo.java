package vtester.loanrequest;

import vtester.db.ServiceLocator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoanRequestRepo {
    public static List getAll() {
        List returnValue = new ArrayList();
        try {
            ResultSet fromDb = ServiceLocator.instance().getDbConnection().prepareStatement("select * from tilbud").executeQuery();
            while(fromDb.next()){
                returnValue.add(fromDb.getString("Name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return returnValue;
    }

    public static void addLoanRequest(String title) {

    }
}
