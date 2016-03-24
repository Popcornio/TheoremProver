/*
 * Name:		Daniel Pacheco & Nathan Barnfield
 * Course:		CS 4365.001
 * Homework:	#3
 * Due Date:	March 29th, 2016
 * Class:		Prover.java
*/

public class Prover
{
	
	public static void main (String args[])
	{
		commandLineCheck(args);
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
	
}
