package students;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Steps_JDBC {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306";
		String uname = "root";
		String pass = "root";
	//	String updt_qry = "insert into students.stdsinfo values (40,'porga',50)";
		String delete_qry = "delete from students.stdsinfo where name = 'porga' ";
		Connection con = null ;
		try {
			//1
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			System.out.println("Driver class loaded");
			//2
			 con = DriverManager.getConnection(url,uname,pass);
			System.out.println("Connection connected");
			//3
			Statement stmt = con.createStatement();
			System.out.println("Platform created");

			//4
			//	stmt.execute( "create table students.stdsinfo( roll int, name varchar(25), marks double)");
			//	System.out.println("table created");
			//4
			//	stmt.executeUpdate(updt_qry);
			//	System.out.println("qry updated");
			//4
				stmt.executeUpdate(delete_qry);
				System.out.println("qry deleted");



		}

		catch(Exception e)
		{
			System.out.println("handled");
			e.printStackTrace();
		}
		finally {
			if (con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

