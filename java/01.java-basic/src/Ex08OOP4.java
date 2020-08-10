
public class Ex08OOP4 {

	public static void main(String[] args) {
		
		Person4 p1 = new Person4();
		p1.instanceField = "This is p1 instance";
		p1.sharedField = "This is p1 shared";
		Person4 p2 = new Person4();
		p2.instanceField = "This is p2 instance";
		p2.sharedField = "This is p2 shared";
		
		System.out.println(p1.instanceField);
		System.out.println(p2.instanceField);
		System.out.println(p1.sharedField);
		System.out.println(p2.sharedField);
		
		Person4.sharedField="공유 멤버이므로 클래스를 통해 접근.";
		System.out.println(p2.sharedField);
		
		Person4.sharedMethod();
		
	}
}

class Person4 {
	
	//정적 멤버(클래스 멤버)
	public static String sharedField;
	public static void sharedMethod( ) {
		System.out.println("Shared Method"); 
		// System.out.println(instanceField);//오류 : 정적 메서드에서 인스턴스 멤버 사용 불가
		
		
	}
	
	
	//인스턴스 멤버
	//private : 클래스 내부에서만 사용 가능
	public String instanceField;
	private int no;
	private String name;
	private String email;
	

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






