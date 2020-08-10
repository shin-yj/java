import com.example.MyClass; 

public class Ex08OOP7 {

	public static void main(String[] args) {
		
		
		TheChild c = new TheChild();
		c.v = "상속 받은 변수";
		System.out.println(c.v); // v는 child것이 아니지만 parent에 상속되었기 때문에 쓸 수 있다.
		c.m();
		c.m2();
		
		
	}
}

class TheParent{
	public String v;
	private String pv;
	public void m() {
		
		System.out.println("TheParent.m");
		
	}
	public TheParent() {
		System.out.println("TheParent.Constructor()");
	}
	public TheParent(String v) {
		System.out.println("TheParent.Constructor2()");
	}
	
}
//extends : TheParent 클래스의 모든 멤버를 가져와서 TheChild에 포함
class TheChild extends TheParent{
	// 상속 받은 클래스는 새로운 멤버를 추가하거나 기존 멤버를 변경해야 합니다.
	
	public String v2; // 새로운 멤버 추가
	public void m2() {
		System.out.println("TheChild.m2");
		super.v = "수정된 데이터"; // super는 부모 클래스의 멤버를 표현하는 도구
		//pv = "변경된 데이터"; // 부모 클래스의  !!private!! 멤버를 자식클래스가 사용할 수 X
	}

	public TheChild() {
		super("전달인자 있는 생성자 호출"); // 원하는 부모 클래스의 생성자를 호출하는 구문  
		System.out.println("TheParent.Constructor()");
	}
}
	





