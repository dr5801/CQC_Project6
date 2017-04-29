
public class SubtractionBehavior 
{
	/**
	 * @param number
	 * @return
	 */
	public int getResult(int number)
	{
		return number - 3;
	}
	
	/**
	 * @param originalNumber
	 * @param previousResult
	 * @return originalNumber - previousResult
	 */
	public int getResult(int originalNumber, int previousResult)
	{
		return originalNumber - previousResult;
	}
}
