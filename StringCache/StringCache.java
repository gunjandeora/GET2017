package DS6.StringCache;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
public class StringCache {
	public static Map<String, Integer> cacheMap = new LinkedHashMap<String, Integer>();
	/**
	 * This method uses cacheMap to check for input string
	 */
	public Integer checkOccurrence(String input) {
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		//String str[] = input.split(" ");
		if(cacheMap.containsKey(input)){
			return cacheMap.get(input);
		}
		else {
			TreeSet<Character> set = new TreeSet<Character>();
			for (int index = 0; index < input.length(); index++) {
				set.add(input.charAt(index));
			}
			cacheMap.put(input, set.size());
			return set.size();
		}	
	}
}
