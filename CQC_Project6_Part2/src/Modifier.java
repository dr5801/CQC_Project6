/**
 * Reads from an input buffer, increments and writes to an output buffer unless
 * it is number 0. In that case, it just writes increasing integers to the
 * output buffer
 *
 * @author Merlin
 *
 */

public class Modifier extends Thread
{
	private Integer myNum;
	private Buffer inBuffer;
	private Buffer outBuffer;
	private MathBehavior mathBehavior;
	private Semaphore receivingSemaphore;
	private Semaphore sendingSemaphore;

	/**
	 * Create an incrementer
	 *
	 * @param myNum
	 *            ignored unless it is zero
	 * @param inBuffer
	 *            the buffer to read from
	 * @param outBuffer
	 *            the buffer to write to
	 * @param mathBehavior
	 */
	public Modifier(Integer myNum, Buffer inBuffer, Buffer outBuffer, MathBehavior mathBehavior, Semaphore receivingSemaphore, Semaphore sendingSemaphore)
	{
		System.out.println("Initialized Incrementor with " + myNum);
		this.myNum = myNum;
		this.inBuffer = inBuffer;
		this.outBuffer = outBuffer;
		this.mathBehavior = mathBehavior;
		this.receivingSemaphore = receivingSemaphore;
		this.sendingSemaphore = sendingSemaphore;
	}

	/**
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run()
	{
		for(int i = 0; i < Starter.RANDOM_NUMBERS; i++)
		{
			try {
				this.receivingSemaphore.release();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			ValueHolder valueHolder = inBuffer.read(i);

			outBuffer.write(i, this.mathBehavior.execute(valueHolder));
			this.sendingSemaphore.take();
		}

	}
}
