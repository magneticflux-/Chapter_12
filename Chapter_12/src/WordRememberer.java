import java.util.ArrayList;
import java.util.Scanner;

public class WordRememberer
{

	public static void main(String[] args)
	{
		Scanner kboard = new Scanner(System.in);
		ArrayList<String> strings = new ArrayList<String>();
		main: do
		{
			System.out
					.println("Enter a string to remember, enter \"recall\" to recall\nthe words given so far, enter \"delete\" to delete all\nwords starting with the entered charecter, or enter\n\"exit\" to exit.");
			String str = kboard.nextLine();
			if (str.equals("recall"))
			{
				System.out.println();
				for (int i = 0; i < strings.size(); i++)
				{
					System.out.println(strings.get(i));
				}
				System.out.println();
			}
			else if (str.equals("delete"))
			{
				String str2 = kboard.nextLine();
				for (int i = 0; i < strings.size(); i++)
				{
					if (strings.get(i).startsWith(str2))
					{
						strings.remove(i);
						i--;
					}
				}
			}
			else if (str.equals("exit"))
			{
				System.out.println("Goodbye!");
				break main;
			}
			else
			{
				strings.add(str);
			}

		}
		while (true);
	}
}