import java.util.Scanner;

public class MagicSquare
{

	public static void main(String[] args)
	{
		Scanner kboard = new Scanner(System.in);
		System.out.print("Enter the diameter of the Magic Square: ");
		int[][] square = magicSquare(kboard.nextInt() / 2);
		System.out.println();
		displayMagicSquare(square);
		checkRows(square);
		checkColumns(square);
		checkDiagonals(square);
	}

	public static void displayMagicSquare(int[][] square)
	{
		System.out.printf("%02dx%02d Magic Square\n==================\n\n", square.length, square.length);
		for (int i = 0; i < square.length; i++)
		{
			for (int j = 0; j < square[i].length; j++)
			{
				System.out.printf(" %04d |", square[i][j]);
			}
			System.out.println();

			for (int j = 0; j < square[i].length; j++)
			{
				System.out.print("______|");
			}
			System.out.println();
		}
	}

	public static void checkRows(int[][] square)
	{
		System.out.println("\nChecking Rows\n=============\n");
		for (int i = 0; i < square.length; i++)
		{
			int sum = 0;

			for (int j = 0; j < square[i].length; j++)
			{
				sum += square[i][j];
				System.out.printf("%04d+", square[i][j]);
			}
			System.out.printf("0 = %d\n", sum);
		}
	}

	public static void checkColumns(int[][] square)
	{
		System.out.println("\nChecking Columns\n================\n");
		for (int i = 0; i < square.length; i++)
		{
			int sum = 0;

			for (int j = 0; j < square[i].length; j++)
			{
				sum += square[j][i];
				System.out.printf("%04d+", square[j][i]);
			}
			System.out.printf("0 = %d\n", sum);
		}
	}

	public static void checkDiagonals(int[][] square)
	{
		System.out.println("\nChecking Diagonals\n==================\n");
		int sum = 0;
		for (int i = 0; i < square.length; i++)
		{
			sum += square[i][i];
			System.out.printf("%04d+", square[i][i]);
		}
		System.out.printf("0 = %d\n", sum);

		sum = 0;
		for (int i = 0; i < square.length; i++)
		{
			sum += square[i][-i + (square.length - 1)];
			System.out.printf("%04d+", square[i][-i + (square.length - 1)]);
		}
		System.out.printf("0 = %d\n", sum);

	}

	public static int[][] magicSquare(int radius)
	{
		final int diameter = 2 * radius + 1;
		int[][] grid = new int[diameter][diameter];
		int row = 0;
		int column = radius;

		for (int i = 1; i <= Math.pow(diameter, 2); i++)
		{
			boolean set = false;
			do
			{
				if (grid[row][column] == 0) // If the spot is open...
				{
					grid[row][column] = i; // Set
					row--; // Advance
					column++;
					while (row < 0) // Check for out-of-bounds
					{
						row += diameter;
					}
					while (column >= diameter)
					{
						column -= diameter;
					}
					set = true; // Break the do-while loop
				}
				else
				{
					row += 2; // Backtrack and go down
					column--;
					while (row >= diameter) // Check for out-of-bounds
					{
						row -= diameter;
					}
					while (column < 0)
					{
						column += diameter;
					}
				}
			}
			while (!set);
		}

		return grid;
	}
}
