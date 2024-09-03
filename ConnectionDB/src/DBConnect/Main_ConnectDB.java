package DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Main_ConnectDB {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			String url = "";
			String user = "";
			String password = "";
			
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Conexão estabelecida com sucesso!");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM usuarios");
			
			while(rs.next()) {
				System.out.println("ID: " + rs.getInt("id"));
				System.out.println("Nome: " + rs.getString("nome"));
				System.out.println("E-mail: " + rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
