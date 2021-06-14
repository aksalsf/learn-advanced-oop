/*
 * File untuk membuat koneksi dengan database
 */

package database;
import java.sql.*;

public class Config {
	private static Connection MySQLConfig;
	public static Connection configDB()throws SQLException {
		try {
			/*
			 * Membuat koneksi dengan database
			 */
			String url = "jdbc:mysql://localhost:3306/pbo_uas"; // pbo_uas => nama database
			// username & password database
			String user = "root";
			String password = "";
			
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			MySQLConfig = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			/*
			 * Mengembalikan pesan eror jika terjadi kesalahan koneksi
			 */
			System.out.println("Koneksi Gagal " + e.getMessage());
		}
		return MySQLConfig;
	}
}
