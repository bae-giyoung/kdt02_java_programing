package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PhoneBookDao {
	private static Scanner sc = new Scanner(System.in);
	private static String url = "jdbc:mysql://localhost:3306/myfirstdb";
	
	public static void main(String[] args) throws Exception {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "tiger");
			boolean flag = true;
			
			while(flag) {
				System.out.print("[I]nsert/[U]pdate/[D]elete/[S]elect/[N]ative/[Q]uit:");
				char c = sc.next().toUpperCase().charAt(0);
				
				switch(c) {
				case 'I': insertPhonebook(con, sc); break;
				case 'U': updatePhonebook(con, sc); break;
				case 'D': deletePhonebook(con, sc); break;
				case 'S': selectAllPhonebook(con); break;
				case 'N': nativeQuery(con); break;
				case 'Q': flag = false; break;
				}
			}
			
			System.out.println("Bye~");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(con != null) con.close();
			sc.close();
		}

	}

	private static void nativeQuery(Connection con) throws Exception {
		System.out.println("query문을 입력하세요:");
		Statement st = con.createStatement();
		sc.nextLine(); // next(), nextLine() 같이 사용할때 주의할것! 각 메서드가 버퍼에서 어떻게 동작하는지 알아보기!
		String sql = sc.nextLine();
		int cnt = 0;
		
		if(sql.startsWith("select")) {
			ResultSet rs = st.executeQuery(sql);
			showRs(rs);
			rs.close();
		} else {
			cnt = st.executeUpdate(sql);
			if (cnt != 0) {
				if(sql.startsWith("insert")) {
					System.out.println(cnt+"건 insert 완료");
				}
				else if(sql.startsWith("update")) {
					System.out.println(cnt+"건 update 완료");
				}
				else if(sql.startsWith("delete")) {
					System.out.println(cnt+"건 delete 완료");
				}
			} else {
				System.out.println("== db 업데이트 실패: 조건에 맞는 레코드가 없습니다. query를 확인하세요.");
			}
		}
		
		st.close();
	}
	
	private static void showRs(ResultSet rs) throws SQLException {
		ResultSetMetaData meta = rs.getMetaData();
		int cnt = meta.getColumnCount();
		
		while(rs.next()) {
			for(int i=1; i<=cnt; i++) {
				System.out.print(rs.getString(i)+" ");
			}
			System.out.println();
		}
	}

	private static void selectAllPhonebook(Connection con) throws Exception {
		System.out.println("== 모든 phonebook 조회 ==");
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from phonebook");
		showRs(rs);
		rs.close();
		st.close();
	}

	private static void deletePhonebook(Connection con, Scanner sc) throws Exception {
		System.out.println("delete 실행 중...");
		
		System.out.print("delet할 id를 입력하세요: ");
		String id = sc.next();
		
		Statement st = con.createStatement();
		int cnt = st.executeUpdate("delete from phonebook where id=" + id);
		
		if(cnt == 0)
			System.out.println("== delete 실패: 조건에 맞는 레코드가 없습니다. query를 확인하세요.");
		else
			System.out.println("\ndelete 완료: "+cnt+"건 삭제");
		st.close();
	}

	private static void updatePhonebook(Connection con, Scanner sc) throws Exception {
		System.out.println("update 실행 중...");
		
		System.out.print("id를 입력하세요:");
		int id = sc.nextInt();
		
		System.out.print("home을 입력하세요. 예시) 02-000-0000:");
		String home = sc.next();
		
		int len = home.split("-").length;
		while(len != 3) {
			System.out.print("\nhome을 다시 입력하세요. 예시) 02-000-0000:");
			home = sc.next();
			len = home.split("-").length;
		}
		
		Statement st = con.createStatement();
		int cnt = st.executeUpdate("update phonebook set " + String.format("home='%s' where id=%d", home, id));
		
		if(cnt == 0)
			System.out.println("== update 실패: 조건에 맞는 레코드가 없습니다. query를 확인하세요.");
		else
			System.out.println("\nupdate 완료: "+cnt+"건 업데이트");
		st.close();
	}

	private static void insertPhonebook(Connection con, Scanner sc) throws Exception {
		System.out.println("insert 실행 중...");
		
		System.out.print("name을 입력하세요:");
		String name = sc.next();
		
		System.out.print("mobile을 입력하세요. 예시) 010-1234-5678:");
		String mobile = sc.next();
		
		int len = mobile.split("-").length;
		while(len != 3) {
			System.out.print("\nmobile을 다시 입력하세요. 예시) 010-1234-5678:");
			mobile = sc.next();
			len = mobile.split("-").length;
		}
		
		Statement st = con.createStatement();
		int cnt = st.executeUpdate("insert into phonebook(name, mobile) values " + String.format("('%s','%s')", name, mobile));
		
		if(cnt == 0)
			System.out.println("== insert 실패: 조건에 맞는 레코드가 없습니다. query를 확인하세요.");
		else
			System.out.println("\n\ninsert 완료: "+cnt+"건 업데이트");
		st.close();
	}

}
