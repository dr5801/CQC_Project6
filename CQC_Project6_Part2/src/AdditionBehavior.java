
public class AdditionBehavior implements MathBehavior
{
	@Override
	public ValueHolder execute(ValueHolder valueHolder) 
	{
		valueHolder.setCurrentValue(valueHolder.getCurrentValue() + 9);
		return valueHolder;
	}
}
