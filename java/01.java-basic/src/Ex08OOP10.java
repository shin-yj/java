import com.example.MyClass; 

public class Ex08OOP10 {

	public static void main(String[] args) {
		
		// Line 여러 개, Rectangle 여러 개, Oval 여러 개  만들어서 사용 -> 배열 세 개 만들기
//		int[] ar = new int[3]; // 배열은 int만 가능
//		lines[0] = new TheLine();

		TheShape[] shapes = new TheShape[10]; // 3개 다 넣을 수 있는 배열
		for(int i = 0; i < shapes.length; i++) {
			if(i % 3 == 0) {
				shapes[i] = new TheLine();
				
			} else if ( i % 3 == 1) {
				shapes[i] = new TheRectangle();
				
			}else {
				shapes[i] = new TheOval();
			}
		}
		for (TheShape shape : shapes) {
			// 다형성(polymorphism) : 동일한 코드가 상황(객체)에 따라 다른 실행을 하는 것
			shape.draw();
			
		}
				
	}
	

}

class TheShape {
	public void draw() {
		System.out.println("draw shape");
	}
}
class TheLine extends TheShape {
	public void draw() {
		System.out.println("draw line");
	}
}

class TheRectangle extends TheShape {
	public void draw() {
		System.out.println("draw rectangle");
	}
}

class TheOval extends TheShape {
	public void draw() {
		System.out.println("draw oval");
	}
}






	





