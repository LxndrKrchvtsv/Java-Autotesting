package geometry;

public class LineLogic {
	// Direct coefficients -3x + 5y - 2 = 0
	private static final int A = -3;
	private static final int B = 5;
	private static final int C = -2;

	public double calculateFunction(int x, int y) {
		return A * x + B * y + C;
	}

	public String getRelativePosition(int x1, int y1, int x2, int y2) {
		double f1 = calculateFunction(x1, y1);
		double f2 = calculateFunction(x2, y2);

		if (f1 == 0 && f2 == 0) {
			return "The segment lies on the line";
		} else if (f1 * f2 < 0 || (f1 == 0 && f2 != 0) || (f1 != 0 && f2 == 0)) {
			return "ONE common point";
		} else if (f1 * f2 > 0) {
			return "No common points";
		}
		return "Intersection";
	}

	public boolean isPerpendicular(int x1, int y1, int x2, int y2) {
		int vx = x2 - x1;
		int vy = y2 - y1;
		// Direction vector straight (B, -A) -> (5, 3)
		return (5 * vx + 3 * vy) == 0;
	}

	public String checkEndpoints(int x1, int y1, int x2, int y2) {
		boolean p1OnLine = calculateFunction(x1, y1) == 0;
		boolean p2OnLine = calculateFunction(x2, y2) == 0;

		if (p1OnLine && p2OnLine) return "Both ends on line";
		if (p1OnLine) return "Point 1 on line";
		if (p2OnLine) return "Point 2 on line";
		return "None of the ends on line";
	}
}