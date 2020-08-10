
public class Ex08OOP1 {

	public static void main(String[] args) {
		
		Person person; //  Person형 인스턴스의 주소를 저장할 참조 변수 
		person = new Person(); 	// 클래스의 내용을 메모리에 실제로 만들기 
								//+ 만들어진 것의 주소를 변수에 저장
		
		person.no = 1;
		person.name = "장동건";
		person.email = "jdk@example.com";
		
		String info = person.info();
		System.out.println(info);
	}

}

class Person {
	
	//변수 : 특성
	int no;
	String name;
	String email;
	
	//메서드 : 기능
	String info() {
		//return "[" + no + "][" + name + "][" + email + "]";
		//     "[{0}][{1}][{2}]".format(no, name, email)
		//     "[%d][%s][%s]" % (no, name, email)
		return String.format("[%d][%s][%s]", no, name, email);
	}
	
}






