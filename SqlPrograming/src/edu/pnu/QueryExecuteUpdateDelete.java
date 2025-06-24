package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryExecuteUpdateDelete {

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement psmt = null;
		Statement st = null;
		
		// executeUpdate(): 적용된 레코드의 수 int가 return
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfirstdb","root","tiger");
			
			String sql1 = "delete from phonebook where id=?";
			psmt = con.prepareStatement(sql1);
			psmt.setInt(1, 47);
			psmt.executeUpdate();
			
			st = con.createStatement();
			st.executeUpdate("delete from phonebook ");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {	if(st != null) st.close();} catch (SQLException e) {	e.printStackTrace();}
			try {	if(psmt != null) psmt.close();} catch (SQLException e) {	e.printStackTrace();}
			try {	if(con != null) con.close();} catch (SQLException e) {	e.printStackTrace();}
		}

	}

}
