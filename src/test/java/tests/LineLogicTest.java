package tests;

import geometry.LineLogic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class LineLogicTest {
	LineLogic logic = new LineLogic();

	@ParameterizedTest(name = "Test {index}: P1({0},{1}), P2({2},{3})")
	@CsvSource({
			"0, 0, 4, 4, ONE common point",
			"0, 2, 1, 3, No common points",
			"-2, -2, -4, -4, No common points",
			"1, 1, 6, 4, The segment lies on the line",
			"1, 1, 2, 2, ONE common point",
			"-4, -2, 0, 0, ONE common point"
	})
	@DisplayName("Domain Testing: Relative Position")
	void testPosition(int x1, int y1, int x2, int y2, String expected) {
		assertEquals(expected, logic.getRelativePosition(x1, y1, x2, y2));
	}

	@ParameterizedTest(name = "Perpendicular test {index}")
	@CsvSource({
			"1, 1, -2, 6, true",
			"1, 1, 4, -4, true",
			"0, 0, 3, -5, true",
			"1, 1, 3, 3, false",
			"1, 1, 6, 4, false" 
	})
	@DisplayName("Domain Testing: Perpendicularity")
	void testPerp(int x1, int y1, int x2, int y2, boolean expected) {
		assertEquals(expected, logic.isPerpendicular(x1, y1, x2, y2));
	}
}