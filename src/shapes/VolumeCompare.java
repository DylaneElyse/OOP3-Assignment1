package shapes;

import java.util.Comparator;

public class VolumeCompare implements Comparator<Shape>
{
	@Override
	public int compare(Shape s1, Shape s2)
	{
		if(s1.calcVolume() > s2.calcVolume()) return 1;
		if(s1.calcVolume() < s2.calcVolume()) return -1;
		return 0;
	}

}
