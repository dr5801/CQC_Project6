


/**
 * Checks that the final results are correct
 */
public class ModifierChecker
{
	/**
	 * checks all the final results
	 * @param buffer
	 * @return true if all the final results are correct; false otherwise
	 */
	public boolean checkFinalResults(Buffer buffer)
	{
		boolean allCorrectValues = true;
		
		int i = 0;
		while( (i < Starter.RANDOM_NUMBERS) && allCorrectValues )
		{
			allCorrectValues = (buffer.read(i).getCurrentValue() == 3);
			i++;
		}
		
		if(!allCorrectValues)
		{
			System.out.println("Data error : Expected 3 but was -> " + buffer.read(i).getCurrentValue());
		}

		return allCorrectValues;
	}
}
