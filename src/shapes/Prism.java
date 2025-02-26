package shapes;

/**
 * Represents a prism shape
 */
public abstract class Prism extends Shape
{
	// attribute
	private double side;

	/**
	 * Creates a prism shape with a specified height and side length
	 * 
	 * @param height height of the prism
	 * @param side side length of the prism
	 */
	public Prism(double height, double side)
	{
		super(height);
		this.side = side;
	}

	/**
	 * Method that returns the side length of the prism
	 * 
	 * @return returns the side length of the prism
	 */
	public double getSide()
	{
		return side;
	}
	
	@Override
	public double calcVolume()
	{
		return calcBaseArea() * getHeight();
	}

	@Override
	public String toString()
	{
		return "Prism getSide()=" + getSide() + ", calcVolume()=" + calcVolume() + ", getHeight()=" + getHeight()
				+ ", calcBaseArea()=" + calcBaseArea();
	}
	
}
