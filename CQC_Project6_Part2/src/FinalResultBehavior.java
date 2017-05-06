
public class FinalResultBehavior implements MathBehavior {

	@Override
	public ValueHolder execute(ValueHolder valueHolder) 
	{
		int finalResult = Math.abs(valueHolder.getCurrentValue() - valueHolder.getOriginalValue());
		valueHolder.setCurrentValue(finalResult);
		
		if(finalResult == 3)
		{
			System.out.println("No error: Original Value: " + valueHolder.getOriginalValue() + ", Final Result: " + valueHolder.getCurrentValue());
		}
		else
		{
			System.out.println("Data error: Original Value: " + valueHolder.getOriginalValue() + ", Final Result: " + valueHolder.getCurrentValue());
		}
		
		return valueHolder;
	}
}
