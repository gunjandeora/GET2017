package DS5.Concordance;
import java.util.Scanner;
public class ConcordanceMain {
	public static void main(String[] args) {
		Concordance obj = new Concordance();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter input String = ");
		String input = scan.nextLine();
		obj.concordanceCharacter(input);
		obj.displayMap();
	}
}
