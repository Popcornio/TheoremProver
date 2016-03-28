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
	

	// Takes the input file and returns the clasues to be stored in 'ArrayList<Clause> clauses'
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

	
	private static ArrayList<Clause> resolveClauses(ArrayList<Clause> validClauses)
	{
		PriorityQueue<Clause> queue = new PriorityQueue<Clause>();
		
		queue.addAll(validClauses);	
		
		while(!queue.isEmpty())
		{
			Clause tempClause = queue.poll();
		
			
		}
		
		return null;			//return failure
		
	}
	
	private static resolve(ArrayList<Clause> validClauses, )

}
