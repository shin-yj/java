
public class Ex05Array {

	public static void main(String[] args) {
		
		//1. 배열 만들기
		//int a;
		int[] ar = new int[10]; //int 데이터 10개를 관리하는 배열을 만들고
								//그 배열의 주소를 ar변수에 저장
		
		double[] dar = new double[10];
		
		//2. 배열 요소 사용
		System.out.printf("%d-%d\n", ar[0], ar[1]);
		
		for (int i = 0; i < 10; i++) { // 1 : 0 ~ 9
			ar[i] = (int)(Math.random() * 900) + 100; // 100 ~ 999
			dar[i] = (Math.random() * 900) + 100; //100.xx ~999.xx
		}
		
		for (int i = 0; i < 10; i++) { // 1 : 0 ~ 9
			System.out.printf("%d번째 데이터 : %d\n", i, ar[i]);
			System.out.printf("%d번째 데이터 : %f\n", i, dar[i]);
		}
		
		//3. 배열 초기화
//		int x;  //선언
//		x = 10; //대입
//		int y = 10; // 선언 + 대입 -> 초기화
		
		//int[] ar3 = new int[] { 1, 2, 3, 4, 5 };
		int[] ar3 = { 1, 2, 3, 4, 5 }; // 초기화~~~~~~~~~~~~~~~~~~~
		
		for (int i = 0; i < ar3.length; i++) { // 배열.length : 요소 갯수
			System.out.printf("%d번째 데이터 : %d\n", i, ar3[i]);
		}
		
		//4. 다차원 배열
		int[][] ar4 = new int[7][5]; // 7행 5열  or 가로(5) x 세로(7)
		for (int row = 0; row < ar4.length; row++) {
			for (int col = 0; col < ar4[row].length; col++) { // 열의 번호는 왼쪽부터 오른쪽 방향
				ar4[row][col] = (int)(Math.random() * 900) + 100;
			}
		}
		for (int row = 0; row < ar4.length; row++) {
			for (int col = 0; col < ar4[row].length; col++) {
				System.out.printf("[%5d]", ar4[row][col]);
			}
			System.out.println();
		}
		
		System.out.println(ar4[3][4]);
		
		System.out.println("==============================");
		
		int[] ar5 = {1,2,3,4,5};
		//for(변수 in 목록 ) {
		for (int n : ar5) {
			
			System.out.println(n);
		}

	}

}








