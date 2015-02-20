import java.util.Arrays;

public class PascalsTriangle
{
	public static void main(String[] args)
	{
		for (int i = 0; i < 21; i++) // Can't go farther than line 22 :(
		{
			System.out.println(Arrays.toString(pascalTriangleLine(i)));
		}
	}

	public static long[] pascalTriangleLine(int line)
	{
		long[] newLine = new long[line + 1];
		for (int i = 0; i <= line; i++)
		{
			newLine[i] = combination(line, i);
		}
		return newLine;
	}

	public static long factorial(long x)
	{
		long product = 1;
		for (long i = 1; i <= x; i++)
		{
			product *= i;
		}
		return product;
	}

	public static long combination(long n, long k) // n choose k
	{
		return factorial(n) / (factorial(k) * factorial(n - k));
	}
}
