package shapes;

/**
 * Represents a triangular prism shape
 */
public class TriangularPrism extends Prism
{

	/**
	 * Creates a triangular prism shape with specified height and side length
	 * @param height height of the triangular prism
	 * @param side side length of the triangular prism
	 */
	public TriangularPrism(double height, double side)
	{
		super(height, side);
	}

	@Override
	public double calcBaseArea()
	{
		return (getSide() * getSide() * Math.sqrt(3)) / 4;
	}

}
