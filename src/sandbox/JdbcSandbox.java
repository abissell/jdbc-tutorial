package sandbox;

import com.oracle.tutorial.jdbc.CoffeesTable;
import com.oracle.tutorial.jdbc.SuppliersTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

final class JdbcSandbox {
 	private final String dbms = "mysql";
	private final String serverName = "localhost";
	private final String portNumber = "3306";
	private final String dbName = "testdb";

	JdbcSandbox() {

	}

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", "root");
		connectionProps.put("password", "root");

		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		conn =
				DriverManager.getConnection("jdbc:" + dbms + "://" + serverName +
						":" + portNumber + "/" + dbName,
						connectionProps);
		System.out.println("Connected to database");
		conn.setCatalog(dbName);
		return conn;
	}

	public void createAndPopulateCoffeesTable() throws SQLException {
		final Connection connection = getConnection();
		final CoffeesTable coffeesTable = new CoffeesTable(connection, dbName, dbms);

		coffeesTable.dropTable();
		coffeesTable.createTable();
		coffeesTable.populateTable();
	}

	public void createAndPopulateSuppliersTable() throws SQLException {
		final Connection connection = getConnection();
		final SuppliersTable suppliersTable = new SuppliersTable(connection, dbName, dbms);

		suppliersTable.dropTable();
		suppliersTable.createTable();
		suppliersTable.populateTable();
	}
}
