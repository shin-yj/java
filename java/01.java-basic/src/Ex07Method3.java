public class Ex07Method3 {
	
	

	public static void main(String[] args) {
		
		System.out.println(sum(10, 20));
		System.out.println(sum(10, 20,30));
		System.out.println(sum(10, 20,30, 40));
		System.out.println(sum(10, 20, 30, 40, 50));
		
		System.out.println(newSum(10,20));
		System.out.println(newSum(10,20,30));

	}

	static void drawBox(int width, int height) {
	
		}
	
	static int sum(int...args) { // def sum(*args):와 같다 // ...은 같은 자료형만 가능, int만 가능.
		int sum = 0;
		for (int arg : args) { // for arg in args
			sum += arg;
		}
		return sum;
	}
	//메서드를 식별할 때 이름과 전달인자의 종류, 개수도 기준에 포함됩니다. --> 종류나 개수가 다르면 같은 모양의 메서드가 다른 기능 수행하도록 만들 수 있다. -> 메서드 오버로딩
	static int newSum(int n1, int n2) { // ...과 이 구문은 헷갈리지 않도록 이름 같이 하지 않는 것 추천
		return n1 + n2;
	}
	static int newSum(int n1, int n2, int n3) {
		return n1 + n2 + n3;
	}
}
	

