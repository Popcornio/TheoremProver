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

	public String getAtom()
	{
		return this.atom;
	}
	
	public boolean getIsPositive()
	{
		return this.isPositive;
	}
	@Override
	public int compareTo(Literal o)
	{
		if(this.isPositive == o.isPositive && this.atom.equals(o.getAtom()) )
			return 0;
		else if(this.atom.equals(o.getAtom()) && this.isPositive != o.getIsPositive())
			return 1;
		else
			return -1;
	}
	
	
}