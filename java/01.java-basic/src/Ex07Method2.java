import java.util.Scanner;

public class Ex07Method2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("박스의 너비 : ");
		int width = scanner.nextInt();
		System.out.println("박스의 높이 : ");
		int height = scanner.nextInt();

		drawBox(width, height);
	}

	static void drawBox(int width, int height) {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (x == 0 || x == width - 1 || y == 0 || y == height - 1) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

}
