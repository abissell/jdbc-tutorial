package sandbox;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class TestJdbcSandbox {

	public TestJdbcSandbox() {

	}

	@Test
	public void testGetConnection() {
		JdbcSandbox sandbox = new JdbcSandbox();

		try {
			Connection connection = sandbox.getConnection();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void testCreateAndPopulateCoffeesTable() {
		JdbcSandbox sandbox = new JdbcSandbox();

		try {
			sandbox.createAndPopulateCoffeesTable();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void testCreateAndPopulateSuppliersTable() {
		JdbcSandbox sandbox = new JdbcSandbox();

		try {
			sandbox.createAndPopulateSuppliersTable();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
}
