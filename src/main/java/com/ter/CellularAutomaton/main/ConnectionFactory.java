package com.ter.CellularAutomaton.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
 
import javax.sql.DataSource;
 
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnection;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;
 
public class ConnectionFactory {
	
    private static interface Singleton {
        final ConnectionFactory INSTANCE = new ConnectionFactory();
    }
    
    private static final String databaseNameOfLogs = "cellularautomat"; // MUST BE CHANGE FOR THE CURRENT PROJECT.
    private final DataSource dataSource;
 
    private ConnectionFactory() {
        Properties properties = new Properties();
        properties.setProperty("user", "CellularAutomat"); // MUST BE CHANGE FOR THE CURRENT PROJECT.
        properties.setProperty("password", "CeYzZsXtr5TxVtFV"); // Or get properties from some configuration file. // MUST BE CHANGE FOR THE CURRENT PROJECT.
 
        GenericObjectPool<PoolableConnection> pool = new GenericObjectPool<PoolableConnection>();
        DriverManagerConnectionFactory connectionFactory = new DriverManagerConnectionFactory(
                "jdbc:mysql://localhost/"+databaseNameOfLogs, properties
        );
        new PoolableConnectionFactory(
                connectionFactory, pool, null, "SELECT 1", 3, false, false, Connection.TRANSACTION_READ_COMMITTED
        );
 
        this.dataSource = new PoolingDataSource(pool);
    }
 
    public static Connection getDatabaseConnection() throws SQLException {
        return Singleton.INSTANCE.dataSource.getConnection();
    }
}
