package shapes;

import java.util.Comparator;

/**
 * Represents a class that will calculate the base area of a shape
 * and compare it to another shape
 */
public class BaseAreaCompare implements Comparator<Shape>
{

	/**
	 * Compares two shapes based on their base area
	 * @param s1 The first shape to compare
	 * @param s2 The second shape to compare
	 * @return 1 if the first shape is greater, -1 if the second shape is greater, 0 if they are equal
	 */
	@Override
	public int compare(Shape s1, Shape s2)
	{
		if(s1.calcBaseArea() > s2.calcBaseArea()) return 1;
		if(s1.calcBaseArea() < s2.calcBaseArea()) return -1;
		return 0;
	}

}
