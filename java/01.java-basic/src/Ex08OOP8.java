import com.example.MyClass; 

public class Ex08OOP8 {

	public static void main(String[] args) {
		//1. 메서드 재정의 테스트
		TheParent2 p = new TheParent2();
		p.m();
		TheChild2 c = new TheChild2();
		c.m();
		
		
	}
}

// final class TheParent2{ // 상속 불가능 클래스로 정의
class TheParent2{
	
	public void m() {
		System.out.println("TheParent2.m");
	}
	final public void m2() {} // final 메서드
}

class TheChild2 extends TheParent2{
	//Method Overriding(메서드 재정의) : 부모 클래스의 메서드와 형태가 동일한 메서드를 자식 클래스에서 정의하는 것
	public void m() {
		System.out.println("TheChild2.m"); // 형태는 같고 내용만 다르게 하기. (변경, 메서드 재정의)
	}
	// public void m2() {} // final 메서드는 재정의 불가능(변경 불가능)
	}


	





