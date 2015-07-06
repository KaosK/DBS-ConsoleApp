package app;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 
 * <h1>Projekt App DBS_SS2015</h1> The program implements a simple Database
 * Query API and the output to console/GUI.
 * <p>
 * 
 * @author Projektgruppe DBS2015: Sven Klaus, Alan Rachid, Sebastian Wicke based
 *         on Nicolas Lehmann's "HelloDatabaseWorldJava"
 */

public class Main {

	/**
	 * 
	 * The main method. Calls Queries and outputs Results.
	 * 
	 * @param args
	 *            Takes the database name as command line argument.
	 *
	 * @throws SQLException
	 *             SQLException on Query errors.
	 * @see SQLException
	 */
	public static void main(String[] args) throws SQLException {

		// PART 1 - build a connection to a database
		Path configFile = Paths.get("dbsApp.properties");
		ConnectionFactory connFactory = new ConnectionFactory(configFile);
		Connection conn = connFactory.getConnection();

		System.out.println();
		System.out.println("Output:");
		System.out.println();

		// PART 2 - query the database
		Query query = new Query(conn);
		SimpleTable sTable1 = query.showMovie100();
		SimpleTable sTable2 = query.allMoviesYear("2000", 50);
		SimpleTable sTable3 = query.topMovies(25);
		SimpleTable sTable4 = query.actorDebutYear("Johnny Depp");
		SimpleTable sTable5 = query.actorDebutYear("Christopher Walken");
		SimpleTable sTable6 = query.longestEntry("actor", "aname", "Longest name of an actor");
		SimpleTable sTable7 = query.longestEntry("movie", "mname", "Top 10 longest Filmtitels", 10);

		// PART 3 - Output
		sTable1.printToConsole();
		System.out.println();
		System.out.println();
		sTable2.printToConsole();
		System.out.println();
		System.out.println();
		sTable3.printToConsole();
		System.out.println();
		System.out.println();
		sTable4.printToConsole();
		System.out.println();
		System.out.println();
		sTable5.printToConsole();
		System.out.println();
		System.out.println();
		sTable6.printToConsole();
		System.out.println();
		System.out.println();
		sTable7.printToConsole();
		
		
		System.out.println();
		System.out.println("...done");

		// close connection
		if (conn != null) {
			conn.close();
		}
	}
}