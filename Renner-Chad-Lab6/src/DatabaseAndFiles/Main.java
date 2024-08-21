package DatabaseAndFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {
		String jdbcURL = "jdbc:derby:MovieDistribution;create=true";
		try {
			Connection connection = DriverManager.getConnection(jdbcURL);
			System.out.println("MovieDistribution database created/exists.");
			Statement statement = connection.createStatement();
			createTable(statement);
			updateTable(processFile(), statement);
			DisplayData(statement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static List<String> processFile() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter name of file used to update database: ");
		String filename = input.nextLine();
		File file = new File(filename);
		try {
			Scanner reader = new Scanner(file);
			List<String> values = new ArrayList<String>();  
			while (reader.hasNextLine()) {
				values.add(reader.nextLine());
			}
			return values;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void updateTable(List<String> values, Statement statement) {
		for (String row : values) {
			try {
				int counter = 0;
				String[] column = row.split(",");
				String sql = "SELECT * FROM MovieMetrics WHERE name = " 
							+ column[0];
				ResultSet queryResults = statement.executeQuery(sql);
				if (queryResults.next()) {
					sql = "UPDATE MovieMetrics SET showings = showings + " + column[++counter] +
							", screens = screens + " + column[++counter] +
							", ticketsSold = ticketsSold + " + column[++counter] +
							", receiptCount = receiptCount + " + column[++counter] +
							"WHERE name = " + column[0];
					statement.execute(sql);
					System.out.println("Updated movie in database: " + column[0]);
				} else {
					sql = "INSERT INTO MovieMetrics VALUES (" + row + ")";
					statement.execute(sql);
					System.out.println("Added movie to database: " + column[0]);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void createTable(Statement statement) {
		String sql = "CREATE TABLE MovieMetrics" +
				"(name VARCHAR(255) NOT NULL," +
				"showings INTEGER," +
				"screens INTEGER," +
				"ticketsSold INTEGER," +
				"receiptCount INTEGER," +
				"PRIMARY KEY (name))";
		try {
			statement.execute(sql);
			System.out.println("MovieMetrics table created.");
		} catch (SQLException e) {
			if (e.getSQLState().equals("X0Y32")) {
				System.out.println("MovieMetrics Table already exists.");
			} else {
				e.printStackTrace();
			}
		}
	}
	public static void DisplayData(Statement statement) {
		String sql = "SELECT * FROM MovieMetrics";
		System.out.println("Data for all movies:");
		try {
			ResultSet queryResults = statement.executeQuery(sql);
			while (queryResults.next()) {
				System.out.println("name:(" + queryResults.getString("name") + 
									") showings:(" + queryResults.getInt("showings") +
									") screens:(" + queryResults.getInt("screens") +
									") tickets sold:(" + queryResults.getInt("ticketsSold") +
									") receipt Count:("+ queryResults.getInt("receiptCount") + ")");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
