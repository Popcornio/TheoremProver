import java.util.ArrayList;
import java.util.Scanner;

public class Clause 
{
	private ArrayList<Literal> sentance = new ArrayList<Literal>();
	
	
	
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
