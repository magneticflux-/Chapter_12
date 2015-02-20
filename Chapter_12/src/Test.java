import java.util.Arrays;

public class Test
{

	public static void main(String[] args)
	{
		double[] nums = new double[100];
		nums[0] = 1;
		nums[1] = 1;
		for (int i = 2; i < nums.length; i++)
		{
			nums[i] = nums[i - 1] + nums[i - 2];
			// System.out.println(nums[i]);
		}
		System.out.println("Fibbonacci: " + Arrays.toString(nums));

		int[] a = new int[100];
		for (int i = 0; i < a.length; i++)
		{
			a[i] = 2 * i + 1;
		}
		System.out.println("First 100 odds: " + Arrays.toString(a));

		boolean[] b = new boolean[100];
		for (int i = 0; i < b.length; i++)
		{
			b[i] = i % 2 == 0;
		}
		System.out.println("ALternating booleans: " + Arrays.toString(b));
	}
	
	
}