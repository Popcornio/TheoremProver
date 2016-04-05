import java.util.ArrayList;
import java.util.Scanner;

public class Clause implements Comparable<Clause>
{
	
	private ArrayList<Literal> sentence = new ArrayList<Literal>();
	private int numLiterals;
	private int parents[] = new int[2];
	
	// Constructor used for when you only have the clause in a String format
	public Clause(String input)
	{
		String temp = new String();
		Scanner tokenizer = new Scanner(input);
		tokenizer.useDelimiter(" ");
		
		while(tokenizer.hasNext())
		{
			temp = tokenizer.next();
			sentence.add(new Literal(temp));
		}
		tokenizer.close();
		
		parents[0] = Integer.MIN_VALUE;
		parents[1] = Integer.MIN_VALUE;
		
	}
	
	// Constructor used when you have an ArrayList of Literals (mainly used in the resolveClauses functions)
	public Clause(ArrayList<Literal> input, int indexOfParA, int indexOfParB)
	{
		sentence = input;
		numLiterals = input.size();
		parents[1] = indexOfParA;
		parents[2] = indexOfParB;
	}
	
	public int[] getParents()
	{
		return this.parents;
	}
	
	public ArrayList<Literal> getSentance()
	{
		return this.sentence;
	}
	
	@Override
	public int compareTo(Clause arg0)
	{
		
		if(this.numLiterals == arg0.numLiterals)
			return 0;
		else
			return this.numLiterals > arg0.numLiterals ? 1 : -1;
	}
	
	public String toString()
	{
		String s = "";
		
		for (int i = 0; i < sentence.size(); i++)
		{
			s += sentence.get(i).toString() + " ";
		}
		
		return s;
	}

	public boolean compareLiterals(Clause input)
	{
		if(this.sentence.size() != input.sentence.size())
			return false;
		for(int i = 0; i < this.sentence.size(); i++)
		{
			for(int j = 0; j < input.sentence.size();j++)
			{
				if(input.sentence.get(j).compareTo(this.sentence.get(i)) < 0)
					return false;
			}
		}
		
		return true;
	}
		
}
