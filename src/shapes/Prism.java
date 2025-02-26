package shapes;

public abstract class Prism extends Shape
{
	// attribute
	private double side;

	public Prism(double height, double side)
	{
		super(height);
		this.side = side;
	}

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
