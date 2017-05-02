

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
	public Modifier(Integer myNum, Buffer inBuffer, Buffer outBuffer, MathBehavior mathBehavior)
	{
		System.out.println("Initialized Incrementor with " + myNum);
		this.myNum = myNum;
		this.inBuffer = inBuffer;
		this.outBuffer = outBuffer;
		this.mathBehavior = mathBehavior;
	}

	/**
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run()
	{
		ValueHolder valueHolder = null;
		System.out.println("Running Incrementor with " + myNum);
		
		synchronized(this)
		{
			try {
				outBuffer.write(this.myNum, this.mathBehavior.execute(inBuffer.read(this.myNum)));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * Extracted method to do the reading, the writing and the updating
	 */
	private void readManipulateWrite(int i)
	{
		synchronized (inBuffer)
		{
//			outBuffer.write(i, mathBehavior.execute(inBuffer.read(i)));
		}
	}
}
