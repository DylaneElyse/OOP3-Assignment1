package shapes;

public class Cylinder extends Shape
{
	// attribute
	private double radius;

	/**
	 * 
	 * @param height
	 * @param radius
	 */
	public Cylinder(double height, double radius)
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
		return Math.PI * getRadius() * getRadius();
	}

	@Override
	public double calcVolume()
	{
		return Math.PI * (getRadius() * getRadius()) * getHeight();
	}

}
