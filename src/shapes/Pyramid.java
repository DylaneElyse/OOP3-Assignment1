package shapes;

public class Pyramid extends Shape
{
	// attribute
	private double side;

	/**
	 * 
	 * @param height
	 * @param radius
	 */
	public Pyramid(double height, double edgeLength)
	{
		super(height);
		this.side = edgeLength;
	}

	/**
	 * 
	 * @return
	 */
	public double getSide()
	{
		return side;
	}

	// if Override, it does not need javadoc
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
