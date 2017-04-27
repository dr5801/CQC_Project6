/**
 *
 * @author Drew Rife and Jordan Long
 *
 * IncrementBehavior manages incrementing
 */
public class IncrementBehavior implements MathBehavior
{

	/**
	 * executes the MathBehavior
	 */
	@Override
	public int execute(int value)
	{
		return value+1;
	}
}
