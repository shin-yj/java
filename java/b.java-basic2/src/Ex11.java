import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Ex11 {

	public static void main(String[] args) {

		System.out.println("1. before m1");
		try { // 오류 발생이 의심되는 영역 설정 -> 이 영역에서 발생한 오류만 catch할 수 있음
			m1();

		} catch (ArithmeticException ex) {
			System.out.println("산술 연산 오류를 처리했습니다."); // 오류가 발생했을 때 실행하는 명령어
		} catch (IndexOutOfBoundsException ex) {
			System.out.println("배열 인덱스 오류를 처리했습니다.");
		} finally { // 오류 발생 여부와 상관 없이 실행되는 영역
			System.out.println("오류와 상관 없이 항상 실행");

		}
		System.out.println("4. after m1");

		/////////////////////////////////
		m2();
//		m3(); // 문제 생김 -> Checked 예외를 throws하는 메서드 호출은 반드시 예외 처리 필요
		
	}

	static void m1() {
		System.out.println("2. beginning of m1");
		switch ((int) Math.random() * 4) { // 0 or 1 or 2 or 3
		case 0:
			int x = 10 / 0; // ArithmaticException 발생
			break;
		case 1:
			int[] ar = { 1, 2, 3, 4, 5 };
			int y = ar[10]; // IndexOutOfBoundsException 발생
			break;
		default:
			System.out.println("정상 실행 코드");

		}

		System.out.println("3. End of m1");
	}

	static void m2() {

		try {
			// FileNotFoundException : 반드시 예외 처리가 필요
			FileInputStream fis = new FileInputStream("not-exist.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static void m3() throws FileNotFoundException {

		// FileNotFoundException : 반드시 예외 처리가 필요
		FileInputStream fis = new FileInputStream("not-exist.txt");
	}
}
