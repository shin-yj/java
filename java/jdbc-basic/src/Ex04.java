import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

public class Ex04 {

	public static void main(String[] args) {
		
		// Scanner : 명령행에서 사용자 입력 처리하는 도구
		Scanner scanner = new Scanner(System.in);
		System.out.print("검색할 기준 급여 : ");
		int salary = scanner.nextInt();
		
		
		//DB 연동에 사용되는 객체 (변수 선언)
		Connection conn = null; // 연결 관리
		PreparedStatement pstmt = null; // 명령 처리
		ResultSet rs = null; // 결과 집합 접근
		
		ArrayList<Job> jobs = new ArrayList<>(); // 조회 결과를 저장할 리스트
		
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
						 "FROM JOBS " +
						 //"WHERE MAX_SALARY >= " + salary;
						 "WHERE MAX_SALARY >= ?";
			pstmt = conn.prepareStatement(sql); 
			pstmt.setInt(1, salary); //SQL의 1번째 ?에 salary 변수의 값을 대입
			
			//4. 명령 실행 + 결과 집합 저장 ( select인 경우 )
			rs = pstmt.executeQuery();
			
			//5. 결과 처리 (결과가 있을 경우, select인 경우) 
			while (rs.next()) { // next() : 결과 집합의 다음 행으로 이동 (데이터가 없으면 false 반환)
//				System.out.printf("[%10s][%35s][%,6d][%,6d]\n", 
//					rs.getString(1), rs.getString(2), 
//					rs.getInt(3), rs.getInt(4));
				Job job = new Job(); // 한 행(Row)은 Job 객체 1개와 일치
				job.setJobId(rs.getString(1));
				job.setJobTitle(rs.getString(2));
				job.setMinSalary(rs.getInt(3));
				job.setMaxSalary(rs.getInt(4));
				
				jobs.add(job); // 한 행의 데이터를 저장한 객체를 리스트에 추가
			}
			
		} catch (Exception ex) { // 예외가 발생하면 실행되는 영역
			ex.printStackTrace(); // 오류 메시지를 화면에 출력
		} finally { // 예외 발생 여부와 상관없이 항상 실행되는 영역
			//6. 연결 닫기 (종료)
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		// 조회된 데이터 출력
		for (Job job : jobs) {
			System.out.println(job.toString());
		}
	}

}








