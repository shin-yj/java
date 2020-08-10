import java.util.Scanner; // 지금부터 Scanner가 나오면 java.util.Scanner입니다.

public class Ex04ControlStatement03 {

	public static void main(String[] args) {
		
		// 1~ 100까지의 합
		// (((((1 + 2) + 3) + 4) + ...) + 100)
		// 두 수를 더해서 저장
		// 이전 수의 합에 현재 수를 더하고 저장
		
		int sum = 0;
		for (int no = 1; no <= 100; no += 1) { //no +=1 -> no +no +1, no+=2면 홀수에 대한 합
			
			int newSum = sum + no;
			sum = newSum;
			// sum += no
			
			
			
	}


	System.out.printf("SUM OF 1 ~ 100 : %d\n", sum);
	
	//====================================================
	
	//구구단 5단 출력
	// 5 * 1 = 5
	// 5 * 2 = 10
	// ...
	// 5 * 9 = 45
	

	for (int i = 1; i <= 9; i += 1) {
		System.out.printf("%d X %d = %2d\n", 5, i, 5 * i); // 2는 두자리 쓰라는 것 ! 5면 " 5"로 나옴(오른쪽 정렬) , 왼쪽 정렬은 -2
		
	
				
	}

	//===================================================
	
	// 파이선은  for 변수  in 목록 
	
	// 전체 구구단 출력
	// 1 x 1 = 1   2 x 1 = 2 ... 9 x 1 = 9
	// 1 x 2 = 2   2 x 2 = 4     9 x 2 = 18
	// ....
	// 1 x 9 = 9   2 x 9 = 18 .. 9 x 9 = 81
	for (int j = 1 ; j <= 9 ; j++) { //j++ : j = j + 1, j += 1// 가로행이 더 빠르므로 세로부터 쓰고 안에 가로를 쓰기! 안이 먼저하는것이므로
		for (int i = 1; i <= 9; ++i) { // ++i : i = i + 1, j += 1
			
			System.out.printf("%d x %d = %2d | ", i, j, i*j);
	}
		System.out.println();
		

			
			
	}
	
	}
}