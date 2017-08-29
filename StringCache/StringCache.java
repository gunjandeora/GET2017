package DS6.StringCache;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
public class StringCache {
	Map<String, Set<Character>> cacheMap = new LinkedHashMap<String, Set<Character>>();
	/**
	 * This method uses cacheMap to check for input string
	 */
	public Map<String, Set<Character>> checkOccurrence(String input) {
		Map<String, Set<Character>> map = new LinkedHashMap<String, Set<Character>>();
		String str[] = input.split(" ");
		for (int index = 0; index < str.length; index++) {
			Set<Character> set = cacheMap.get(str[index]);
			if (set == null) {
				map.put(str[index], addStringSequenceInCache(str[index]));
			} else {
				map.put(str[index], set);
			}
		}
		return map;
	}
	/**
	 * This method adds input unique string in cache and returns set with unique characters in input string
	 */
	public Set<Character> addStringSequenceInCache(String input) {
		Set<Character> set = new LinkedHashSet<Character>();
		for (int index = 0; index < input.length(); index++) {
			char letter = input.charAt(index);
			if (letter == ' ') {
				continue;
			}
			set.add(letter);
			cacheMap.put(input, set); //adding unique string and its set in cacheMap
		}
		return set;
	}
}
