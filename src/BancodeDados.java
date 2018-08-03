import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BancodeDados {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:~/test";

	// Database credentials
	static final String USER = "sa";
	static final String PASS = "";

	private static void criarBanco() {
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 1: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 2: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 3: Execute a query
			System.out.println("Creating table in given database...");
			stmt = conn.createStatement();
			String sql = "CREATE TABLE   Teste " + "(id INTEGER not NULL, "
					+ " nome VARCHAR(255), " + " sobrenome VARCHAR(255), "
					+ " age INTEGER, " + " PRIMARY KEY ( id ))";
			stmt.executeUpdate(sql);
			System.out.println("Created table in given database...");

			// STEP 4: Clean-up environment
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
	}

	private static void selectDados() {
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 1: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 2: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");

			// STEP 3: Execute a query
			stmt = conn.createStatement();
			String sql = "SELECT * FROM Teste";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getString("nome"));
			}
			
			// STEP 4: Clean-up environment
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
	}
	private static void insertDados() {
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 1: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 2: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");

			// STEP 3: Execute a query
			stmt = conn.createStatement();
			String sql = "INSERT INTO Teste "
					+ "VALUES (100, 'Bruno', 'Ribeiro', 21)";

			stmt.executeUpdate(sql);
			sql = "INSERT INTO Teste "
					+ "VALUES (101, 'Julio', 'Ribeiro', 21)";

			stmt.executeUpdate(sql);
			System.out.println("Inserted records into the table...");

			// STEP 4: Clean-up environment
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
	}
	public static void main(String[] args) {
//		criarBanco();
//		insertDados();
		selectDados();
	}

}
