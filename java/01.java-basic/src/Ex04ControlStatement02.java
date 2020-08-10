import java.util.Scanner; // 지금부터 Scanner가 나오면 java.util.Scanner입니다.

public class Ex04ControlStatement02 {

	public static void main(String[] args) {
		
		// 계산기 만들기
		// - 숫자 입력, 연산자 입력, 숫자 입력
		// - 계산
		// - 출력
		
		Scanner scanner = new Scanner(System.in); // java.util. 안해두 된당
		
		System.out.print("첫 번째 숫자를 입력하세요 : ");
		int number1 = scanner.nextInt();
		System.out.print("연산자(+,-,*,/,%)를 입력하세요 : ");
		String op = scanner.next();
		System.out.print("두 번째 숫자를 입력하세요 : ");
		int number2 = scanner.nextInt();
		int result = 0;
		boolean valid = true;
		if (op.equals("+")) { // op가 +와 같은지 확인 ( ==가 java에서는 의미가 다르기때문에 쓰지 않음) java에서 문자를 비교할 때는 equals 사용
			result = number1 + number2;
		} else if (op.equals("-")) {
			result = number1 - number2;
		} else if (op.equals("*")) {
			result = number1 * number2;
		} else if (op.equals("/")) {
			result = number1 / number2;
		} else if (op.equals("%")) {
			result = number1 % number2;
		} else {
			System.out.println("지원하지 않는 연산자");
			valid = false;
		}
		if(valid) {
			System.out.printf(
					"%d %s %d = %d\n", number1, op, number2, result);
		}

	    System.out.printf(
	    		"%d %s %d = %d\n", number1, op, number2, result);


    /////////////////////////////////////////////////
	//switch -case
	switch (op) {
	case "+":
		result = number1 + number2; break; // break 해줘야 default값 안나옴
	case "-":
		result = number1 - number2; break;
	case "*":
		result = number1 * number2; break;
	case "/":
		result = number1 / number2; break;
	case "%":
		result = number1 % number2; break;
	default:
		System.out.println("지원하지 않는 연산자");
		valid = false;
	}
	if (valid) {
		System.out.printf(
				"%d %s %d = %d\n", number1, op, number2, result);
	}
	


}
}
