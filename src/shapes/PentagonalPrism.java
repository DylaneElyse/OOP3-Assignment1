package shapes;

/**
 * Represents a pentagonal prism
 */
public class PentagonalPrism extends Prism
{

	/**
	 * Creates a pentagonal prism shape with a specified height and side length
	 * @param height height of the pentagonal prism
	 * @param side side length of the pentagonal prism
	 */
	public PentagonalPrism(double height, double side)
	{
		super(height, side);
	}

	@Override
	public double calcBaseArea()
	{
		return ( 5 * (getSide() * getSide()) * Math.tan(54)) / 4;
	}

}
