
public class NumberDoubler implements MathBehavior
{
	@Override
	public ValueHolder execute(ValueHolder valueHolder) 
	{
		valueHolder.setCurrentValue(valueHolder.getCurrentValue() * 2);
		return valueHolder;
	}
}
