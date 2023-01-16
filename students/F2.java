package students;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class F2 {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306";
		String uname = "root";
		String pass = "root";

		String FetchQry = "select* from students.stdsinfo where marks=70";

		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		try {
			//1
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2
			con = DriverManager.getConnection(url,uname,pass);
			//3
			pstmt =con.prepareStatement(FetchQry);
			//4
			//5
			res =pstmt.executeQuery(); 
			while(res.next()) {
				System.out.print(res.getInt(1)+" "+res.getString(2)+" "+res.getDouble(3));
			}


		}
		catch(Exception e){
			System.out.println("handeled");
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}