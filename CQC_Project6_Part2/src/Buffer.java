import java.util.ArrayList;

/**
 * a data store between two threads
 *
 * @author Merlin
 *
 */
public class Buffer
{

	private ArrayList<ValueHolder> listOfValueHolders;
	
	private int x;
	
	public Buffer(int size)
	{
		listOfValueHolders = new ArrayList<ValueHolder>(size);
		for(ValueHolder valueHolder : listOfValueHolders)
		{
			valueHolder = new ValueHolder(0, 0);
		}
	}
	

	/**
	 * write an int into this buffer
	 *
	 * @param x
	 *            the int we should store
	 */
	public void write(int index, int result)
	{
		this.listOfValueHolders.get(index).setCurrentValue(result);
	}

	/**
	 * @return the next int in the buffer
	 */
	public int read(int index)
	{
		return this.listOfValueHolders.get(index).getCurrentValue();
	}
}
