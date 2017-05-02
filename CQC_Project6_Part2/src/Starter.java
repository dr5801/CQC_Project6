

import java.lang.reflect.InvocationTargetException;

/**
 * @author Merlin
 *
 *
 */
public class Starter
{

	/**
	 * The number of iterations each behavior should do
	 */
	public static final int RANDOM_NUMBERS = 10000;
	private String[] behaviors =
		{ "RandomNumberGenerator", "NumberDoubler", "AdditionBehavior", "SubtractionBehavior", "DivisionBehavior", "SubtractionBehavior" };
	private Buffer buffer;

	/**
	 * spawn off all of the behaviors giving them appropriate input and output
	 * buffers
	 *
	 *
	 * @throws ClassNotFoundException
	 *             shouldn't
	 * @throws NoSuchMethodException
	 *             shouldn't
	 * @throws SecurityException
	 *             shouldn't
	 * @throws InstantiationException
	 *             shouldn't
	 * @throws IllegalAccessException
	 *             shouldn't
	 * @throws IllegalArgumentException
	 *             shouldn't
	 * @throws InvocationTargetException
	 *             shouldn't
	 * @throws InterruptedException
	 *             shouldn't
	 */
	public Starter() throws ClassNotFoundException, NoSuchMethodException,
			SecurityException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			InterruptedException
	{
		Thread threads[] = new Thread[behaviors.length];
		buffer = new Buffer(RANDOM_NUMBERS);
		for (int i = 0; i < behaviors.length; i++)
		{

			Class<?> behavior = Class.forName(behaviors[i]);

			threads[i] = new Modifier(i, buffer, buffer, (MathBehavior) behavior.getConstructor().newInstance());
			threads[i].start();

		}
		for (int i = 0; i < threads.length; i++)
		{
			threads[i].join();
		}


//		ConstantChecker checker = new ConstantChecker(buffer, RANDOM_NUMBERS
//				* (behaviors.length ) + 1);
//		checker.check();

	}

	/**
	 * @param args
	 *            none
	 * @throws InvocationTargetException
	 *             shouldn't
	 * @throws IllegalArgumentException
	 *             shouldn't
	 * @throws IllegalAccessException
	 *             shouldn't
	 * @throws InstantiationException
	 *             shouldn't
	 * @throws SecurityException
	 *             shouldn't
	 * @throws NoSuchMethodException
	 *             shouldn't
	 * @throws ClassNotFoundException
	 *             shouldn't
	 * @throws InterruptedException
	 *             shouldn't
	 */
	public static void main(String[] args) throws ClassNotFoundException,
			NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, InterruptedException
	{

		new Starter();

	}
}
