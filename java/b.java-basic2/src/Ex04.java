
public class Ex04 {

	public static void main(String[] args) {

		A a = new A();
		a.data = 10;
		a.data = "String";
		
//		String data = a.data; //data가 object(부모)인데 string(자식)이 왼쪽에 가면 안된다.
		String data = (String)a.data; // Object 데이터를 읽을 때 형변환 반드시 필요~~~~~~~~~ // 형변환 제대로 안하면 프로그램이 죽을 수도 있다.
		System.out.println(data);
		
		//////////////////////////////////
		
		//B<T, E> -> B<String, Integer>
		B<String, Integer> b = new B<String, Integer>();
		// b.data =10; // Generic은 이미 결정된 자료형을 바꿀 수 없습니다. -> 오류
		b.data = "String Data"; 
		b.data2 = 10;
		String data2 = b.data;
		System.out.println(data2);
		
		B<Integer, String> b2 = new B<>(); // 우변 생략해두 갠찬
		b2.data = 10; 
		b2.data2 = "String Data";
		
	}
}

class A {
//	int data; // int일 땐 int만 저장
	Object data; // Object: 모든 것의 부모가 object이다. object는 클래스, 자바의 모든 클래스가 자동으로 상속하는 클래스 -> 아무거나 다 저장 가능// public class에서 여러개 가능
}
// Generic -> 확정되지 않은 자료형으로 클래스를 정의 -> 사용할 때 자료형 결정
class B<T, E> { // <T, E> : 이 클래스 안에서 T 또는 E라는 자료형을 사용할 것이다~~~~~~~~~
			 //       		이 자료형은 사용할 때 결정됩니다~~~
	 T data;
	 E data2;
	
}
