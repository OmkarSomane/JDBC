package students;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class F1FetchClose {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306";
		String uname = "root";
		String pass = "root";
		String Fetch_qry = "select * from students.stdsinfo where roll=50";

		Connection con = null ;
		Statement stmt = null;
		ResultSet res = null;

		try {
			//1
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			//2
			con = DriverManager.getConnection(url,uname,pass);
			//3
			stmt = con.createStatement();
			//4&&//5
			res = stmt.executeQuery(Fetch_qry);

			while(res.next()) {
				System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getDouble(3));


			}
			System.out.println("data fetched");
		}
		catch(Exception e)
		{
			System.out.println("handled");
			e.printStackTrace();
		}
		//6
		finally {
			if(con!=null) {
				try {
					con.close();
					System.out.println("con close");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stmt!=null) {
				try {
					stmt.close();
					System.out.println("stmt close");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(res!=null) {
				try {
					res.close();
					System.out.println("res close");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}


	}
}