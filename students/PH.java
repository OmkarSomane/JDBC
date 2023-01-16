//insert or delete record in db using place holder
package students;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PH {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306";
		String uname = "root";
		String pass = "root";
		String I_Qry = "insert into students.stdsinfo values(?,?,?)";
		//String DQry = "delete from students.stdsinfo where roll =? ";
		//Scanner		
		Scanner sc = new Scanner(System.in);
		//1
		System.out.println("enter roll");
		int r =sc.nextInt();
		//2
		System.out.println("entr name");
		String nm =sc.next();
		//3
		System.out.println("entr marks");
		double mks =sc.nextDouble();


		Connection con =null;
		PreparedStatement pstmt = null;


		try {
			//1
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1");
			//2
			con = DriverManager.getConnection(url,uname,pass);
			System.out.println("2");
			//3
			pstmt =con.prepareStatement(I_Qry);
			System.out.println("3");
			//4
			pstmt.setInt(1,r);
			pstmt.setString(2, nm);
			pstmt.setDouble(3, mks);
			pstmt.executeUpdate();
			System.out.println("4");

		}
		catch(Exception e){
			System.out.println("handeled");
			e.printStackTrace();
		}
		finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(pstmt!=null) {

					try {
						pstmt.close();
						System.out.println("6-all closed");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				sc.close();
			}
		}

	}
}

