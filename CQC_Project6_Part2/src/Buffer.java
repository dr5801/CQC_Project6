import java.util.ArrayList;

/**
 * a data store between two threads
 *
 * @author Merlin
 *
 */
public class Buffer
{

	private static ArrayList<ValueHolder> listOfValueHolders;
	
	private int x;
	
	public Buffer(int size)
	{
		listOfValueHolders = new ArrayList<ValueHolder>(size);
	}
	

	/**
	 * write an int into this buffer
	 *
	 * @param x
	 *            the int we should store
	 */
	public void write(int x)
	{
		this.x = x;
	}

	/**
	 * @return the next int in the buffer
	 */
	public int read()
	{
		return x;
	}
}
