import java.util.Arrays;

public class Polynomial
{
	private double[]	coefficients;

	public static void main(String[] args)
	{
		Polynomial p = new Polynomial(new double[] { 1, 0, 4 });
		System.out.println(p);
		System.out.println(p.getValue(2));
	}

	public Polynomial(double[] coefficients)
	{
		this.coefficients = Arrays.copyOf(coefficients, coefficients.length);
	}

	public int getDegree()
	{
		return coefficients.length - 1;
	}

	public double getValue(double x)
	{
		double out = 0;

		for (int i = 0; i < coefficients.length; i++)
		{
			out += coefficients[i] * Math.pow(x, getDegree() - i);
		}
		return out;
	}

	public String toString()
	{
		StringBuilder s = new StringBuilder(getDegree() * 9);

		for (int i = 0; i < coefficients.length; i++)
		{
			s.append(coefficients[i] + "x^" + (getDegree() - i) + " + ");
		}

		s.delete(s.length() - 3, s.length() - 1);

		return s.toString();
	}
}