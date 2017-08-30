package DS6.StringCache;
import static org.junit.Assert.*;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.junit.Test;

public class TestStringCache {
	StringCache sCache = new StringCache();
	String input1 = "hello",
		input2 = "hello world";
	Integer expected1 = 4,
			expected2 = 9;	
	Map<String, Integer> expectedMap = new LinkedHashMap<String, Integer>();
	@Test
	public void test() {
		expectedMap.put("hello", 4);
		assertEquals(expected1, sCache.checkOccurrence(input1));
		// re-using map and set
		expectedMap.put("world!", 6);
		System.out.println(expectedMap);
		assertEquals(expected2, sCache.checkOccurrence(input2));
	}
}


