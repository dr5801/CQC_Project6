import java.util.Random;

public class RandomNumberGenerator extends Thread implements MathBehavior
{

	private Buffer outBuffer;
	private Semaphore sendingSemaphore;
	private Semaphore receivingSemaphore;

	/**
	 * constructor when called generates a random number between 0 and 1000
	 * @param semaphores2
	 * @param semaphores
	 * @param mathBehavior
	 * @param buffers
	 * @param i
	 */
	public RandomNumberGenerator(Buffer outBuffer, Semaphore sendingSemaphore, Semaphore receivingSemaphore)
	{
		System.out.println("Initialized with RandomNumberGenerator ");
		this.outBuffer = outBuffer;
		this.sendingSemaphore = sendingSemaphore;
		this.receivingSemaphore = receivingSemaphore;
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
			try {
				this.sendingSemaphore.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			ValueHolder valueHolder = new ValueHolder(0, 0);
			this.outBuffer.write(i, this.execute(valueHolder));

			this.receivingSemaphore.take();
		}
	}
}
