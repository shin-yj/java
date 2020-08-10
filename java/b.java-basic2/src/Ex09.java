
public class Ex09 {

	public static void main(String[] args) {
		
		MyClass obj1 = new MyClass();
		obj1.data = "객체 데이터";
		
		MyClass obj2 = new MyClass();
		obj2.data = "객체 데이터"; // obj1, obj2는 객체 다름
		
		if ( obj1.equals(obj2) ) {
			System.out.println("두 객체는 같습니다.");
		} else {
			System.out.println("두 객체는 다릅니다.");
		}
		
		if ( obj1 == obj2) { // 비교 연산자(==)는 언제나 객체의 주소를 비교
			System.out.println("두 객체는 같습니다.");
		} else {
			System.out.println("두 객체는 다릅니다.");
		}

		//
		//일반적으로 문자열이 필요한 곳에서 toString을 호출합니다.
		System.out.println(obj1);// obj1.toString() 호출 -> 클래스이름@주소
		System.out.println(obj1.toString());// 같은결과
		
		
		//////////////////////////////////////////
		
		int x = 10;
//		Object obj3 = x; -> 말이 안됌 // Object obj3 = new Integer(x)
		Object obj3 = new Integer(x); // Integer : int를 저장하는 클래스
		System.out.println(obj3);
		
		int y = (int)obj3; // reference = primitive 형이 안맞음
//		int y = ((Integer)obj3).intValue(); // 이것은 맞다?
		System.out.println(y); // 
		
		/////////////////////////////////
		
		int z = Integer.valueOf("100"); // "100" -> 100
		System.out.println(z);
		String s = String.valueOf(z); // 100 -> "100
		System.out.println(s);
		
		
	}

}

// 모든 클래스는 직접 또는 간접적으로 Object를 상속합니다.
class MyClass /*extend java.lang.Object가 생략되어있음*/ { 
	
	String data;
	
	//equals는 두 객체의 동일성 비교 : Object 클래스는 주소를 비교하도록 구현 
	@Override
	public boolean equals(Object obj) {
		MyClass other = (MyClass)obj; // 재정의 // 문자열(String) 클래스는 equals를 재정의해서 값을 비교하도록 구현 -> 객체 같아지게 됨
		return this.data.equals(other.data); //문자열에 equals -> 값을 비교
		
	}
	
	@Override
	public String toString() { // java는 문자열 호출할 때 toString() 쓰자고 정의됨
		return data;
	}
}