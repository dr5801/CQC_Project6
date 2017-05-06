
public class FinalResultChecker extends Thread
{
	private Buffer inBuffer;
	private Semaphore receivingSemaphore;
	private Semaphore sendingSemaphore;
	
	public FinalResultChecker(Buffer inBuffer, Semaphore receivingSemaphore, Semaphore sendingSemaphore) 
	{
		this.inBuffer = inBuffer;
		this.receivingSemaphore = receivingSemaphore;
		this.sendingSemaphore = sendingSemaphore;
	}

	
	/**
	 * checks each final result
	 */
	@Override 
	public void run()
	{
		for(int i = 0; i < Starter.RANDOM_NUMBERS; i++)
		{
			try {
				this.receivingSemaphore.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(this.inBuffer.read(i).getCurrentValue() == 3)
			{
				System.out.println("No error: Original Value: " + this.inBuffer.read(i).getOriginalValue() + ", Final Result: " + this.inBuffer.read(i).getCurrentValue());
			}
			else
			{
				System.out.println("Data error: Original Value: " + this.inBuffer.read(i).getOriginalValue() + ", Final Result: " + this.inBuffer.read(i).getCurrentValue());
			}
			
			this.sendingSemaphore.take();
		}
	}
}
