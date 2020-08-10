import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleDriver;

public class ContactDao {
	
	public void insertContact(Contact contact) {
		
		//DB 연동에 사용되는 객체 (변수 선언)
		Connection conn = null; // 연결 관리
		PreparedStatement pstmt = null; // 명령 처리		
				
		// DB 연동에서 발생하는 예외는 반드시 예외처리 필요 (checked exception)
		try { // 예외 발생이 의심되는 영역 (여기서 발생한 예외만 catch 가능)
			
			//1. JDBC 드라이버 준비
			DriverManager.registerDriver(new OracleDriver());
			
			//2. 연결 (연결 객체 만들기)
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:xe", // 서버 연결 정보
					"hoseo", "hoseo"); // 계정 정보 (id, password)
			
			//3. SQL 작성 + 명령 객체 만들기
			String sql = "INSERT INTO CONTACT " + 
						 "(C_NO, C_NAME, C_PHONE, C_EMAIL) " +
						 "VALUES (CONTACTNO_SEQ.NEXTVAL, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, contact.getName()); //SQL의 1번째 ?에 사용할 데이터 지정
			pstmt.setString(2, contact.getPhone()); //SQL의 2번째 ?에 사용할 데이터 지정
			pstmt.setString(3, contact.getEmail()); //SQL의 3번째 ?에 사용할 데이터 지정
			
			//4. 명령 실행 ( insert, update, delete인 경우 )
			pstmt.executeUpdate();
			
			//5. 결과 처리 (결과가 있을 경우, select인 경우) 
			//   do nothing
			
		} catch (Exception ex) { // 예외가 발생하면 실행되는 영역
			ex.printStackTrace(); // 오류 메시지를 화면에 출력
		} finally { // 예외 발생 여부와 상관없이 항상 실행되는 영역
			//6. 연결 닫기 (종료)			
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
	}

	public List<Contact> selectContacts() {
		
		//DB 연동에 사용되는 객체 (변수 선언)
		Connection conn = null; // 연결 관리
		PreparedStatement pstmt = null; // 명령 처리
		ResultSet rs = null; // 결과 집합 접근
		
		ArrayList<Contact> contacts = new ArrayList<>(); // 조회 결과 목록을 저장할 변수
		
		// DB 연동에서 발생하는 예외는 반드시 예외처리 필요 (checked exception)
		try { // 예외 발생이 의심되는 영역 (여기서 발생한 예외만 catch 가능)
			
			//1. JDBC 드라이버 준비
			DriverManager.registerDriver(new OracleDriver());
			
			//2. 연결 (연결 객체 만들기)
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:xe", // 서버 연결 정보
					"hoseo", "hoseo"); // 계정 정보 (id, password)
			
			//3. SQL 작성 + 명령 객체 만들기
			String sql = "SELECT C_NO, C_NAME, C_PHONE, C_EMAIL, C_REGDATE " +
						 "FROM CONTACT ";
			pstmt = conn.prepareStatement(sql); 
			
			//4. 명령 실행 + 결과 집합 저장 ( select인 경우 )
			rs = pstmt.executeQuery();
			
			//5. 결과 처리 (결과가 있을 경우, select인 경우) 
			while (rs.next()) { // next() : 결과 집합의 다음 행으로 이동 (데이터가 없으면 false 반환)
				Contact contact = new Contact(); // 한 행(Row)은 Contact 객체 1개와 일치
				contact.setNo(rs.getInt(1));
				contact.setName(rs.getString(2));
				contact.setPhone(rs.getString(3));
				contact.setEmail(rs.getString(4));
				contact.setRegDate(rs.getDate(5));
				
				contacts.add(contact); // 연락처 한 개를 목록에 추가				
			}
			
		} catch (Exception ex) { // 예외가 발생하면 실행되는 영역
			ex.printStackTrace(); // 오류 메시지를 화면에 출력
		} finally { // 예외 발생 여부와 상관없이 항상 실행되는 영역
			//6. 연결 닫기 (종료)
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return contacts; // 조회 결과를 호출한 곳으로 반환
		
	}

	public List<Contact> selectContactsByName(String name) {
		
		//DB 연동에 사용되는 객체 (변수 선언)
		Connection conn = null; // 연결 관리
		PreparedStatement pstmt = null; // 명령 처리
		ResultSet rs = null; // 결과 집합 접근
		
		ArrayList<Contact> contacts = new ArrayList<>(); // 조회 결과 목록을 저장할 변수
		
		// DB 연동에서 발생하는 예외는 반드시 예외처리 필요 (checked exception)
		try { // 예외 발생이 의심되는 영역 (여기서 발생한 예외만 catch 가능)
			
			//1. JDBC 드라이버 준비
			DriverManager.registerDriver(new OracleDriver());
			
			//2. 연결 (연결 객체 만들기)
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:xe", // 서버 연결 정보
					"hoseo", "hoseo"); // 계정 정보 (id, password)
			
			//3. SQL 작성 + 명령 객체 만들기
			String sql = "SELECT C_NO, C_NAME, C_PHONE, C_EMAIL, C_REGDATE " +
						 "FROM CONTACT " +
						 "WHERE C_NAME LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%");
			
			//4. 명령 실행 + 결과 집합 저장 ( select인 경우 )
			rs = pstmt.executeQuery();
			
			//5. 결과 처리 (결과가 있을 경우, select인 경우) 
			while (rs.next()) { // next() : 결과 집합의 다음 행으로 이동 (데이터가 없으면 false 반환)
				Contact contact = new Contact(); // 한 행(Row)은 Contact 객체 1개와 일치
				contact.setNo(rs.getInt(1));
				contact.setName(rs.getString(2));
				contact.setPhone(rs.getString(3));
				contact.setEmail(rs.getString(4));
				contact.setRegDate(rs.getDate(5));
				
				contacts.add(contact); // 연락처 한 개를 목록에 추가				
			}
			
		} catch (Exception ex) { // 예외가 발생하면 실행되는 영역
			ex.printStackTrace(); // 오류 메시지를 화면에 출력
		} finally { // 예외 발생 여부와 상관없이 항상 실행되는 영역
			//6. 연결 닫기 (종료)
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return contacts; // 조회 결과를 호출한 곳으로 반환
		
	}

	public void deleteContact(int no) {
		
		//DB 연동에 사용되는 객체 (변수 선언)
		Connection conn = null; // 연결 관리
		PreparedStatement pstmt = null; // 명령 처리		
				
		// DB 연동에서 발생하는 예외는 반드시 예외처리 필요 (checked exception)
		try { // 예외 발생이 의심되는 영역 (여기서 발생한 예외만 catch 가능)
			
			//1. JDBC 드라이버 준비
			DriverManager.registerDriver(new OracleDriver());
			
			//2. 연결 (연결 객체 만들기)
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:xe", // 서버 연결 정보
					"hoseo", "hoseo"); // 계정 정보 (id, password)
			
			//3. SQL 작성 + 명령 객체 만들기
			String sql = "DELETE FROM CONTACT " + 
						 "WHERE C_NO = ?";
			pstmt = conn.prepareStatement(sql); 
			pstmt.setInt(1, no); //SQL의 1번째 ?에 사용할 데이터 지정
			
			//4. 명령 실행 ( insert, update, delete인 경우 )
			pstmt.executeUpdate();
			
			//5. 결과 처리 (결과가 있을 경우, select인 경우) 
			//   do nothing
			
		} catch (Exception ex) { // 예외가 발생하면 실행되는 영역
			ex.printStackTrace(); // 오류 메시지를 화면에 출력
		} finally { // 예외 발생 여부와 상관없이 항상 실행되는 영역
			//6. 연결 닫기 (종료)			
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
	}

}






