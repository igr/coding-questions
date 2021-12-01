package google.lvl2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static google.lvl2.BunnySolution.solution;

class BunnySolutionTest {

	@Test
	void sampleExampleOne() {
		int[] A = {0, 3, 1, 4, 1,0,0};
		int want = 4311000;
		int got = solution(A);
		Assertions.assertEquals(want, got);
	}

	@Test
	void sampleExampleTwo() {
		int[] A = {3, 1, 4, 1, 5, 9};//191443=22%3=1
		int want = 94311;
		int got = solution(A);
		Assertions.assertEquals(want, got);
	}

	@Test
	void sampleExampleOneWithZero() {
		int[] A = {3, 1, 4, 1, 0};
		int want = 43110;
		int got = solution(A);
		Assertions.assertEquals(want, got);
	}

	@Test
	void sampleExampleOneWithTwoZero() {
		int[] A = {0, 3, 1, 4, 1, 0};
		int want = 431100;
		int got = solution(A);
		Assertions.assertEquals(want, got);
	}

	@Test
	void validTwoNums() {
		int[] A = {3, 7, 7};
		int want = 3;
		int got = solution(A);
		Assertions.assertEquals(want, got);
	}

	@Test
	void validNumAfterOne() {
		int[] A = {6, 8};
		int want = 6;
		int got = solution(A);
		Assertions.assertEquals(want, got);
	}

	@Test
	void oneZero() {
		int[] A = {1,2,3,0,0,0,0,0,0};
		int want = 321000000;
		int got = solution(A);
		Assertions.assertEquals(want, got);
	}

	@Test
	void oneToNine() {
		int[] A = {1,2,3,4,5,6,7,8,9};
		int want = 987654321;
		int got = solution(A);
		Assertions.assertEquals(want, got);
	}

	@Test
	void allSameNum() {
		int[] A = {2,2,2,2,2,2,2};
		int want = 222222;
		int got = solution(A);
		Assertions.assertEquals(want, got);
	}

	@Test
	void allOne() {
		int[] A = {1,1,1,1,1,1,1};
		int want = 111111;
		int got = solution(A);
		Assertions.assertEquals(want, got);
	}

	@Test
	void nineteen() {
		int[] A = {1,9};
		int want = 9;
		int got = solution(A);
		Assertions.assertEquals(want, got);
	}

	@Test
	void twoFives() {
		int[] A = {5,5};
		int want = 0;
		int got = solution(A);
		Assertions.assertEquals(want, got);
	}

}