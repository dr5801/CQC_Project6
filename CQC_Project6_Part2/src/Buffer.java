/**
 * a data store between two threads
 *
 * @author Merlin
 *
 */
public class Buffer
{
	private ValueHolder[] valueHolders = {};

	public Buffer(int size)
	{
		this.valueHolders = new ValueHolder[size];
	}

	/**
	 * write an int into this buffer
	 *
	 * @param x
	 *            the int we should store
	 */
	public void write(int index, ValueHolder valueHolder)
	{
		valueHolders[index] = valueHolder;
	}

	/**
	 * @return the next int in the buffer
	 * @throws InterruptedException
	 */
	public ValueHolder read(int index)
	{
		return valueHolders[index];
	}
}
