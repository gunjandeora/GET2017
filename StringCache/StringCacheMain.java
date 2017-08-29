package DS6.StringCache;
import java.util.Scanner;
public class StringCacheMain {
	public static void main(String[] args) {
		StringCache sCache = new StringCache();
		Scanner scan;
		String choice = "";
		do {
			try {
				scan = new Scanner(System.in);
				System.out.println("Enter input string=");
				String input = scan.nextLine();
				System.out.println(sCache.checkOccurrence(input));
				System.out.println("\nType y to enter another string");
				choice = scan.next();
			} catch (Exception e) {
				System.out.println("Wrong input..Starting again..!!");
				main(args);
			}
		} while (choice.equalsIgnoreCase("y"));
	}
}
