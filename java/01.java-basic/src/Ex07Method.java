
public class Ex07Method {
	
	static void showGreetings() { //메소드 만들기
		
		System.out.println("Hello, Java Method !!!!");
		System.out.println("Test Message");
		int x =10;
	}
	static void showGreetings2(String name) { //메소드 만들기 
		System.out.println("Hello, " + name);
	}
	static String makeGreetings(String name) { //메소드 만들기 
		String greetings = "Hello, " + name;
		return greetings; // 호출한 곳으로 greetings의 값을 반환(전달)
	}
	public static void main(String[] args) {

		showGreetings(); // 메서드 호출: 메서드를 실행하게 만드는 명령
		
		//////////////////////////////////////////////
		
		// int x =20;
		// system.out.println(x); 오류 : 다른 지역에서 만든 변수사용 x
		
		int x = 20; // 이 변수 x와  showGreetings 메서드 내부의 x는 다른 변수
		
		//////////////////////////////////////////////

		String name = "장동건";
		showGreetings2(name); // name은 전달인자 :메서드에게 전달하는 데이터
		
		/////////////////////////////////////////////
		String greetings = makeGreetings("김윤석");
		System.out.println(greetings);
	}
	
		
}
