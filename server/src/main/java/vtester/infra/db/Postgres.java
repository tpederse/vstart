package vtester.infra.db;

import org.flywaydb.core.Flyway;
import org.postgresql.ds.PGPoolingDataSource;
import vtester.infra.Setup;

public class Postgres {
    private Postgres() {
    }

    public static PGPoolingDataSource createSource() {
        PGPoolingDataSource source = new PGPoolingDataSource();
        source.setDataSourceName(Setup.getDataSourceName());
        source.setServerName("localhost");
        source.setDatabaseName(Setup.getDataSourceName());
        source.setUser("vtrester");
        source.setPassword("vtrester");
        source.setMaxConnections(10);
        updateSchema(source);
        return source;
    }

    private static void updateSchema(PGPoolingDataSource source) {
        Flyway flyway = new Flyway();
        flyway.setDataSource(source);
        flyway.migrate();
    }

}
