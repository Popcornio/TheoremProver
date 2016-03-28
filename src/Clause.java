import java.util.ArrayList;
import java.util.Scanner;

public class Clause 
{
	
	private ArrayList<Literal> sentence = new ArrayList<Literal>();
	
	// Takes the sentence which makes up the clause and creates/stores the literals that it is made of
	public Clause(String s)
	{
		Scanner tokenizer = new Scanner(s);
		tokenizer.useDelimiter(" ");
		
		// Takes the sentence then creates/stores the Literals into the 'ArrayList<Literal> sentence'
		while(tokenizer.hasNext())
		{
			String currentLiteral = tokenizer.next();
			Literal tempLit = new Literal(currentLiteral);
			sentence.add(tempLit);
		}
	}
	
}
