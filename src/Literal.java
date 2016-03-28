public class Literal implements Comparable<Literal>
{

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
	
	public String toString()
	{
		if (isPositive)
			return atom;
		else
			return ("~" + atom);
	


	}

	@Override
	public int compareTo(Literal o) {
		if(this.isPositive == o.isPositive && this.atom.equals(o) )
			return 0;
		else 
			return -1;
	}
	
	
}