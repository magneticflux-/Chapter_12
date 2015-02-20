import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;

public class SquareZoom extends Applet
{
	private static final long	serialVersionUID	= 1L;

	public void paint(Graphics g)
	{
		int limit = 64;
		ArrayList<Polygon> polygons = new ArrayList<Polygon>(limit);
		polygons.add(new Polygon(new int[] { 0, getWidth(), getWidth(), 0 },
				new int[] { 0, 0, getHeight(), getHeight() }, 4));
		for (int i = 0; i < limit; i++)
		{
			polygons.add(smallerSquare(polygons.get(i)));
			g.setColor(new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
			g.fillPolygon(polygons.get(i));
		}
		// repaint(); // Seizure mode
	}

	public Polygon smallerSquare(Polygon p)
	{
		return new Polygon(new int[] { average(p.xpoints[0], p.xpoints[1]), average(p.xpoints[1], p.xpoints[2]),
				average(p.xpoints[2], p.xpoints[3]), average(p.xpoints[3], p.xpoints[0]) }, new int[] {
				average(p.ypoints[0], p.ypoints[1]), average(p.ypoints[1], p.ypoints[2]),
				average(p.ypoints[2], p.ypoints[3]), average(p.ypoints[3], p.ypoints[0]) }, 4);
	}

	public static int average(int x, int y)
	{
		return (x + y) / 2;
	}
}
