import java.util.Scanner; // 지금부터 Scanner가 나오면 java.util.Scanner입니다.

public class Ex04ControlStatement01 {

	public static void main(String[] args) {
		
		// 사용자의 숫자 입력을 받아서 0인지 / 음수인지 / 양수인지를 판별 후 출력
		Scanner scanner = new Scanner(System.in); // java.util. 안해두 된당
		

		System.out.print("숫자를 입력하세요 : ");
		int number = scanner.nextInt();
		System.out.printf("[%d]\n", number);
		
		if (number > 0) {
			System.out.println("양수 입니다.");
			number = 1;
		} else if (number < 0) {
			System.out.println("음수 입니다.");
			number = -1;
		} else {
			System.out.println("0입니다.");
		}
		
		switch (number) { //switch case는 단일값(1개)에 대해 평가하는 것이 가능
		case 1:
			System.out.println("양수 입니다."); // switch case문은 break를 반드시 걸어줘야 한다! 안그럼 모든 케이스 프린트
			break; // switch -case 종료
		case -1:
			System.out.println("음수 입니다.");
			break;
			default:
				System.out.println("0입니다.");
		}

	}

}
