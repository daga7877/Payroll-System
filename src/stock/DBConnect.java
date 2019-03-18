package stock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class DBConnect {
	
	static String url="jdbc:mysql://localhost:3306/stock_management";
	static String username="root";
	static String password="gadmDaga00";
	
	public static Connection DBCon(){  
		Connection con = null;
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		 con=DriverManager.getConnection(  
		url,username,password);  
		//here sonoo is database name, root is username and password  
		
		}catch(Exception e){ System.out.println(e);
		
		}  
		return  con;
	}  
	
	
	public static void main(String[] args) {
		try {
			Connection con = DBCon();
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from user_detail");  
		/*Statement stmt1=con.createStatement();  
		ResultSet rs1=stmt1.executeQuery("select * from elec_status"); */
		while(rs.next())  
		System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
		/*while(rs1.next())  
			System.out.println(rs1.getString(1)+"  "+rs1.getString(2)+"  "+rs1.getInt(3));  
			*/
		con.close();  
		}catch(Exception e){ System.out.println(e);}  
		
		
		
	}
	
	public boolean checkUserCredentials(String uname, String pass){
		try {
			if(null == uname || null == pass) {
				return false;
			}
			Connection con = DBCon();
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from user_detail");  
			while(rs.next())  {
				System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)); 
				if(uname.trim().equals(rs.getString(2).trim()) && pass.trim().equals(rs.getString(3).trim())) {
					return true;
				}
			}
			con.close();  
		}catch(Exception e){ 
			System.out.println(e);
		}  
		
		return false;
	}

}
