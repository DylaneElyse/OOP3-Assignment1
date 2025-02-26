package shapes;

public class Cone extends Shape
{
	// attribute
	private double radius;

	/**
	 * 
	 * @param height
	 * @param radius
	 */
	public Cone(double height, double radius)
	{
		super(height);
		this.radius = radius;
	}

	/**
	 * 
	 * @return
	 */
	public double getRadius()
	{
		return radius;
	}

	// if Override, it does not need javadoc
	@Override
	public double calcBaseArea()
	{
		return Math.PI * (getRadius() * getRadius());
	}

	@Override
	public double calcVolume()
	{
		return calcBaseArea() / 3;
	}
}
