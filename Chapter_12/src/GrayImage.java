public class GrayImage
{
	public static final int	BLACK	= 0;
	public static final int	WHITE	= 255;

	private int[][]			pixelValues;

	public GrayImage(int[][] pixelValues)
	{
		this.pixelValues = pixelValues;
	}

	public int countWhitePixels()
	{
		int sum = 0;

		for (int i = 0; i < pixelValues.length; i++)
		{
			for (int j = 0; j < pixelValues[i].length; j++)
			{
				if (pixelValues[i][j] == WHITE)
				{
					sum++;
				}
			}
		}

		return sum;
	}

	public void processImage()
	{
		for (int i = 0; i < pixelValues.length; i++)
		{
			for (int j = 0; j < pixelValues[i].length; j++)
			{
				try
				{
					pixelValues[i][j] -= pixelValues[i + 2][j + 2];
					if (pixelValues[i][j] < BLACK)
					{
						pixelValues[i][j] = 0;
					}
				}
				catch (ArrayIndexOutOfBoundsException e)
				{
				}
			}
		}
	}

	public String toString()
	{
		StringBuilder str = new StringBuilder();

		for (int i = 0; i < pixelValues.length; i++)
		{
			for (int j = 0; j < pixelValues[i].length; j++)
			{
				str.append(String.format("| %03d ", pixelValues[i][j]));
			}
			str.append('\n');
		}

		return str.toString();
	}

	public static void main(String[] args)
	{
		GrayImage img = new GrayImage(new int[][] { { 63, 63, 127 }, { 127, 255, 63 }, { 255, 255, 31 } });
		System.out.println(img);
		System.out.println(img.countWhitePixels());
		img.processImage();
		System.out.println(img);
	}
}