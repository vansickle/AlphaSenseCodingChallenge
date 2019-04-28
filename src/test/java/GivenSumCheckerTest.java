import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class GivenSumCheckerTest {

//	private GivenSumChecker givenSumChecker;
	private SlidingWindowGivenSumChecker givenSumChecker;

	@Before
	public void setUp() throws Exception {
//		givenSumChecker = new GivenSumChecker();
		givenSumChecker = new SlidingWindowGivenSumChecker();
	}

	@Test
	public void whenTargetIsSumOfTwo_thenTrue(){
		assertThat(givenSumChecker.check(new int[]{1,2,3,4}, 7), is(true));
	}

	@Test
	public void whenNoTargetSum_thenFalse(){
		assertThat(givenSumChecker.check(new int[]{1,2,3,4}, 8), is(false));
	}

	@Test
	public void whenTargetIsSumOfThree_thenTrue(){
		assertThat(givenSumChecker.check(new int[]{1,2,3,4}, 6), is(true));
	}

	@Test
	public void whenTargetInArray_thenTrue(){
		assertThat(givenSumChecker.check(new int[]{1,2,3,4}, 4), is(true));
	}

	@Test
	public void whenTargetIsSumOfAll_thenTrue(){
		assertThat(givenSumChecker.check(new int[]{1,2,3,4}, 10), is(true));
	}
}