/**
 * handles the incrementation
 * @author Drew Rife and Jordan Long
 *
 */
public class IncrementBehavior implements MathBehavior
{

	/**
	 * increments the value passed in
	 */
	@Override
	public int execute(int value)
	{
		return value+1;
	}
}
