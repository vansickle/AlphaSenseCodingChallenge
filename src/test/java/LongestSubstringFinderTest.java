import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class LongestSubstringFinderTest {

	private LongestSubstringFinder longestSubstringFinder;

	@Before
	public void setUp() throws Exception {
		longestSubstringFinder = new LongestSubstringFinder();
	}

	@Test
	public void test1(){
		int result = longestSubstringFinder.find("abcabcbb");
		assertThat(result, equalTo(3)); //abc
	}

	@Test
	public void test2(){
		int result = longestSubstringFinder.find("bbbbbb");
		assertThat(result, equalTo(1)); //b
	}

	@Test
	public void test3(){
		int result = longestSubstringFinder.find("pwwkew");
		assertThat(result, equalTo(3)); //wke
	}
}