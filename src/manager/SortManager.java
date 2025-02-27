package manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;

import shapes.*;
import utilities.Sort;

/**
 * Represents a class that will control the program and determine the sorting method
 * 
 */
public class SortManager
{

	// attributes
	private String fileName;
	private char compareType;
	private char sortType;
	private Shape[] shapes;
	private Shape[] shapesSorted;
	
	/**
	 * Creates a sortManager to process through the code
	 * @param args Arguments passed into the code through the CLI
	 */
	public SortManager(String[] args)
	{
		for(String s : args)
		{
			System.out.println(s);
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
		loadShapes(fileName);
		shapesSorted = shapes.clone();
		
		sortShapes();
		
	}

	/**
	 * Method that check the sort method and parameters and calls the sort method accordingly
	 */
	private void sortShapes()
	{
		if (compareType == 'H' || compareType == 'h')
		{
			if(sortType == 'B' || sortType == 'b')
			{
				Sort.bubbleSort(shapesSorted);
			} else if(sortType == 'S' || sortType == 's')
			{
				Sort.selectionSort(shapesSorted);
			} else if(sortType == 'I' || sortType == 'i')
			{
				Sort.insertionSort(shapesSorted);
			} else if(sortType == 'M' || sortType == 'm')
			{
				Sort.mergeSort(shapesSorted);
			} else if(sortType == 'Q' || sortType == 'q')
			{
				Sort.quickSort(shapesSorted);
			} else if(sortType == 'Z' || sortType == 'z')
			{
				Sort.radixSort(shapesSorted);
			}
			
			printResults(shapesSorted);
		}
		else if(compareType == 'A' || compareType == 'a')
		{
			BaseAreaCompare bac = new BaseAreaCompare();
			if(sortType == 'B' || sortType == 'b')
			{
				Sort.bubbleSort(shapesSorted, bac);
			} else if(sortType == 'S' || sortType == 's')
			{
				Sort.selectionSort(shapesSorted, bac);
			} else if(sortType == 'I' || sortType == 'i')
			{
				Sort.insertionSort(shapesSorted, bac);
			} else if(sortType == 'M' || sortType == 'm')
			{
				Sort.mergeSort(shapesSorted, bac);
			} else if(sortType == 'Q' || sortType == 'q')
			{
				Sort.quickSort(shapesSorted, bac);
			} else if(sortType == 'Z' || sortType == 'z')
			{
				Sort.radixSort(shapesSorted, bac);
			}
			
			printResults(shapesSorted, bac);
		}
		else if(compareType == 'V' || compareType == 'v')
		{
			VolumeCompare vc = new VolumeCompare();
			if(sortType == 'B' || sortType == 'b')
			{
				Sort.bubbleSort(shapesSorted, vc);
			} else if(sortType == 'S' || sortType == 's')
			{
				Sort.selectionSort(shapesSorted, vc);
			} else if(sortType == 'I' || sortType == 'i')
			{
				Sort.insertionSort(shapesSorted, vc);
			} else if(sortType == 'M' || sortType == 'm')
			{
				Sort.mergeSort(shapesSorted, vc);
			} else if(sortType == 'Q' || sortType == 'q')
			{
				Sort.quickSort(shapesSorted, vc);
			} else if(sortType == 'Z' || sortType == 'z')
			{
				Sort.radixSort(shapesSorted, vc);
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
		
		String fileString = "res/" + file;
		File fileName = new File (fileString);
		
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
	
	private void printResults(Shape[] sortedShapes) {
		int i = 1;
		
		for(Shape s: sortedShapes) {
			if(i == 1) {
				System.out.println(String.format("%-20s%30s%40s", "First element is: ", s.getClass(), "Height: " + s.getHeight()));
			} else if (i == sortedShapes.length) {
				System.out.println(String.format("%-20s%30s%40s", "Last element is: ", s.getClass(), "Height: " + s.getHeight()));
			} else if (i % 1000 == 0) {
				System.out.println(String.format("%-20s%30s%40s", i + "-th element: ", s.getClass(), "Height: " + s.getHeight()));
				
			} 	
			i++;
		}
	}
		
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
				System.out.println(String.format("%-20s%30s%40s", "First element is: ", s.getClass(), compType + ": " + s.assignCalc(s, compType)));
				
			} else if (i == sortedShapes.length) {
				System.out.println(String.format("%-20s%30s%40s", "Last element is: ", s.getClass(), compType + ": " + s.assignCalc(s, compType)));
			} else if (i % 1000 == 0) {
				System.out.println(String.format("%-20s%30s%40s", i + "-th element: ", s.getClass(), compType + ": " + s.assignCalc(s, compType)));
				
			} 
			i++;
		}
		
		
		
		
		
		
		
	}
}
