import com.example.MyClass; 

public class Ex09Abstract {

	public static void main(String[] args) {

		AbstractClass obj = null;
		// obj = new AbstractClass(); // 인스턴트 못만드므로 오류 !!
		
	}
	
}
// 추상클래스 : 인스턴스 만들 수 없는 클래스
//			추상메서드를 포함하는 클래스는 반드시 추상클래스로 만들어야 합니다.
abstract class AbstractClass {
	
	// 추상메서드 : 본문({})을 가질 수 없는 메서드 , 규약, 약속,계약(추상 메서드에 조건 있어야 추상 클래스 쓰는 것들이 그 조건을 쓸 수 있음)
	abstract void m();
	
}
// 추상 클래스는 다른 클래스가 상속해서 사용하는 용도 -> new를 못하니까 상속해서 사용
// 추상 클래스를 상속하는 클래스는 반드시 추상메서드를 재정의 해야 합니다.(추상클래스가 되어야 함, 그냥 클래스는 안됨-> 그냥 클래스일 경우 오류 인자에 올려놔서 첫번째 거 클릭 )
class ConcreteClass extends AbstractClass{

	@Override // 자바에게 주는 주석
	void m() { // override일 때 m2는 불가 같은 m으로!
		System.out.println("This is m");
		
	} 
	
	
}





	





