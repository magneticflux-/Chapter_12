import java.util.Arrays;
import java.util.Scanner;

public class EratosthenesSieve
{
	public static final int	primesPerLine	= 16;

	public static void main(String[] args)
	{
		System.out.println("\nTextLab06\n");
		Scanner kboard = new Scanner(System.in);
		System.out.print("Enter the upper prime bound: ");
		int bound = kboard.nextInt();
		int[] primes = sieve(bound);

		System.out.println("\n");

		for (int i = 0; i < primes.length; i++)
		{
			System.out.printf("%04d ", primes[i]);
			if (i % primesPerLine == primesPerLine - 1)
			{
				System.out.println();
			}
		}
	}

	public static int[] sieve(int bound)
	{
		boolean[] primes = new boolean[bound];
		int numprimes = 0;

		Arrays.fill(primes, true);
		primes[0] = false;
		primes[1] = false;

		for (int i = 0; i < primes.length; i++)
		{
			if (primes[i])
			{
				numprimes++;
				for (int j = 2 * i; j < primes.length; j += i)
				{
					primes[j] = false;
				}
			}
		}
		int[] numbers = new int[numprimes];

		numprimes = 0;
		for (int i = 0; i < primes.length; i++)
		{
			if (primes[i])
			{
				numbers[numprimes] = i;
				numprimes++;
			}
		}

		return numbers;
	}
}
