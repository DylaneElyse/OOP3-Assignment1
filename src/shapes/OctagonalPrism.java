package shapes;

/**
 * Represents an octagonal prism shape
 */
public class OctagonalPrism extends Prism
{

	/**
	 * Creates an octagonal prism with a specified height and side length
	 * @param height height of the octagonal prism
	 * @param side side length of the octagonal prism
	 */
	public OctagonalPrism(double height, double side)
	{
		super(height, side);
	}

	@Override
	public double calcBaseArea()
	{
		return 2 * (1 + Math.sqrt(2) * (getSide() * getSide()));
	}

}
