package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// getConnection : Connection 객체를 리턴함!
			// static  Connection  getConnection(String url, String user, String password)
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","tiger"); // 다른 컴퓨터에 접속할때는 root로는 로그인 안됨!
			System.out.println("연결 성공");
			con.close();
		} catch(Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		}

	}

}
