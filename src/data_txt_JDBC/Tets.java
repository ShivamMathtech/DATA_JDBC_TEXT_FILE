package data_txt_JDBC;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Tets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement st = null;
		ResultSet rs= null;
		FileOutputStream fos = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Shivam");
			st = con.createStatement();
			rs = st.executeQuery("select*from EMP1");
			String data= "";
			data = data +"ENO\t,ENAME\t,ESAL\t,EADDR\t\n";
			while(rs.next()) {
				data = data +rs.getInt("ENO")+"\t";
				data = data +rs.getString("ENAME")+"\t";
				data = data +rs.getFloat("ESAL")+"\t";
				data = data +rs.getString("EADDR")+"\t";
				data= data+"\n";
			}
			fos = new FileOutputStream("G:/advJava/emp.txt");
		    byte [] b= data.getBytes();
		    fos.write(b);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				con.close();
				fos.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

	}

}
