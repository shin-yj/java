import java.util.Scanner; // 지금부터 Scanner가 나오면 java.util.Scanner입니다.

public class Ex04ControlStatement04 {

	public static void main(String[] args) {
	
		//1~10사이의 숫자 중 우연히 5를 뽑을 때까지 뽑힌 숫자의 출력을 반복하세요.
		// 우연히 5가 뽑히면 멈추세요!
		boolean running = true;
		while (running) {
			double dr = Math.random(); // 0 ~ 1 사이의 난수
			dr = dr * 10; // 0~ 10 -> 0은 포함되나 10은 포함 x
			// int ir = (int)dr; // (자료형)변수 : 변수의 데이터를 지정된 자료형으로 변경하시오
			int ir = (int)Math.floor(dr)+ 1; // 바꾼다음 형변환처리 // +1 을 해주면 1~10사이의정수
			
			if (ir == 5) {
				System.out.println("5 IS SELECTED !!!! ");
				running = false;
			} else {
				System.out.println("SELECTED NUMBER : " + ir);
			}
		}
	
		//=======================================================
		int ir = 0;
		do {
			double dr = Math.random(); // 0 ~ 1 사이의 난수
			dr = dr * 10; // 0~ 10 -> 0은 포함되나 10은 포함 x
			// int ir = (int)dr; // (자료형)변수 : 변수의 데이터를 지정된 자료형으로 변경하시오
			ir = (int)Math.floor(dr)+ 1; // 바꾼다음 형변환처리 // +1 을 해주면 1~10사이의정수
	
				System.out.println("SELECTED NUMBER : " + ir);
			}
		
		 while (ir != 5);
		System.out.println("FINALLY 5 IS SELECTED !!!!");
		
		
		// ===================
		
		outer: for (int i=0; i<10; i++) {
			System.out.println("i is" + i);
			inner: for(int j = 0; j < 10 ; j++) {
				System.out.printf("[j is %d]" , j);
				
				if (j == 5) {
					//break; // 제일 가까운 반복문 break
					// break outer; //이름이 outer인 반복문 break
				}
			}
		}
		System.out.println();

	
	}

}
