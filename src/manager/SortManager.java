package manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;

import shapes.*;
import utilities.Sort;

/**
 * Represents a class that will control the program and determine the sorting method
 */
public class SortManager
{

	// attributes
	private String fileName = null;
	private Character compareType = null;
	private Character sortType = null;
	private Shape[] shapes;
	private Shape[] shapesSorted;
	private String timeString;
	
	/**
	 * Creates a sortManager to process through the code
	 * @param args Arguments passed into the code through the CLI
	 */
	public SortManager(String[] args)
	{
		for(String s : args)
		{
			if(s.startsWith("-f") || s.startsWith("-F"))
			{
				fileName = s.substring(2);
			}
			else if (s.startsWith("-t") || s.startsWith("-T"))
			{
				compareType = s.charAt(2);
			} 
			else if (s.startsWith("-s") || s.startsWith("-S"))
			{
				sortType = s.charAt(2);
			}
		}

		
		if (fileName != null && compareType != null && sortType != null) {
		loadShapes(fileName);
		shapesSorted = shapes.clone();
		
		sortShapes();
		System.out.println(timeString);
		}
		else {
			System.out.println("Error: Invalid arguments entered");
			System.out.println("Arguments can be in any order, but they must contain:");
			System.out.println("-f\033[3mfileName\033[0m -t\033[3mcompareType\033[0m -s\033[3msortType\033[0m");
		}

	}

	/**
	 * Method that checks the sort method and parameters and calls the sort method accordingly
	 */
	private void sortShapes()
	{
		if (compareType == 'H' || compareType == 'h')
		{
			if(sortType == 'B' || sortType == 'b')
			{
				timeString = Sort.timeTracker(shapesSorted, "bubbleSort", null);
			} else if(sortType == 'S' || sortType == 's')
			{
				timeString = Sort.timeTracker(shapesSorted, "selectionSort", null);
			} else if(sortType == 'I' || sortType == 'i')
			{
				timeString = Sort.timeTracker(shapesSorted, "insertionSort", null);
			} else if(sortType == 'M' || sortType == 'm')
			{
				timeString = Sort.timeTracker(shapesSorted, "mergeSort", null);
			} else if(sortType == 'Q' || sortType == 'q')
			{
				timeString = Sort.timeTracker(shapesSorted, "quickSort", null);
			} else if(sortType == 'Z' || sortType == 'z')
			{
				timeString = Sort.timeTracker(shapesSorted, "radixSort", null);
			}
			printResults(shapesSorted);

		}
		else if(compareType == 'A' || compareType == 'a')
		{
			BaseAreaCompare bac = new BaseAreaCompare();
			if(sortType == 'B' || sortType == 'b')
			{
				timeString = Sort.timeTracker(shapesSorted, "bubbleSort", bac);
			} else if(sortType == 'S' || sortType == 's')
			{
				timeString = Sort.timeTracker(shapesSorted, "selectionSort", bac);
			} else if(sortType == 'I' || sortType == 'i')
			{
				timeString = Sort.timeTracker(shapesSorted, "insertionSort", bac);
			} else if(sortType == 'M' || sortType == 'm')
			{
				timeString = Sort.timeTracker(shapesSorted, "mergeSort", bac);
			} else if(sortType == 'Q' || sortType == 'q')
			{
				timeString = Sort.timeTracker(shapesSorted, "quickSort", bac);
			} else if(sortType == 'Z' || sortType == 'z')
			{
				timeString = Sort.timeTracker(shapesSorted, "radixSort", bac);
			}
			printResults(shapesSorted, bac);
		}
		else if(compareType == 'V' || compareType == 'v')
		{
			VolumeCompare vc = new VolumeCompare();
			if(sortType == 'B' || sortType == 'b')
			{
				timeString = Sort.timeTracker(shapesSorted, "bubbleSort", vc);
			} else if(sortType == 'S' || sortType == 's')
			{
				timeString = Sort.timeTracker(shapesSorted, "selectionSort", vc);
			} else if(sortType == 'I' || sortType == 'i')
			{
				timeString = Sort.timeTracker(shapesSorted, "insertionSort", vc);
			} else if(sortType == 'M' || sortType == 'm')
			{
				timeString = Sort.timeTracker(shapesSorted, "mergeSort", vc);
			} else if(sortType == 'Q' || sortType == 'q')
			{
				timeString = Sort.timeTracker(shapesSorted, "quickSort", vc);
			} else if(sortType == 'Z' || sortType == 'z')
			{
				timeString = Sort.timeTracker(shapesSorted, "radixSort", vc);
			}
			printResults(shapesSorted, vc);
		}		
	}

	/**
	 * Method that accepts a file name as a String and loads the objects based on the information in the file
	 * @param file File that holds the shape information
	 */
	private void loadShapes(String file)
	{
		File fileName = new File (file);
		
		int i = 0;
		try
		{
			Scanner scanner = new Scanner(fileName);
			
			while (scanner.hasNext())
			{
				if (i == 0)
				{
					String line = scanner.nextLine();
					int shapesNum = Integer.parseInt(line);
					shapes = new Shape[shapesNum];
				}
				String line = scanner.nextLine();
				String[] fields = line.split(" ");
				String shape = fields[0];
				double height = Double.parseDouble(fields[1]);
				double second = Double.parseDouble(fields[2]);
				switch (shape) {
				case "Cone":
					Cone con = new Cone (height, second);
					shapes[i] = con;
					break;
				case "Cylinder":
					Cylinder cyl = new Cylinder (height, second);
					shapes[i] = cyl;
					break;
				case "OctagonalPrism":
					OctagonalPrism oct = new OctagonalPrism (height, second);
					shapes[i] = oct;
					break;
				case "PentagonalPrism":
					PentagonalPrism pen = new PentagonalPrism (height, second);
					shapes[i] = pen;
					break;
				case "Pyramid":
					Pyramid pyr = new Pyramid (height, second);
					shapes[i] = pyr;
					break;
				case "SquarePrism":
					SquarePrism squ = new SquarePrism (height, second);
					shapes[i] = squ;
					break;
				case "TriangularPrism":
					TriangularPrism tri = new TriangularPrism (height, second);
					shapes[i] = tri;
					break;
				}
				i++;
			}
			scanner.close();
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Method that prints the results of the sorting algorithm
	 * @param sortedShapes Array of shapes that have been sorted
	 */
	private void printResults(Shape[] sortedShapes) {
		int i = 1;
		for(Shape s: sortedShapes) {
			if(i == 1) {
				System.out.println(String.format("%-20s%-30s%-40s", "First element is: ", s.getClass(), "Height: " + s.getHeight()));
			} else if (i == sortedShapes.length) {
				System.out.println(String.format("%-20s%-30s%-40s", "Last element is: ", s.getClass(), "Height: " + s.getHeight()));
			} else if (i % 1000 == 0) {
				System.out.println(String.format("%-20s%-30s%-40s", i + "-th element: ", s.getClass(), "Height: " + s.getHeight()));
			} 	
			i++;
		}
	}
	
	/**
	 * Method that prints the results of the sorting algorithm when also passed a comparator
	 * @param sortedShapes Array of shapes that have been sorted
	 * @param c Comparator that is used to sort the shapes
	 */
	private void printResults(Shape[] sortedShapes, Comparator<Shape> c) {
		int i = 1;
		String className = c.getClass().getName();
		String compType = "";
		if ( className.contains("Volume")) {
			compType = "Volume";
		} else if (className.contains("BaseArea")) {
			compType = "Area";
		}
		for(Shape s: sortedShapes) {
			if(i == 1) {
				System.out.println(String.format("%-20s%-30s%-40s", "First element is: ", s.getClass(), compType + ": " + s.assignCalc(s, compType)));
				
			} else if (i == sortedShapes.length) {
				System.out.println(String.format("%-20s%-30s%-40s", "Last element is: ", s.getClass(), compType + ": " + s.assignCalc(s, compType)));
			} else if (i % 1000 == 0) {
				System.out.println(String.format("%-20s%-30s%-40s", i + "-th element: ", s.getClass(), compType + ": " + s.assignCalc(s, compType)));
			} 
			i++;
		}
	}
}
