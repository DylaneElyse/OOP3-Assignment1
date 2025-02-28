package shapes;

/**
 * Represents a cylinder shape
 */
public class Cylinder extends Shape
{
	// attribute
	private double radius;

	/**
	 * Creates a cylinder shape with a specified height and radius
	 * @param height height of the cylinder
	 * @param radius radius of the cylinder
	 */
	public Cylinder(double height, double radius)
	{
		super(height);
		this.radius = radius;
	}

	/**
	 * Method that returns the radius of the cylinder
	 * @return returns the radius of the cylinder
	 */
	public double getRadius()
	{
		return radius;
	}

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
