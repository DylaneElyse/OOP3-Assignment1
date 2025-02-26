package utilities;

/**
 * Represents a class containing sort methods
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import shapes.BaseAreaCompare;
import shapes.Shape;
import shapes.VolumeCompare;

public class Sort
{

	public static <T extends Comparable<T>> void bubbleSort(T[] shapes)
	{
		long start, stop;
		start = System.currentTimeMillis();

	        for (int i = 0; i < shapes.length - 1; ++i) {
	            for (int j = 0; j < (shapes.length - 1) - i; ++j) {
	                if (shapes[j].compareTo(shapes[j + 1]) < 0) { // descending
	                    Shape tmp = shapes[j];
	                    shapes[j] = shapes[j + 1];
	                    shapes[j + 1] = tmp;
	                }
	            }
	        }
		
	        stop = System.currentTimeMillis();
	        System.out.println("Bubble Sort run time was: " + (stop - start) + " miliseconds"); 
	}

	public static <T> void bubbleSort(Shape[] shapes, Comparator<Shape> c)
	{
		long start, stop;
		start = System.currentTimeMillis();

	        for (int i = 0; i < shapes.length - 1; ++i) {
	            for (int j = 0; j < (shapes.length - 1) - i; ++j) {
	                if (c.compare(shapes[j], shapes[j + 1]) < 0) { // descending
	                    Shape tmp = shapes[j];
	                    shapes[j] = shapes[j + 1];
	                    shapes[j + 1] = tmp;
	                }
	            }
        	}
		
        	stop = System.currentTimeMillis();
        	System.out.println("Bubble Sort run time was: " + (stop - start) + " miliseconds");   		
	}

	public static void selectionSort(Shape[] shapes)
	{
		long start, stop;
		start = System.currentTimeMillis();

	        for (int i = 0; i < shapes.length - 1; ++i) {
	        	Shape max = shapes[i];
	            for (int j = i; j < shapes.length; ++j) {
	            	if (shapes[j].getHeight() > max.getHeight()) {
	            		max = shapes[j];
	            	}
	            if (max.compareTo(shapes[i]) > 0 && (i != j)) { // descending
		            Shape tmp = shapes[i];
		            shapes[i] = shapes[j];
		            shapes[j] = tmp;
	            }        
	            }            
	        }            
		
        	stop = System.currentTimeMillis();
        	System.out.println("Selection Sort run time was: " + (stop - start) + " miliseconds"); 
	}
	
	public static <T> void selectionSort(T[] shapes, Comparator<T> c)
	{
		// TODO Auto-generated method stub
		
	}
	
	public static void insertionSort(Shape[] shapes)
	{
		// TODO Auto-generated method stub
		
	}

	public static <T> void insertionSort(T[] shapes, Comparator<T> c)
	{
		// TODO Auto-generated method stub
		
	}

	public static void mergeSort(Shape[] shapes)
	{
		// TODO Auto-generated method stub
		
	}
	
	public static <T> void mergeSort(T[] shapes, Comparator<T> c)
	{
		// TODO Auto-generated method stub
		
	}

	public static void quickSort(Shape[] shapes)
	{
		// TODO Auto-generated method stub
		
	}
	
	public static <T> void quickSort(T[] shapes, Comparator<T> c)
	{
		// TODO Auto-generated method stub
		
	}

	/**
	 * This method processes through a Radix Sort. It takes a list of numbers, sorts them into buckets based off of the digit in a specific index in the number.
	 * @param shapes represents and Array of Shapes
	 */
	public static void radixSort(Shape[] shapes)
	{
		// Creation of the buckets for sorting objects into
		// Creation of the map for referencing buckets 
		Map<Integer, ArrayList<Shape>> numbersMap = new TreeMap<>(Collections.reverseOrder());
		ArrayList<Shape> zero = new ArrayList<> ();
		numbersMap.put(0, zero);
		ArrayList<Shape> one = new ArrayList<> ();
		numbersMap.put(1, one);
		ArrayList<Shape> two = new ArrayList<> ();
		numbersMap.put(2, two);
		ArrayList<Shape> three = new ArrayList<> ();
		numbersMap.put(3, three);
		ArrayList<Shape> four = new ArrayList<> ();
		numbersMap.put(4, four);
		ArrayList<Shape> five = new ArrayList<> ();
		numbersMap.put(5, five);
		ArrayList<Shape> six = new ArrayList<> ();
		numbersMap.put(6, six);
		ArrayList<Shape> seven = new ArrayList<> ();
		numbersMap.put(7, seven);
		ArrayList<Shape> eight = new ArrayList<> ();
		numbersMap.put(8, eight);
		ArrayList<Shape> nine = new ArrayList<> ();
		numbersMap.put(9, nine);

		// maxLen: a variable that holds an int declaring the max length of the variable being compared
		// count: int variable that keeps track of how many iterations of the main loop
		int maxLen = 0;
		int count = 1;

		// loop that checks the maximum length of the compared variable, and assigns the int to maxLen
		for( Shape s : shapes) {
			String height = String.valueOf(s.getHeight());
			if (height.length() > maxLen) {
				maxLen = height.length();
			}
		}

		// index: creates a variable of the index for the position of the least significant digit for the largest length
		int index = maxLen - 1;

			// loop that will continue iterating until it has been processed as many times as the maximum number of digits
    		while(count < maxLen) {
      			int i = 0;
	 			for(Shape s : shapes)
				{
					String height = String.valueOf(s.getHeight());
					Character digit = '0';
					// if statement that checks if the length of the current compared String matches the maximum length
					// if it does, it adjusts the index if necessary based on "." placement
					if (height.length() + count > maxLen && height.length() == maxLen) {
						int adjustedIndex = getAdjustedIndex(height, index);
						digit = height.charAt(adjustedIndex);
					}
					// if statement that checks if the length of the current compared String is less than the maximum length
					// if it is, then it adjusts the index to the correct position, based on length and the "." placement
					if (height.length() + count > maxLen && height.length() < maxLen) {
						int adjustedIndex = index - (maxLen - height.length());
						adjustedIndex = getAdjustedIndex(height, adjustedIndex);
						if(adjustedIndex >= 0 && count <= height.length()) {
							digit = height.charAt(adjustedIndex);
						}
					}
					// if neither if statement applies, the digit index remains 0 as the length of the String is too short
					
					// switch case to sort the object into the proper bucket based on the digit at the desired index
					switch (digit) {
						case '0':
							zero.add(s);
							break;
						case '1':
							one.add(s);
							break;
						case '2':
							two.add(s);
							break;
						case '3':
							three.add(s);
							break;
						case '4':
							four.add(s);
							break;
						case '5':
							five.add(s);
							break;
						case '6':
							six.add(s);
							break;
						case '7':
							seven.add(s);
							break;
						case '8':
							eight.add(s);
							break;
						case '9':
							nine.add(s);
							break;	
					}
					// changes the object at the current index of the Array to null
					shapes[i] = null;
					i++;
					// continues processing until the loop has sorted the each entry
				}

	 		// variable that holds the index for the next position for adding objects back into the Array
			int reAdd = 0;
			
			// loop to process through the dictionary/map, and readd the objects in the new order back into the Array
			for(Map.Entry<Integer, ArrayList<Shape>> entry : numbersMap.entrySet()) {
				ArrayList<Shape> list = entry.getValue();
				
				for(Shape s : list) {
					shapes[reAdd] = s;
					reAdd++;
				}
				// clears the current arrayList so it is fresh for the next iteration 
				list.clear();
			}
			// adds 1 to the count of iterations
			count++;
			// subtracts 1 from the index for the next index location
			index--;
 		}
	}
	
	/**
	 * This method processes through a Radix Sort. It takes a list of numbers, sorts them into buckets based off of the digit in a specific index in the number.
	 * @param shapes Represents a list of shapes being passed into the method
	 * @param c Represents the compare type to be used for the sorting
	 */
	public static void radixSort(Shape[] shapes, Comparator<Shape> c)
	{
		// Creation of the buckets for sorting objects into
		// Creation of the map for referencing buckets 
		Map<Integer, ArrayList<Shape>> numbersMap = new TreeMap<>(Collections.reverseOrder());
		ArrayList<Shape> zero = new ArrayList<> ();
		numbersMap.put(0, zero);
		ArrayList<Shape> one = new ArrayList<> ();
		numbersMap.put(1, one);
		ArrayList<Shape> two = new ArrayList<> ();
		numbersMap.put(2, two);
		ArrayList<Shape> three = new ArrayList<> ();
		numbersMap.put(3, three);
		ArrayList<Shape> four = new ArrayList<> ();
		numbersMap.put(4, four);
		ArrayList<Shape> five = new ArrayList<> ();
		numbersMap.put(5, five);
		ArrayList<Shape> six = new ArrayList<> ();
		numbersMap.put(6, six);
		ArrayList<Shape> seven = new ArrayList<> ();
		numbersMap.put(7, seven);
		ArrayList<Shape> eight = new ArrayList<> ();
		numbersMap.put(8, eight);
		ArrayList<Shape> nine = new ArrayList<> ();
		numbersMap.put(9, nine);

		// maxLen: a variable that holds an int declaring the max length of the variable being compared
		// count: int variable that keeps track of how many iterations of the main loop
		int maxLen = 0;
		int count = 1;

		String className = c.getClass().getName();
		String compType = "";
		if ( className.contains("Volume")) {
			compType = "Volume";
		} else if (className.contains("BaseArea")) {
			compType = "Area";
		}
				
		// loop that checks the maximum length of the compared variable, and assigns the int to maxLen
		for( Shape s : shapes) {
			String value = String.valueOf((s.assignCalc(s, compType)));
			if (value.length() > maxLen) {
				maxLen = value.length();
			}
		}

		// index: creates a variable of the index for the position of the least significant digit for the largest length
		int index = maxLen - 1;

			// loop that will continue iterating until it has been processed as many times as the maximum number of digits
    		while(count < maxLen) {
      			int i = 0;
	 			for(Shape s : shapes)
				{
	 				String value = String.valueOf((s.assignCalc(s, compType)));
					Character digit = '0';
					// if statement that checks if the length of the current compared String matches the maximum length
					// if it does, it adjusts the index if necessary based on "." placement
					if (value.length() == maxLen) {
						int adjustedIndex = getAdjustedIndex(value, index);
						if (adjustedIndex >= 0) {
							digit = value.charAt(adjustedIndex);
						}
					}
					// if statement that checks if the length of the current compared String is less than the maximum length
					// if it is, then it adjusts the index to the correct position, based on length and the "." placement
					if (value.length() < maxLen) {
						int adjustedIndex = index - (maxLen - value.length());
						adjustedIndex = getAdjustedIndex(value, adjustedIndex);
						if(adjustedIndex >= 0 && count <= value.length()) {
							digit = value.charAt(adjustedIndex);
					} 
					// if neither if statement applies, the digit index remains 0 as the length of the String is too short
						
					// switch case to sort the object into the proper bucket based on the digit at the desired index
					switch (digit) {
						case '0':
							zero.add((Shape) s);
							break;
						case '1':
							one.add((Shape) s);
							break;
						case '2':
							two.add((Shape) s);
							break;
						case '3':
							three.add((Shape) s);
							break;
						case '4':
							four.add((Shape) s);
							break;
						case '5':
							five.add((Shape) s);
							break;
						case '6':
							six.add((Shape) s);
							break;
						case '7':
							seven.add((Shape) s);
							break;
						case '8':
							eight.add((Shape) s);
							break;
						case '9':
							nine.add((Shape) s);
							break;	
					}
					// changes the object at the current index of the Array to null
					shapes[i] = null;
					i++;
					// continues processing until the loop has sorted the each entry
					}
				}

	 		// variable that holds the index for the next position for adding objects back into the Array
			int reAdd = 0;
			
			// loop to process through the dictionary/map, and readd the objects in the new order back into the Array
			for(Map.Entry<Integer, ArrayList<Shape>> entry : numbersMap.entrySet()) {
				ArrayList<Shape> list = entry.getValue();
				
				for(Shape s : list) {
					shapes[reAdd] = s;
					reAdd++;
				}
				// clears the current arrayList so it is fresh for the next iteration 
				list.clear();
			}
			// adds 1 to the count of iterations
			count++;
			// subtracts 1 from the index for the next index location
			index--;
 		}
	}
	

	/**
	 * Method adjusts the index passed into it to ignore the "." in the String
	 * @param numStr String being passed into the method 
	 * @param digitIndex Desired index of the String
	 * @return Returns the new index if it has been affected by the "."
	 */
	private static int getAdjustedIndex(String numStr, int digitIndex) {
	    int adjustedIndex = digitIndex; // Start with the original index
	    for (int i = 0; i < numStr.length(); i++) {
	        if (adjustedIndex >= 0) {
	        	if (numStr.charAt(i) == '.' || numStr.charAt(i) == 'E') {
	            // If the current character is a decimal point, and the digitIndex is >= its position,
	            // increment the adjustedIndex to skip the decimal point
	        		if (adjustedIndex <= i) {
	        			adjustedIndex--;
	        		}
	        	}
	        }
	    }
	    // if the adjusted index is positive, then it will confirm that index will not return a . or E
	    if(adjustedIndex >= 0) {
	    	if(numStr.charAt(adjustedIndex) == 'E' || numStr.charAt(adjustedIndex) == '.') {
	    		adjustedIndex--;
	    	}
	    }
	    return adjustedIndex;
	}


}
