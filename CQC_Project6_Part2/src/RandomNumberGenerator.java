import java.util.Random;

public class RandomNumberGenerator extends Thread implements MathBehavior
{

	private Buffer outBuffer;
	private Semaphore sendingSemaphore;

	/**
	 * constructor when called generates a random number between 0 and 1000
	 * @param semaphores2
	 * @param semaphores
	 * @param mathBehavior
	 * @param buffers
	 * @param i
	 */
	public RandomNumberGenerator(Buffer outBuffer, Semaphore sendingSemaphore)
	{
		System.out.println("Initialized with RandomNumberGenerator ");
		this.outBuffer = outBuffer;
		this.sendingSemaphore = sendingSemaphore;
	}

	@Override
	public ValueHolder execute(ValueHolder valueHolder)
	{
		Random random = new Random();
		int currentValue = random.nextInt(10000) + 1;
		valueHolder.setOriginalValue(currentValue);
		valueHolder.setCurrentValue(currentValue);
		return valueHolder;
	}
	
	@Override
	public void run()
	{
		for(int i = 0; i < Starter.RANDOM_NUMBERS; i++)
		{
			ValueHolder valueHolder = new ValueHolder(0,0);
			valueHolder = this.execute(valueHolder);
			this.outBuffer.write(i, valueHolder);
		}
		
		this.sendingSemaphore.take();
	}

	/**
	 * 
	 * @param randomNumbers
	 */
	public void writeToBuffer(int randomNumbers) 
	{
		for(int i = 0; i < randomNumbers; i++)
		{
			ValueHolder valueHolder = new ValueHolder(0,0);
			valueHolder = this.execute(valueHolder);
			this.outBuffer.write(i, valueHolder);
		}
		
	}
}
