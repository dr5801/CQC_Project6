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

	public Buffer(int size)
	{
		listOfValueHolders = new ArrayList<ValueHolder>(size);
		for(int i = 0; i < size; i++)
		{
			listOfValueHolders.add(new ValueHolder(-1, -1));
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
		if(listOfValueHolders.get(index).getOriginalValue() < 0)
		{
			this.listOfValueHolders.get(index).setOriginalValue(result);
		}

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
