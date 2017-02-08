package vtester.db;

import org.postgresql.ds.PGPoolingDataSource;

public class Postgres {
    private Postgres() {
    }

    public static PGPoolingDataSource createSource() {
        PGPoolingDataSource source = new PGPoolingDataSource();
        source.setDataSourceName("Postgres Data source");
        source.setServerName("Servername");
        source.setDatabaseName("");
        source.setUser("Hepp");
        source.setPassword("Hei");
        source.setMaxConnections(10);
        return source;
    }

}
