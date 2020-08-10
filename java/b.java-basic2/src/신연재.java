import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class 신연재 {
private static final String C_NO = null;

public void insertContact(Contact contact) {
		
		//DB 연동에 사용되는 객체 (변수 선언)
		Connectionion conn = null; // 연결 관리
		PreparedStatement pstmt = null; // 명령 처리		
				
		// DB 연동에서 발생하는 예외는 반드시 예외처리 필요 (checked exception)
		try { // 예외 발생이 의심되는 영역 (여기서 발생한 예외만 catch 가능)
			
			//1. JDBC 드라이버 준비
			DriverManager.registerDriver(new OracleDriver());
			
			//2. 연결 (연결 객체 만들기)
			conn = (Connectionion) DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:xe", // 서버 연결 정보
					"hoseo", "hoseo"); // 계정 정보 (id, password)
			
			//3. SQL 작성 + 명령 객체 만들기
			String sql = "INSERT INTO CONTACT " + 
						 "(C_NO, C_TITLE, C_AUTHOR,C_CONTENTS, C_ENROLL, C_VIEWS) " +
						 "VALUES (2, '두 번째 게시글','iamsuserone, 'JDBC를 사용해서 작성한 글입니다.')";
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
}