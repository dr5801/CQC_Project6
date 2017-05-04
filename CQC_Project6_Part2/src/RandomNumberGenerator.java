import java.util.Random;

public class RandomNumberGenerator extends Thread implements MathBehavior
{

	private int myNum;
	private Buffer outBuffer;
	private Semaphore receivingSemaphore;
	private Semaphore sendingSemaphore;

	/**
	 * constructor when called generates a random number between 0 and 1000
	 * @param semaphores2
	 * @param semaphores
	 * @param mathBehavior
	 * @param buffers
	 * @param i
	 */
	public RandomNumberGenerator(Buffer outBuffer, Semaphore receivingSemaphore, Semaphore sendingSemaphore)
	{
		System.out.println("Initialized with RandomNumberGenerator ");
		this.outBuffer = outBuffer;
		this.receivingSemaphore = receivingSemaphore;
		this.sendingSemaphore = sendingSemaphore;
	}

	@Override
	public ValueHolder execute(ValueHolder valueHolder)
	{
		Random random = new Random();
		int currentValue = random.nextInt(10000) + 1;
		valueHolder = new ValueHolder(currentValue, currentValue);
		return valueHolder;
	}

	@Override
	public void run()
	{
		for(int i = 0; i < Starter.RANDOM_NUMBERS; i++)
		{
			this.sendingSemaphore.take();

			ValueHolder valueHolder = new ValueHolder(0, 0);
			this.outBuffer.write(i, this.execute(valueHolder));

			try {
				this.receivingSemaphore.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
