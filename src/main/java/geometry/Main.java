package geometry;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LineLogic logic = new LineLogic();

		System.out.println("Line: -3x + 5y - 2 = 0");
		System.out.print("Enter x1, y1: ");
		int x1 = scanner.nextInt();
		int y1 = scanner.nextInt();
		System.out.print("Enter x2, y2: ");
		int x2 = scanner.nextInt();
		int y2 = scanner.nextInt();

		String position = logic.getRelativePosition(x1, y1, x2, y2);
		System.out.println("Result: " + position);

		if (position.equals("ONE common point")) {
			boolean perp = logic.isPerpendicular(x1, y1, x2, y2);
			System.out.println("Is perpendicular: " + (perp ? "Yes" : "No"));
			System.out.println("Endpoint status: " + logic.checkEndpoints(x1, y1, x2, y2));
		}
	}
}