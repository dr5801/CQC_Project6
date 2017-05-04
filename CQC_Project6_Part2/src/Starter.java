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
		{"NumberDoubler", "AdditionBehavior", "SubtractionBehavior", "DivisionBehavior", "SubtractionBehavior"};
	private final int TOTAL_BUFFERS = behaviors.length + 1;

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
		Semaphore[] semaphores = new Semaphore[TOTAL_BUFFERS];
		Buffer[] buffers = new Buffer[TOTAL_BUFFERS];

		for(int i = 0; i < TOTAL_BUFFERS; i++)
		{
			semaphores[i] = new Semaphore();
			buffers[i] = new Buffer(RANDOM_NUMBERS);
		}

		RandomNumberGenerator rNG = new RandomNumberGenerator(buffers[0], semaphores[0], semaphores[1]);
		rNG.writeToBuffer(RANDOM_NUMBERS);

		for (int i = 0; i < behaviors.length; i++)
		{
			Class<?> behavior = Class.forName(behaviors[i]);

			if(i == behaviors.length-1)
			{
				threads[i] = new Modifier(i, buffers[i], buffers[i+1], (MathBehavior) behavior.getConstructor().newInstance(), semaphores[i], semaphores[0]);
			}
			else
			{
				threads[i] = new Modifier(i, buffers[i], buffers[i+1], (MathBehavior) behavior.getConstructor().newInstance(), semaphores[i], semaphores[i+1]);
			}
			semaphores[i].take();
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
