package shapes;
/**
 * Represents a Shape.
 */
public abstract class Shape implements Comparable<Shape>
{
	// attribute
	private double height;

	/**
	 * Creates a shape with specified height.
	 * @param height height of Shape.
	 */
	public Shape(double height)
	{
		super();
		this.height = height;
	}

	/**
	 * Returns the height of the Shape.
	 * @return returns the height of the Shape.
	 */
	public double getHeight()
	{
		return height;
	}
	
	@Override
	public int compareTo(Shape other)
	{
		if(this.height < other.height){
			return -1;
		}
		if(this.height > other.height){
			return 1;
		}
		return 0;
	}
		
	/**
	 * Returns the calculated base area of the Shape.
	 * @return returns the base area of the Shape.
	 */
	public abstract double calcBaseArea();
	
	/**
	 * Returns the calculated volume of the Shape.
	 * @return returns the volume of the Shape.
	 */
	public abstract double calcVolume();

	@Override
	public String toString()
	{
		return "Shape [getHeight()=" + getHeight() + ", calcBaseArea()=" + calcBaseArea() + ", calcVolume()="
				+ calcVolume() + "]";
	}
	
	/**
	 * Assigns the calculation of the Shape.
	 * @param s Shape to calculate.
	 * @param value value to calculate.
	 * @return returns the calculated value.
	 */
	public <T> double assignCalc(T s, String value) {
		if (value == "Volume") {
			return ((Shape) s).calcVolume();
		}
		if (value == "Area") {
			return ((Shape) s).calcBaseArea();
		}
		return 0.0;
	}
}
