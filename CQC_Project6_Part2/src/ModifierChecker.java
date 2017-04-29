


/**
 * Checks to make sure that the items in its input buffer are incrementing
 * 
 * @author Merlin
 *
 */
public class ModifierChecker extends Thread
{
	private Integer myNum;
	private Buffer inBuffer;

	/**
	 * Create a checker
	 * 
	 * @param myNum
	 *            not used
	 * @param inBuffer
	 *            the buffer we should check
	 * @param outBuffer
	 *            not used
	 */
	public ModifierChecker(Integer myNum, Buffer inBuffer, Buffer outBuffer)
	{
		System.out.println("Initialized Incrementor with " + myNum);
		this.myNum = myNum;
		this.inBuffer = inBuffer;
	}

	/**
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run()
	{

		System.out.println("Running Incrementor with " + myNum);
		int last = inBuffer.read(0);
		for (int i = 1; i < Starter.RANDOM_NUMBERS; i++)
		{
			int next = inBuffer.read(i);
			if (next != last + 1)
			{
				System.out.println(next + " followed " + last);
			}
			last = next;
		}
	}

}
