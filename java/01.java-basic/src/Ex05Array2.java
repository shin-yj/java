import java.util.Scanner; //앞으로 Scanner가 나오면 java.util.Scanner입니다

public class Ex05Array2 {

	public static void main(String[] args) {
		
		// 로또 당첨 예상번호 추출기
		// 1번 : 1 ~ 45의 번호, 중복 X, 6개의 난수 뽑기
		// 2번 : 뽑은 숫자의 평균이 20 ~ 26 사이여야 함 -> 아니면 1부터 다시
		// 3번 : 뽑힌 숫자 출력 
		// 4번 : 1 ~ 3의 작업을 사용자가 원하는 동안 계속 반복

		//java.util.Scanner 
		Scanner scanner = new Scanner(System.in); // /주소 저장하는 변수 / = /실제 저장하는 변수/ 만듬 // 사용자 입력 도구
		while (true) { // 무한 반복
			
		
		System.out.println("******************************");
		System.out.println("* 1. 당첨 예상 번호 뽑기                           *");
		System.out.println("* 2. 프로그램 종료                                   *");
		System.out.println("******************************");
		System.out.print("작업 번호를 입력하세요 : ");
		String taskNo = scanner.nextLine();
		
		System.out.println();
		
		if (taskNo.equals("1")) {
			//번호 뽑기
			int[] numbers = new int[6];
			for (int i = 0; i <numbers.length ; i++) {
				numbers[i] = (int)(Math.random() * 45) +1 ; // 1~ 45
				for (int j = 0; j < i ; j++) {
					if (numbers[i] == numbers[j]) {
						// i--; // 번호 다음번호로 올라가지 않도록 그대로 머물게 하기
						i = -1;
						break;
					}
				}
			}
			//출력
			System.out.println("선택된 번호 : ");
			for(int i=0; i < numbers.length; i++) {
				System.out.printf("[%d]", numbers[i]);
			}
			
		} else if (taskNo.equals("2")) {
			System.out.println("행운을 빕니다.");
			System.out.println("프로그램을 종료합니다.");
			break; //while문 끝내기
			
		} else {
			System.out.println("지원하지 않는 작업입니다.");
			}
		System.out.println();
		
		}
		
		
		
		
		

	}

}



