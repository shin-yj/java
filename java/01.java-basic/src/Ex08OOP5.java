
public class Ex08OOP5 {

	public static void main(String[] args) {
		
	}
}

class Person5 {
	
	int x1 = 10, x2, x3;
	final int y1 = 10, y2, y3; // final 변수는 변수 초기화 / 생성자 중 한 곳에서 초기화 해야 한다
	static final int z1 = 10, z2 = 20, z3 = 30; //static final은 반드시 변수 초기화를 통해서만 진행해야 함 (다른데 x)
	
	
	public Person5() {
		x2 = 20;
		y2 = 20;
		y3 = 30; // final 변수이므로 class나 public 안에서는 무조건 값 줘야 함(한 군데에서만!)
		// z2 = 20; // 오류(static final)
		
	}
	
	
	public void m() {
		x3 = 30;
		// y3 = 30; // 오류 : final 변수 값 변경 불가
		// z3 = 30; // 오류 - static final이므로
		
	}
	
	
}






