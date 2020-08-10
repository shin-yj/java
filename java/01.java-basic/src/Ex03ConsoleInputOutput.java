import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex03ConsoleInputOutput {

	public static void main(String[] args) throws Exception {
		
		//1. 명령프롬프트에서 사용자 입력 받기
		
		//입력기 만들기
		java.util.Scanner scanner = new java.util.Scanner(System.in); // 이 자체가 입력받는거라 생각하기! 먼저 스캐너 받아야 한다
		
	
		System.out.print("이름을 입력하세요 : ");
		String name = scanner.next();// 사용자 (키보드) 입력 - 문자열
		System.out.println(name + "님 반갑습니다.");
		
		System.out.print("숫자를 입력하세요 :");		
		int number = scanner.nextInt();// 사용자 (키보드) 입력 - 숫자
		System.out.println(number + "를 입력했습니다.");
		
		//2. 명령프롬프트에 출력
		System.out.print("print로 출력"); //끝에 줄바꿈(엔터) 없는 출력
		System.out.println("println으로 출력"); //끝에 줄바꿈 있는 출력
		String title = "Java";
		int level = 10;
		System.out.println("[TITLE : " + title + "][LEVEL : " + level + "]");
		System.out.printf("[TITLE : %s][LEVEL : %d]", title, level); // s = title, d = level
	
		//printf에서 사용하는 출력 서식의 종류
		// %s -> 문자열
		// %c -> 문자
		// %d -> 정수
		// %f -> 실수
		// %b -> boolean
		
		//scanner.close(); //사용한 입력기 반환
	}
	
}


