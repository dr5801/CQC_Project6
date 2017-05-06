
public class FinalResultBehavior implements MathBehavior {

	@Override
	public ValueHolder execute(ValueHolder valueHolder) 
	{
		int finalResult = Math.abs(valueHolder.getCurrentValue() - valueHolder.getOriginalValue());
		valueHolder.setCurrentValue(finalResult);
		
		return valueHolder;
	}
}
