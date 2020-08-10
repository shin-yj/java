import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import oracle.jdbc.OracleDriver;

public class Ex02 {

	public static void main(String[] args) {
		
		//DB 연동에 사용되는 객체 (변수 선언)
		Connection conn = null; // 연결 관리
		PreparedStatement pstmt = null; // 명령 처리
		ResultSet rs = null; // 결과 집합 접근
		
		// DB 연동에서 발생하는 예외는 반드시 예외처리 필요 (checked exception)
		try { // 예외 발생이 의심되는 영역 (여기서 발생한 예외만 catch 가능)
			
			//1. JDBC 드라이버 준비
			DriverManager.registerDriver(new OracleDriver());
			
			//2. 연결 (연결 객체 만들기)
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:xe", // 서버 연결 정보
					"hr", "hoseo"); // 계정 정보 (id, password)
			
			//3. SQL 작성 + 명령 객체 만들기
			String sql = "SELECT JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY " +
						 "FROM JOBS ";
			pstmt = conn.prepareStatement(sql);
			
			//4. 명령 실행 + 결과 집합 저장 ( select인 경우 )
			rs = pstmt.executeQuery();
			
			//5. 결과 처리 (결과가 있을 경우, select인 경우) 
			while (rs.next()) { // next() : 결과 집합의 다음 행으로 이동 (데이터가 없으면 false 반환)
				System.out.printf("[%s][%s][%d][%d]\n", 
					rs.getString(1), rs.getString(2), 
					rs.getInt(3), rs.getInt(4));
			}
			
		} catch (Exception ex) { // 예외가 발생하면 실행되는 영역
			ex.printStackTrace(); // 오류 메시지를 화면에 출력
		} finally { // 예외 발생 여부와 상관없이 항상 실행되는 영역
			//6. 연결 닫기 (종료)
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
	}

}








