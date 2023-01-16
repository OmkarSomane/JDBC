
package students;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PH2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306";
		String uname = "root";
		String pass = "root";


		Scanner sc= new Scanner(System.in);
		System.out.println("enter roll");
		int r=sc.nextInt();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		String Qry = "select * from  students.stdsinfo where roll= ? ";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("step 1");

			con = DriverManager.getConnection(url,uname,pass);
			System.out.println("step 2");

			pstmt = con.prepareStatement(Qry);
			pstmt.setInt(1, r);
			
			System.out.println("step 3");
			
			res =pstmt.executeQuery();


			if(res.next()) {
				System.out.println("details are:-"+res.getInt(1)+" "+res.getString(2)+" "+res.getDouble(3));
			}
			else {
				
			System.out.println("not found");
			}
			System.out.println("step 4 & 5");


		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		finally {

			if(con!=null) 
			{
				try {
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(pstmt!=null) 
			{
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(res!=null) 
			{
				try {
					res.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}



			sc.close();	
			System.out.println("all closed");
		}
	}

}


