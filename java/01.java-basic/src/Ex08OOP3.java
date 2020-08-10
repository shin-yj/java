
public class Ex08OOP3 {

	public static void main(String[] args) {
		
		int x;
		x = 10;
		int y = 20; // 초기화 : 변수를 만들고 즉시 값을 저장
		int [] ar = new int[3];
		ar[0] = 10;
		int[] ar2 = {1,2,3}; // 초기화(변수를 만드는 즉시 값을 넣어줌)
		
		//////////////////////////
		
		System.out.println("1");
		Person3 p = new Person3(); // new를 호출하는 시점에 변수에 데이터를 채우겠다! 생성자 메서드가 호출 // 메서드 호출(new) -> 전달인자 없다고 뜸
		System.out.println("2"); 
		System.out.println( p.info() );
		
		
		Person3 p2 = new Person3(1,"John Doe", "johndoe@example.com"); // new -> 초기화 메서드
		System.out.println(p2.info());
		
		
		
		
		
		
	}
}

class Person3 {
	
	//private : 클래스 내부에서만 사용 가능
	private int no;
	private String name;
	private String email;
	

	// [ 생성자 : constructor ]
	// 1. 클래스이름과 일치
	// 2. 결과형이 없음 (void 조차도 사용하지 않음)
	// 3. 오버로딩 가능 -> 종류를 다르게 여러개의 메서드 만들 수 있음
	// 4. new 할 때 자동으로 호출 (다른 곳에서 직접 호출하는 것은 불가능) 
	public Person3() {
		System.out.println("전달인자 없는 생성자 메서드");
		
	}

	public Person3(int no, String name, String email) {
		this(); // 같은 클래스의 다른 생성자 메서드 호출
		this.no = no;
		this.name = name;
		this.email = email;
		System.out.println("전달인자 3개인 생성자 메서드");
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name; // this : 클래스의 멤버를 표시하는 용도  
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String info() {
		return String.format("[%d][%s][%s]", no, name, email);
	}
	
}






