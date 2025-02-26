package shapes;

/**
 * Represents a pyramid shape
 */
public class Pyramid extends Shape
{
	// attribute
	private double side;

	/**
	 * Creates a pyramid shape with a specified height and radius
	 * 
	 * @param height height of the pyramid
	 * @param radius radius of the pyramid
	 */
	public Pyramid(double height, double edgeLength)
	{
		super(height);
		this.side = edgeLength;
	}

	/**
	 * Method that returns the length of the side of the pyramid
	 * 
	 * @return returns the side length of the pyramid
	 */
	public double getSide()
	{
		return side;
	}

	@Override
	public double calcBaseArea()
	{
		return getSide() * getSide();
	}

	@Override
	public double calcVolume()
	{
		return (calcBaseArea() * getHeight()) / 3;
	}

}
