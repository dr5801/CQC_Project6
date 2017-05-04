
public class DivisionBehavior implements MathBehavior
{
	@Override
	public ValueHolder execute(ValueHolder valueHolder) 
	{
		int value = valueHolder.getCurrentValue()/2;
		valueHolder.setCurrentValue(value);
		return valueHolder;
	}
}
