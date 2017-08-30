package DS5.Concordance;
import java.awt.List;
import java.util.HashMap;
import java.util.Map;
public class Concordance {
	Map<Character, MyLinkList> map = new HashMap<Character, MyLinkList>();
	/**
	 * This method counts occurrence of each letter of input string and save it
	 * to Map accordingly input String to check for concordance
	 * It returns Map with character as keys and list of integers as values
	 */
	public Map<Character, MyLinkList> concordanceCharacter(String input) {	
		for (int index = 0; index < input.length(); index++) {
			char letter = input.charAt(index);
			if (letter == ' ') {
				continue;
			}
			MyLinkList<Integer> list = map.get(letter);
			if (list == null) {
				list = new MyLinkList<Integer>();
			}
			list.insert(index);
			map.put(letter, list);
//			System.out.println("char:" + letter + "list:" + list.getAtLoc(0));
		}
		return map;
	}
	
	public void displayMap(){
		for(Map.Entry entry: map.entrySet() ){
		    System.out.print(entry.getKey() + ": " );
		    MyLinkList<Integer> list = (MyLinkList<Integer>) entry.getValue();

		    	list.display();
		    
		}
	}
}

