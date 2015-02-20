import java.util.Arrays;

public class Exercises
{
	public static void main(String[] args)
	{
		System.out.println(Arrays.toString(ex3(new int[] { 1, 2, 3, 4 })));
		System.out.println(ex4(new int[] { 1, 1, 1, 1 }));
		System.out.println(Arrays.toString(createWedge(3)));
		System.out.println(Arrays.toString(fib(10)));
		System.out.println(computeScore("Mitchell"));
		System.out.println(largest(new int[][] { { 1, 2 }, { 3, 2 } }));
		print2DArray(pascal(5));
		System.out.println(isMedian(new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 5));
	}

	public static void print2DArray(int[][] in)
	{
		for (int i = 0; i < in.length; i++)
		{
			System.out.println(Arrays.toString(in[i]));
		}
	}

	public static int[] ex3(int[] in)
	{
		int temp = in[0];
		in[0] = in[in.length - 1];
		in[in.length - 1] = temp;
		return in;
	}

	public static boolean ex4(int[] scores)
	{
		return scores[0] == scores[scores.length - 1];
	}

	// Returns an array filled with values
	// 1, 2, ..., n-1, n, n-1, ..., 2, 1
	public static int[] createWedge(int n)
	{
		int[] out = new int[n * 2 - 1];

		for (int i = 0; i < n; i++)
		{
			out[i] = i + 1;
		}

		for (int i = n; i < out.length; i++)
		{
			out[i] = out.length - i;
		}

		return out;
	}

	public static int[] fib(int n)
	{
		int[] out = new int[n];
		for (int i = 0; i < out.length; i++)
		{
			if (i == 0 || i == 1)
			{
				out[i] = 1;
			}
			else
			{
				out[i] = out[i - 1] + out[i - 2];
			}
		}
		return out;
	}

	public static int computeScore(String in)
	{
		String s = in.toUpperCase();
		int score = 0;
		int[] scores = new int[] { 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10 };

		for (int i = 0; i < s.length(); i++)
		{
			score += scores[(int) s.charAt(i) - 65];
		}

		return score;
	}

	public static int largest(int[][] in)
	{
		int largest = 0;

		for (int i = 0; i < in.length; i++)
		{
			for (int j = 0; j < in[i].length; j++)
			{
				if (in[i][j] > 0 && in[i][j] > largest)
				{
					largest = in[i][j];
				}
			}
		}
		return largest;
	}

	public static int[][] pascal(int n)
	{
		int[][] out = new int[n][];

		for (int i = 0; i < out.length; i++)
		{
			out[i] = pascalTriangleLine(i);
		}

		return out;
	}

	public static int[] pascalTriangleLine(int line)
	{
		int[] newLine = new int[line + 1];
		for (int i = 0; i <= line; i++)
		{
			newLine[i] = combination(line, i);
		}
		return newLine;
	}

	public static int factorial(int x)
	{
		int product = 1;
		for (int i = 1; i <= x; i++)
		{
			product *= i;
		}
		return product;
	}

	public static int combination(int n, int k) // n choose k
	{
		return factorial(n) / (factorial(k) * factorial(n - k));
	}

	public static boolean isMedian(double[] sample, double m)
	{
		int difference = 0;
		for (int i = 0; i < sample.length; i++)
		{
			if (m > sample[i])
			{
				difference++;
			}
			else if (m < sample[i])
			{
				difference--;
			}
		}
		return difference == 0;
	}
}