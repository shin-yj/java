
enum Color { // Color : 자료형 -> 변수를 만들 때  사용
	RED,	// Color형 변수에 저장할 수 있는 값
	GREEN,	// Color형 변수에 저장할 수 있는 값
	BLUE	// Color형 변수에 저장할 수 있는 값
	
}

public class Ex06Enum {

	public static void main(String[] args) {
		
		Color color;
		color = Color.RED; // or Color.GREEN, Color.BLUE
		
		System.out.println(color);
		
		if (color == Color.RED) {
			System.out.println("빨강");
		} else if (color == Color.GREEN) {
			System.out.println("초록");
			
		} else {
			System.out.println("파랑");
		}
		
		
	}

}
