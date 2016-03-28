public class Literal 
{
<<<<<<< HEAD

	private String atom = new String();
	boolean isPositive = true;
	
	
	public Literal(String input)
	{
		if(input.charAt(0) == '~')
		{
			isPositive = false;
			atom = input.substring(1);
		}
		else
		{
			atom = input;
		}
	}
	
=======
	boolean isPositive;	// Whether this literal is true (X) or false (~X)
	
	public Literal()
	{
		
	}

>>>>>>> origin/master
}
