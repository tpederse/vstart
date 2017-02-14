package vtester.infra.db;

import org.flywaydb.core.Flyway;
import org.postgresql.ds.PGPoolingDataSource;

public class Postgres {
    private Postgres() {
    }

    public static PGPoolingDataSource createSource() {
        PGPoolingDataSource source = new PGPoolingDataSource();
        source.setDataSourceName("vtresterLocal");
        source.setServerName("localhost");
        source.setDatabaseName("vtresterLocal");
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
