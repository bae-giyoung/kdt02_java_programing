package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class QueryStatement {
		
	public static void printRs(ResultSet rs) throws SQLException {
		ResultSetMetaData meta = rs.getMetaData();
		int count = meta.getColumnCount();
		
		//if() System.out.println("검색 결과가 없습니다.");
		
		while(rs.next()) { // rs.next() 커서 프로세싱
			for(int i=1; i<=count; i++) { // rs.getXXX()는 커서가 위치한! 레코드의 컬럼의 값을 가져옴!
				System.out.print(rs.getString(i) + ", "); // 인덱스로도 찾을 수 있음! 전부 출력하는게 아니면 사용하지 않는 것이 좋긴 함!
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		// 변수 선언
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		Scanner stdIn = new Scanner(System.in);
		
		try {
			// 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 로그인
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "tiger");
			st = con.createStatement();
			
			
			while (true) {
				System.out.println("================================= [질문 번호를 입력하세요] ================================");
				System.out.print(
						"(1): 인구수를입력받아서그보다많은인구를가진도시를검색해서출력하세요."
						+ "\n(2): 국가코드를입력받아서해당국가의도시의이름과인구를검색해서출력하세요."
						+ "\n(3): 대륙을입력받아서해당대륙에위치한국가를검색해서출력하세요."
						+ "\n(4): 넓이(10,0002 km)를 입력 받아서 입력 값보다 작은 면적을 가진 국가의이름과면적을면적오름차순으로검색해서출력하세요. (Country.SurfaceArea)"
						+ "\n(5): 대한민국의District를 입력 받아서 해당 지역에 있는 모든도시를검색해서출력하세요. (예:‘Kyonggi’, City)"
						+ "\n(6): 언어를입력받아서해당언어가국가공식언어인국가를출력하세요. (예:'Spanish’, CountryLanguage)"
						+ "\n(7):  CountryLanguage에서 사용자가 입력 비율 이상인 언어의 국가 코드와 비율을 검색해서 출력하세요."
						+ "\n===================================================================================\n");
				
				int q = stdIn.nextInt();
				if (q == 0) {
					stdIn.close();
					System.out.println("프로그램 종료");
					break;
				}
				
				switch (q) {
				case 1:
					System.out.println("인구수를 입력하세요.");
					int q1 = stdIn.nextInt();
					rs = st.executeQuery("select name, population from city where population >=" + q1);
					printRs(rs);
					rs.close();
					break;
		
				case 2:
					System.out.println("국가코드를 입력하세요.");
					String q2 = stdIn.next();
					rs = st.executeQuery("select city.name, city.population from city, country "
							+ "where city.countrycode = country.code and countrycode='"+q2+"'");
					printRs(rs);
					rs.close();
					break;
		
				case 3:
					System.out.println("대륙을 입력하세요.");
					String q3 = stdIn.next();
					rs = st.executeQuery("select name from country where continent='"+q3+"'");
					printRs(rs);
					rs.close();				
					break;
				case 4:
					System.out.println("넓이를 입력하세요.");
					String q4 = stdIn.next();
					rs = st.executeQuery("select name, surfacearea from country where SurfaceArea>="+q4+" order by SurfaceArea");
					printRs(rs);
					rs.close();
					break;
				case 5:
					System.out.println("대한민국의 District를 입력하세요.");
					String q5 = stdIn.next();
					rs = st.executeQuery("select name from city where countrycode='KOR' and District='"+q5+"'");
					printRs(rs);
					rs.close();
					break;
				case 6:
					System.out.println("언어를 입력하세요.");
					String q6 = stdIn.next();
					rs = st.executeQuery("select name from country, countrylanguage where country.code=countrylanguage.countrycode and language='"+q6+"' and isofficial='T'");
					printRs(rs);
					rs.close();
					break;
				case 7:
					System.out.println("비율을 입력하세요. 예시) 100.0");
					float q7 = stdIn.nextFloat();
					rs = st.executeQuery("select countrycode, percentage from countrylanguage where percentage>="+q7);
					printRs(rs);
					rs.close();
					break;
				}
			}
			
		} catch(Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(st != null) st.close();
				if(con != null) con.close();
			} catch(Exception e) {}
		}
	}

	}

//}
