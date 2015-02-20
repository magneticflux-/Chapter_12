import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;

public class SierpinskiTriangle extends Applet
{
	static final long	serialVersionUID	= 0;
	triangleHelper		helper				= new triangleHelper();
	static long			START_TIME			= System.nanoTime();

	public void paint(Graphics g)
	{
		int time = (int) Math.pow(((System.nanoTime() - START_TIME) / 100000000), 2);
		int height = getHeight();
		int width = getWidth();
		Polygon p = new Polygon(new int[] { 0 - time, width / 2, width + time }, new int[] { height + time, 0,
				height + time }, 3);
		ArrayList<Polygon> poly = sierpinskiTriangle(p, 2 + (int) (Math.sqrt(time) / 16));
		for (int i = 0; i < poly.size(); i++)
		{
			g.fillPolygon(poly.get(i));
		}
		repaint();
	}

	public void init()
	{
	}

	public void start()
	{
		helper.start();
		setSize(700, 700);
		resetTime();
	}

	public static void resetTime()
	{
		START_TIME = System.nanoTime();
	}

	public static ArrayList<Polygon> sierpinskiTriangle(Polygon p, int limit)
	{
		ArrayList<Polygon> result = new ArrayList<Polygon>((int) Math.pow(limit, 3));
		result.add(p);
		for (int i = 0; i < limit; i++)
		{
			ArrayList<Polygon> temp = new ArrayList<Polygon>((int) Math.pow(i, 3));
			for (int j = 0; j < result.size(); j++)
			{
				temp.addAll(divideTriangle(result.get(j)));
			}
			result.clear();
			result.addAll(temp);
		}
		return result;
	}

	public static ArrayList<Polygon> divideTriangle(Polygon p)
	{
		ArrayList<Polygon> subTriangles = new ArrayList<Polygon>(3);
		Point x = new Point((p.xpoints[0] + p.xpoints[1]) / 2, (p.ypoints[0] + p.ypoints[1]) / 2);
		Point y = new Point((p.xpoints[1] + p.xpoints[2]) / 2, (p.ypoints[1] + p.ypoints[2]) / 2);
		Point z = new Point((p.xpoints[2] + p.xpoints[0]) / 2, (p.ypoints[2] + p.ypoints[0]) / 2);

		subTriangles.add(new Polygon(new int[] { p.xpoints[0], x.x, z.x }, new int[] { p.ypoints[0], x.y, z.y }, 3));
		subTriangles.add(new Polygon(new int[] { p.xpoints[1], y.x, x.x }, new int[] { p.ypoints[1], y.y, x.y }, 3));
		subTriangles.add(new Polygon(new int[] { p.xpoints[2], z.x, y.x }, new int[] { p.ypoints[2], z.y, y.y }, 3));
		return subTriangles;
	}
}

class triangleHelper extends Thread
{
	ArrayList<Polygon>	poly;

	public triangleHelper()
	{
	}

	public void run()
	{
		while (true)
		{
			try
			{
				Thread.sleep(13000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			SierpinskiTriangle.resetTime();
		}
	}
}
