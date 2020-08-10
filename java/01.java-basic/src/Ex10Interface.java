public class Ex10Interface {

	public static void main(String[] args) {
		
		TheInterface obj = null;
//		obj = new TheInterface(); // 인터페이스의 인스턴스를 만들 수 없다.
		
		obj = new TheImplement();
		obj.m();
		obj.m2();
		
	} 
		
}

//abstract class TheInterface { // 내용물이 abstract이므로 abstract class여야 한다.
//	
//	abstract void m();
//	abstract void m2();
//	
//}

// 모든 필드는 static final 형식 -> 반드시 초기화 필요
//인터페이스는 class와 class가 상호작용하기 위한 약속 , 메서드 정의 불가.
interface TheInterface { // 인터페이스는 모든 메서드가 추상 메서드인 자료형(타입) // 인스턴스 만들 수 없음 (new 불가) 
	static final int NO = 10;
	void m(); //interface는 언급하지 않아도 abstract임
	void m2(); 
//	void m3() {} // 인터페이스에서는 일반 메서드 정의({}) 불가
	
}

class TheImplement implements TheInterface {// 인터페이스는 다른 클래스를 통해 구현된다. // 그러므로 인터페이스를 구현하는 클래스는 반드시 모든 인터페이스의 메서드를 재정의해야 합니다. -> 변수 첫번째 클릭


	
	@Override
	public void m() {
		System.out.println("this is m"); // obj.m();선언해야 함
		
	}

	@Override
	public void m2() {
		System.out.println("this is m2");// obj.m2();선언해야 함
		
	} 
	
}