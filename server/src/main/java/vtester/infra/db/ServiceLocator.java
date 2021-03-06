package vtester.infra.db;

import java.util.HashMap;
import java.util.Map;


public class ServiceLocator {
    private static Map<Long, ServiceLocator> pool = new HashMap<>();
    private DbConnection dbConnection;


    public static ServiceLocator instance() {
        ServiceLocator returVerdi = pool.get(Thread.currentThread().getId());
        if (returVerdi == null) {
            throw new RuntimeException("Service Locator is not on thread and therefor not available!");
        }
        return returVerdi;
    }

    public static ServiceLocator startThreadContext() {
        if (pool.get(Thread.currentThread().getId()) != null) {
            throw new RuntimeException("Service Locator is on thread! Should not have more then one");
        }
        ServiceLocator serviceLocator = new ServiceLocator();
        pool.put(Thread.currentThread().getId(), serviceLocator);
        return serviceLocator;
    }

    public static void endThreadContext() {
        ServiceLocator thisLocator = instance();
        pool.remove(Thread.currentThread().getId());
        if(thisLocator.dbConnection!=null)throw new RuntimeException("Unhandled db connection!");
    }


    public DbConnection getDbConnection() {
        if (dbConnection == null) {
            dbConnection = DbConnection.ny();
        }
        return dbConnection;
    }

    public void rollBack() {
        if(dbConnection==null)return;
        dbConnection.rollBack();
        dbConnection=null;
    }

    public void commit() {
        if(dbConnection==null)return;
        dbConnection.close();
        dbConnection=null;
    }
}
