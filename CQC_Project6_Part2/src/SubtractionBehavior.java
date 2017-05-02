
public class SubtractionBehavior implements MathBehavior
{
	@Override
	public ValueHolder execute(ValueHolder valueHolder) 
	{
		valueHolder.setCurrentValue(valueHolder.getCurrentValue() - 3);
		return valueHolder;
	}
}
