package DS6.StringCache;
package DS6.StringCache;
import static org.junit.Assert.*;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Test;
// test class for string cache
public class TestStringCache {
	StringCache sCache = new StringCache();
	String input1 = "hello",
			input2 = "world!",
			input3 = "hello world!",
			input4 = "hello";
	Integer expected1 = 4,
			expected2 = 6,	
			expected3 = 9;
	Map<String, Integer> expectedMap = new LinkedHashMap<String, Integer>();
	@Test
	public void test() {
		expectedMap.put("hello", 4);
		assertEquals(expected1, sCache.checkOccurrence(input1));
		// re-using map and set
		expectedMap.put("world!", 6);
		assertEquals(expected2, sCache.checkOccurrence(input2));
		expectedMap.put("hello world!", 9);
		assertEquals(expected3, sCache.checkOccurrence(input3));
		assertEquals(expected1, sCache.checkOccurrence(input4));
		System.out.println(sCache.cacheMap);
	}
}
