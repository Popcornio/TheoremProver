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
	
	public ArrayList<Literal> getSentance()
	{
		return this.sentance;
	}

	public Clause(String input)
	{
		String temp = new String();
		Scanner tokenizer = new Scanner(input);
		tokenizer.useDelimiter(" ");
		
		while(tokenizer.hasNext())
		{
			temp = tokenizer.next();
			sentance.add(new Literal(temp));
		}
		tokenizer.close();
		
	}

}
