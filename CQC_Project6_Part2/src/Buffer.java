import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 * a data store between two threads
 *
 * @author Merlin
 *
 */
public class Buffer
{

	Semaphore semaphore = new Semaphore(1);
	
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
		semaphore.release();
	}

	/**
	 * @return the next int in the buffer
	 * @throws InterruptedException 
	 */
	public ValueHolder read(int index) throws InterruptedException
	{
		semaphore.acquire();
		return valueHolders[index];
	}
}
