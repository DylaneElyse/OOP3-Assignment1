package shapes;

public class PentagonalPrism extends Prism
{

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
