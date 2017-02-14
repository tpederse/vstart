package vtester.infra.db;

import vtester.infra.db.unchecked.UncheckedPreparedStatement;
import vtester.infra.db.unchecked.UncheckedResultSet;

/**
 * Created by trond on 09.02.17.
 */
public class DbApi {
    public static UncheckedResultSet executeQuery(String sqlQuery) {
        return ServiceLocator.instance().getDbConnection()
                .prepareStatement(sqlQuery).executeQuery();
    }

    public static UncheckedPreparedStatement getUpdateStatement(String sql) {
        return ServiceLocator.instance().getDbConnection().prepareStatement(sql);
    }

    public static Long getId() {
        return 500L;
    }
}
