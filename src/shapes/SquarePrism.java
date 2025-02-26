package shapes;

/**
 * Represents a square prism shape
 */
public class SquarePrism extends Prism
{

	/**
	 * Creates a square prism shape with a specified height and side length
	 * 
	 * @param height height of the square prism
	 * @param side length of the side of the square prism
	 */
	public SquarePrism(double height, double side)
	{
		super(height, side);
	}

	@Override
	public double calcBaseArea()
	{
		return getSide() * getSide();
	}
	
}
