/**
 *
 * @author Drew Rife and Jordan Long
 *
 * Custom semaphore class
 *
 */
public class Semaphore
{
	private boolean signal = false;

	/**
	 * takes the lock
	 */
	public synchronized void take()
	{
		this.signal = true;
		this.notify();
	}

	/**
	 * Releases the signal for other threads to take
	 * @throws InterruptedException
	 */
	public synchronized void release() throws InterruptedException
	{
		while(!this.signal) wait();
		this.signal = false;
	}
}
