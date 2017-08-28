package DS5.Concordance;
import java.awt.List;
import DS2.CounsellingSystem.*;
import java.util.HashMap;
import java.util.Map;
import DS2.CounsellingSystem.MyArrayList;
public class Concordance {
	/**
	 * This method counts occurrence of each letter of input string and save it
	 * to Map accordingly input String to check for concordance
	 * It returns Map with character as keys and list of integers as values
	 */
	public Map<Character, MyArrayList> concordanceCharacter(String input) {
		Map<Character, MyArrayList> map = new HashMap<Character, MyArrayList>();
		for (int index = 0; index < input.length(); index++) {
			char letter = input.charAt(index);
			if (letter == ' ') {
				continue;
			}
			MyArrayList list = map.get(letter);
			if (list == null) {
				list = new MyArrayList();
			}
			list.add(index);
			map.put(letter, list);
		}
		return map;
	}
}

