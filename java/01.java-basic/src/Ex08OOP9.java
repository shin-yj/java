import com.example.MyClass; 

public class Ex08OOP9 {

	public static void main(String[] args) {
		
		TheParent3 p = new TheParent3();
		p.m();
		TheChild3 c = new TheChild3();
		c.m();
		// 참조 타입(좌변)과 인스턴스 타입(우변)이 같아야 문제 X
		////2. 상속관계의 클래스인 경우 참조타입과 인스턴스타입이 다를 수 있습니다. //child는 크고 parent는 작다. child가 참조면 (좌변) 우변의 parent도 child로 본다.
		//		실제 관계에서 참조변수는 자신과 같은 타입 또는 자식 타입만 참조 가능 -> 자식객체 
		TheParent3 p2 = new TheChild3(); // 부모참조 -> 자식인스턴스 (작->큰)
		//TheChild3 c2 = new TheParent3(); // 자식참조 -> 부모인스턴스 (큰->작)
		//TheChild3 c2 = (TheChild3)new TheParent3(); // 안된다고 생각했는데 thechild라고 명시해줘서 child로 컴파일러가 해석 -> 해석했는데 차일드 아니라서 경고메세지 나옴
		TheChild3 c3 = (TheChild3)p2; //참조는 child인데 p2는 참조가 parent이므로 thechild로 우김 -> 여기선 가능 ! -> p2(child)의 인스턴스 child로 봐서 문제 x(같은child)
		
		
		System.out.println("End of Program");
		//3. 참조변수의 타입과 인스턴스 타입이 다를 때 재정의 메서드를 호출할 경우
		// 	 호출 기준은 인스턴스 타입을 따른다.
		TheParent3 p3 = new TheChild3(); // 자기보다 자식은 되지만 자기보다 위는 가리킬 수 없다. 부모 = 자식
		p3.m();// 메서드 호출 -> 부모 타입m()인지, 자식 타입m()인지!! -> 부모같겠지만, 자식을 부름
		
		//4.
		TheParent3 p4 = new TheParent3();
		if (p4 instanceof TheChild3) { // p4를 TheChild3으로 형변환 가능한지 확인
			TheChild3 c4= (TheChild3)p4;
		} else {
			System.out.println("형변환 불가능");
		}
		
		
		
		
	}
}


class TheParent3{
	
	public void m() {
		System.out.println("TheParent3.m");
	}
}


class TheChild3 extends TheParent3{
	
	public void m() {
		System.out.println("TheChild3.m"); 
	}

}



	





