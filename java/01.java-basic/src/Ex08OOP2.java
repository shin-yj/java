
public class Ex08OOP2 {

	public static void main(String[] args) {
		
		Person2 person; //  Person형 인스턴스의 주소를 저장할 참조 변수 
		person = new Person2(); 	// 클래스의 내용을 메모리에 실제로 만들기 
								//+ 만들어진 것의 주소를 변수에 저장

		person.setNo(-1);
		person.setName("장동건");
		person.setEmail("jdk@example.com");
		
		String info = person.info();
		System.out.println(info);
	}
}

class Person2 {
	
	//private : 클래스 내부에서만 사용 가능
	private int no;
	private String name;
	private String email;

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		if (no < 1) {
			System.out.println("번호는 0보다 커야합니다.");
			System.out.println("번호를 0으로 대체합니다.");
			this.no = 0;
			return;
		}
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

	//public : 모든 곳에서 사용 가능
	public String info() {
		//return "[" + no + "][" + name + "][" + email + "]";
		//     "[{0}][{1}][{2}]".format(no, name, email)
		//     "[%d][%s][%s]" % (no, name, email)
		return String.format("[%d][%s][%s]", no, name, email);
	}
	
}






