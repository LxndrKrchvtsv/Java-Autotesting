package geometry;

public class LineLogic {
	private static final int A = -3;
	private static final int B = 5;
	private static final int C = -2;

	public double calculateFunction(int x, int y) {
		return (long)A * x + (long)B * y + C;
	}

	public String getRelativePosition(int x1, int y1, int x2, int y2) {
		double f1 = calculateFunction(x1, y1);
		double f2 = calculateFunction(x2, y2);

		if (f1 == 0 && f2 == 0) {
			return "The segment lies on the line";
		}

		if (f1 * f2 < 0 || (f1 == 0 && f2 != 0) || (f2 == 0 && f1 != 0)) {
			return "ONE common point";
		}
		return "No common points";
	}

	public boolean isPerpendicular(int x1, int y1, int x2, int y2) {
		int dx = x2 - x1;
		int dy = y2 - y1;

		return (long)dx * 5 == (long)dy * -3;
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