package eg.edu.alexu.csd.datastructure.hangman.cs;
import java.util.*;
public class testE {
	public static void main(String[] args) throws Exception {
		IMP test=new IMP();
		test.read();
		test.setDictionary(test.words);
		test.selectRandomSecretWord();
		test.setWord();
		test.setMaxWrongGuesses(5);
		try (Scanner scan = new Scanner(System.in)) {
			while(test.wrong!=0 && test.count!=0) {
				System.out.print("Enter your character:");
				char s= scan.next().charAt(0);
				test.guess(s);
			}
		}
	}

}
