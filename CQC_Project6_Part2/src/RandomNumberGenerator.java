import java.util.Random;

public class RandomNumberGenerator 
{
	private static int randomNumber;
	
	/**
	 * constructor when called generates a random number between 0 and 1000
	 */
	public RandomNumberGenerator()
	{
		Random random = new Random();
		randomNumber = random.nextInt(1000) + 1;
	}
	
	/**
	 * @return the random number
	 */
	public int getRandomNumber()
	{
		return randomNumber;
	}
}
