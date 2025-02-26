package shapes;

/**
 * Represents a cone shape
 */
public class Cone extends Shape
{
	// attribute
	private double radius;

	/**
	 * Creates a cone shape with a specified height and radius
	 * 
	 * @param height represents the height of the cone
	 * @param radius represents the radius of the cone
	 */
	public Cone(double height, double radius)
	{
		super(height);
		this.radius = radius;
	}

	/**
	 * Method that will return the radius of the cone
	 * 
	 * @return returns the radius of the cone
	 */
	public double getRadius()
	{
		return radius;
	}

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
