/*
 * Name:		Daniel Pacheco & Nathan Barnfield
 * Course:		CS 4365.001
 * Homework:	#3
 * Due Date:	March 29th, 2016
 * Class:		Prover.java
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Prover
{
	
	public static void main (String args[]) throws IOException
	{
		ArrayList<Clause> clauses = new ArrayList<Clause>();
		
		commandLineCheck(args);
		clauses = getClauses(args);
		
/*	    
		// Test print for clauses
		for (int i = 0; i < 5; i++)
		{
			Clause s = clauses.get(i);
			System.out.println(s.toString());
		}
*/
	}
	
	// Checks to see if the correct amount of command line arguments were entered
	public static void commandLineCheck(String args[])
	{
		if(args.length != 1)
		{
			System.err.println("ERROR: Unexpected number of command-line arguments");
			System.exit(-1);
		}
	}
	
	// Takes the input file and returns the clauses to be stored in 'ArrayList<Clause> clauses'
	public static ArrayList<Clause> getClauses(String args[]) throws FileNotFoundException
	{
		String inputFile	= args[0];
		ArrayList<Clause> c = new ArrayList<Clause>();
		Scanner clauseInput = new Scanner(new File(inputFile));
		
		while(clauseInput.hasNextLine())
		{
			String currentLine = clauseInput.nextLine();
			Clause temp = new Clause(currentLine);
			c.add(temp);
		}
		clauseInput.close();
		
		return c;
	}
	
	private static ArrayList<Clause> prover(ArrayList<Clause> validClauses)
	{
		PriorityQueue<Clause> queue = new PriorityQueue<Clause>();
		
		queue.addAll(validClauses);	
		
		while(!queue.isEmpty())
		{
			Clause tempClause = queue.poll();
		
			
		}
		
		return null; // Return failure
		
	}
	
	private static ArrayList<Clause> resolve(ArrayList<Clause> validClauses, Clause clause1)
	{
		ArrayList<Clause> newClauses = new ArrayList<>();
		
		for(int i = 0; i < validClauses.size(); i++)
		{
			if(clause1.compareLiterals(validClauses.get(i)))
			{
				if(isResolvable(clause1, validClauses.get(i)))
				{
					Clause temp = resolveClauses(validClauses, clause1, validClauses.get(i));
					
					if(temp != null)
						newClauses.add(temp);
				}
			}
		}
		return newClauses;
	}
	
	public static boolean isResolvable(Clause clause1, Clause clause2)							//Compare all the literals from clause1 and clause 2 to see if there is a
	{																					//resolvable set of literals. returns true if it finds one.
		for(int i = 0; i < clause1.getSentance().size(); i++)
		{
			for(int j = 0; j < clause2.getSentance().size(); j++)
			{
				if(clause1.getSentance().get(i).compareTo(clause2.getSentance().get(j)) == 1)
					return true;
			}
		}
		return false;
	}
	
	public static Clause resolveClauses( ArrayList<Clause> validClauses, Clause clause1, Clause clause2)
	{
		for(int i = 0; i < clause1.getSentance().size(); i++)
		{
			for(int j = 0; j < clause2.getSentance().size(); j++)
			{
				if(clause1.getSentance().get(i).compareTo(clause2.getSentance().get(j)) == 1)
				{
					int parA = validClauses.indexOf(clause1);
					int parB = validClauses.indexOf(clause2);
					
					ArrayList<Literal> temp = new ArrayList<>();
					temp = clause1.getSentance();						//get the sentence from clause1 and remove the resolved literal
					temp.remove(clause1.getSentance().get(i));
					
					ArrayList<Literal> newSentance = new ArrayList<>();
					newSentance.addAll(temp);							//add the sentance to the new sentance for the new clause
					
					ArrayList<Literal> temp2 = new ArrayList<>();
					temp2 = clause2.getSentance();						//get the sentence from clause 2 and remove the resolved literal
					temp2.remove(clause2.getSentance().get(j));
					
					newSentance.addAll(temp2);							//add the sentence to the new sentence that will be placed in the new clause
					
					return new Clause(newSentance, parA, parB);
					
				}
			}
		}
		return null;
	}
	
	public static void done(ArrayList<Clause> validClauses, Clause solution)
	{
		ArrayList<Integer> relevantClauses = new ArrayList<>();
		relevantClauses = grabRelevantClauses(validClauses, solution, relevantClauses);
		Collections.sort(relevantClauses);
		
		for(int i = 0; i < relevantClauses.size(); i++)
		{
			int parents[] = {Integer.MIN_VALUE, Integer.MIN_VALUE};
			parents = validClauses.get(relevantClauses.get(i)).getParents();
			System.out.println(relevantClauses.get(i) + ". " + validClauses.get(relevantClauses.get(i)).toString() + " {" + parents[0] + ", " + parents[1] + "}");
		}
		
		int parents[] = {Integer.MIN_VALUE, Integer.MIN_VALUE};
		parents = solution.getParents();
		
		System.out.println((relevantClauses.size() + 1) + ". False {" + parents[0] + ", " + parents[1] );
		
		System.out.println("Size of final clause set: " + validClauses.size());
		
		System.exit(0);
		
	}
	
	public static ArrayList<Integer> grabRelevantClauses(ArrayList<Clause> validClauses, Clause clause1, ArrayList<Integer> relevantClauses)
	 {
	 	int parents[] = {Integer.MIN_VALUE, Integer.MIN_VALUE};
	 	clause1.getParents();
	 	 
	 	if(parents[0] == Integer.MIN_VALUE && parents[1] == Integer.MIN_VALUE)
	 	{
	 	return relevantClauses;
	 	}
	 	
	 	 if(!relevantClauses.contains(parents[0]))
	 		 relevantClauses.add(parents[0]);
	 	
	 	relevantClauses = grabRelevantClauses(validClauses, validClauses.get(parents[0]), relevantClauses);
		
	 	if(!relevantClauses.contains(parents[1]))
	 		relevantClauses.add(parents[1]);
		
		relevantClauses = grabRelevantClauses(validClauses, validClauses.get(parents[1]), relevantClauses);
		
		return relevantClauses;
	}
}
