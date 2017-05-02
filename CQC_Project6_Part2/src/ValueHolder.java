
public class ValueHolder
{
	private int originalValue;
	private int currentValue;
	
	/**
	 * constructor for value holder
	 * 
	 * @param originalValue
	 * @param currentValue
	 */
	public ValueHolder(int originalValue, int currentValue)
	{
		this.originalValue = originalValue;
		this.currentValue = currentValue;
	}

	/**
	 * @return original value
	 */
	public int getOriginalValue()
	{
		return this.originalValue;
	}

	/**
	 * @return current value
	 */
	public int getCurrentValue()
	{
		return this.currentValue;
	}

	/**
	 * sets the current value
	 */
	public void setCurrentValue(int result)
	{
		this.currentValue = result;
	}

	/**
	 * sets the original value
	 */
	public void setOriginalValue(int value)
	{
		this.originalValue = value;
	}
}
