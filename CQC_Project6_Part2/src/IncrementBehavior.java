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
	public ValueHolder execute(ValueHolder valueHolder)
	{
		valueHolder.setCurrentValue(valueHolder.getCurrentValue() + 1);
		return valueHolder;
	}
}
