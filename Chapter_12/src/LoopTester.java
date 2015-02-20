public class LoopTester
{

	public static void main(String[] args)
	{
		int[] random = new int[Integer.MAX_VALUE / 79];
		double sum = 0;
		for (int i = 0; i < random.length; i++)
		{
			random[i] = (int) (Math.random() * 100 + .5);
			// System.out.println(random[i]);
			sum += random[i];
		}
		System.out.println("Average: " + (sum / random.length));
	}

}
