import geometry.LineLogic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LineLogicTest {
	LineLogic logic = new LineLogic();

	@ParameterizedTest
	@CsvSource({
			"0, 0, 4, 4, ONE common point",
			"0, 2, 1, 3, No common points",
			"1, 1, 6, 4, The segment lies on the line",
			"1, 1, 2, 2, ONE common point"
	})
	@DisplayName("Parametrized Test for Relative Position")
	void testRelativePosition(int x1, int y1, int x2, int y2, String expected) {
		assertEquals(expected, logic.getRelativePosition(x1, y1, x2, y2));
	}

	@Test
	@DisplayName("Test Perpendicularity - Positive")
	void testPerpendicularTrue() {
		// Vector Segment (4-1, -4-1) = (3, -5), Straight guide (5, 3)
		// 5*3 + 3*(-5) = 0
		assertTrue(logic.isPerpendicular(1, 1, 4, -4));
	}

	@Test
	@DisplayName("Test Perpendicularity - Negative")
	void testPerpendicularFalse() {
		assertFalse(logic.isPerpendicular(1, 1, 3, 3));
	}

	@Test
	@DisplayName("Test Endpoints on Line")
	void testEndpoints() {
		assertEquals("Point 1 on line", logic.checkEndpoints(1, 1, 0, 0));
	}
}