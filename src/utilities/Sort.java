package utilities;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 * Represents a class containing sort methods
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import shapes.BaseAreaCompare;
import shapes.Shape;
import shapes.VolumeCompare;

public class Sort
{

	/**
	 * This method processes through a Bubble Sort. It takes an array of shapes, and
	 * compares each element with the one next to it. If the latter height is bigger,
	 * they switch positions. A single iteration will place the smallest item in the
	 * last position of the array. Then, we need to keep iterating to place the
	 * smallest unsorted element at the end of the unsorted portion of the array.
	 * @param shapes represents a list of shapes being passed into the method
	 */
	public static <T extends Comparable<Shape>> void bubbleSort(Shape[] shapes)
	{
	        for (int i = 0; i < shapes.length - 1; ++i) {
	            for (int j = 0; j < (shapes.length - 1) - i; ++j) {
	                if (shapes[j].compareTo(shapes[j + 1]) < 0) {
	                    Shape tmp = shapes[j];
	                    shapes[j] = shapes[j + 1];
	                    shapes[j + 1] = tmp;
	                }
	            }
	        }
	}

	/**
	 * This method processes through a Bubble Sort. It takes an array of shapes, and
	 * compares each element with the one next to it. If the latter comparison factor
	 * is bigger, they switch positions. A single iteration will place the smallest item
	 * in the last position of the array. Then, we need to keep iterating to place the
	 * smallest unsorted element at the end of the unsorted portion of the array.
	 * @param shapes represents a list of shapes being passed into the method
	 * @param c represents the compare type to be used for the sorting
	 */
	public static <T> void bubbleSort(Shape[] shapes, Comparator<Shape> c)
	{
	        for (int i = 0; i < shapes.length - 1; ++i) {
	            for (int j = 0; j < (shapes.length - 1) - i; ++j) {
	                if (c.compare(shapes[j], shapes[j + 1]) < 0) {
	                    Shape tmp = shapes[j];
	                    shapes[j] = shapes[j + 1];
	                    shapes[j + 1] = tmp;
	                }
	            }
        	}	
	}

	/**
	 * This method processes through a Selection Sort. It takes an array of shapes, and
	 * finds the item with the biggest height value. We iterate through the array scanning
	 * for an element with a bigger height, and switches them when found. Therefore, after
	 * each iteration the biggest value from the unsorted portion of the array is placed
	 * in the last index of the sorted portion.
 	 * @param shapes represents a list of shapes being passed into the method
	 */
	public static void selectionSort(Shape[] shapes)
	{
	        for (int i = 0; i < shapes.length - 1; ++i) {
	        	Shape max = shapes[i];
	            for (int j = i; j < shapes.length; ++j) {
	            	if (shapes[j].getHeight() > max.getHeight()) {
	            		max = shapes[j];
	            	}
	            if (max.compareTo(shapes[i]) > 0 && (i != j)) {
		            Shape tmp = shapes[i];
		            shapes[i] = shapes[j];
		            shapes[j] = tmp;
	            }        
	            }            
	        }            
	}
	
	/**
	 * This method processes through a Selection Sort. It takes an array of shapes, and
	 * finds the item with the biggest value for the comparator factor. We iterate through
	 * the array scanning for an element with a bigger value, and switches them when found.
	 * Therefore, after each iteration the biggest value from the unsorted portion of the
	 * array is placed in the last index of the sorted portion.
 	 * @param shapes represents a list of shapes being passed into the method
 	 * @param c represents the compare type to be used for the sorting
	 */
	public static <T> void selectionSort(Shape[] shapes, Comparator<Shape> c)
	{		
	        for (int i = 0; i < shapes.length - 1; ++i) {
	        	Shape max = shapes[i];
	            for (int j = i; j < shapes.length; ++j) {
	            	if (shapes[j].calcVolume() > max.calcVolume()) {
	            		max = shapes[j];
	            	}
	            if (c.compare(shapes[i], max) < 0 && (i != j)) {
		            Shape tmp = shapes[i];
		            shapes[i] = shapes[j];
		            shapes[j] = tmp;
	            }        
	            }
	        }         
	}
	
	public static void insertionSort(Shape[] array)
	{
		long start, stop;
		start = System.currentTimeMillis();
		for (int i = 1; i < array.length; i++) {
			Shape key = array[i];
	        int j = i - 1;

            while (j >= 0 && array[j].compareTo(key) < 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
		        stop = System.currentTimeMillis();
		        System.out.println("Insertion Sort run time was: " + (stop - start) + " miliseconds");
    }
	
	public static void insertionSort(Shape[] array, Comparator<Shape> c) {
	    for (int i = 1; i < array.length; i++) {
	        Shape key = array[i]; // Current element to be inserted
	        int j = i - 1; // Index of the last element in the sorted portion

	        // Shift elements greater than `key` to the right
	        while (j >= 0 && c.compare(array[j], key) < 0) {
	            array[j + 1] = array[j];
	            j = j - 1;
	        }

	        // Insert `key` into its correct position
	        array[j + 1] = key;
	    }
	}

	/**
	 * This method processes through a Merge Sort. It takes an array of shapes, breaks
	 * them down into smaller arrays until each contains only one element. Then, it merges
	 * pair of arrays while ordering its elements.
	 * @param shapes represents a list of shapes being passed into the method
	 */
	public static void mergeSort(Shape[] shapes)
	{
		int shapesLength = shapes.length;
		
		if (shapesLength < 2) {
			return;
		}
		
		int midIndex = shapesLength / 2;
		Shape[] leftHalf = new Shape[midIndex];
		Shape[] rightHalf = new Shape[shapesLength - midIndex];
		
		for (int i=0; i < midIndex; i++) {
			leftHalf[i] = shapes[i];
		}
		for (int i = midIndex; i < shapesLength ; i++) {
			rightHalf[i - midIndex] = shapes[i];
		}
		
		mergeSort(leftHalf);
		mergeSort(rightHalf);
		merge(shapes, leftHalf, rightHalf);
	}
	
	/**
	 * This method merges pair of arrays while ordering its elements based on
	 * the height of each element.
	 * @param shapes represents a list of shapes being passed into the method
	 * @param leftHalf represents a list of shapes being passed into the method
	 * @param rightHalf represents a list of shapes being passed into the method
	 */
	public static void merge(Shape[] shapes, Shape[] leftHalf, Shape[] rightHalf) {
		

			int leftSize = leftHalf.length;
			int rightSize = rightHalf.length;
			int i=0, j=0, k=0;
			
			while (i < leftSize && j < rightSize) {
				if (leftHalf[i].compareTo(rightHalf[j]) > 0) {
					shapes[k] = leftHalf[i];
					i++;
				}
				else {
					shapes[k] = rightHalf[j];
					j++;
				}
				k++;
			}
			
			while (i < leftSize)
			{
				shapes[k] = leftHalf[i];
				k++; i++;
			}
				
			while (j < rightSize) {
				shapes[k] = rightHalf[j];
				k++; j++;
			}			 
	}
	
	/**
	 * This method processes through a Merge Sort. It takes an array of shapes, breaks
	 * them down into smaller arrays until each contains only one element. Then, it merges
	 * pair of arrays while ordering its elements. Such sorting process is done according
	 * to the compare type that was entered.
	 * @param shapes represents a list of shapes being passed into the method
	 * @param c represents the compare type to be used for the sorting
	 */
	public static <T> void mergeSort(Shape[] shapes, Comparator<Shape> c)
	{
		int shapesLength = shapes.length;
		
		if (shapesLength < 2) {
			return;
		}
		
		int midIndex = shapesLength / 2;
		Shape[] leftHalf = new Shape[midIndex];
		Shape[] rightHalf = new Shape[shapesLength - midIndex];
		
		for (int i=0; i < midIndex; i++) {
			leftHalf[i] = shapes[i];
		}
		for (int i = midIndex; i < shapesLength ; i++) {
			rightHalf[i - midIndex] = shapes[i];
		}
		
		mergeSort(leftHalf);
		mergeSort(rightHalf);
		merge_c(shapes, leftHalf, rightHalf, c);
	}
	
	/**
	 * This method merges pair of arrays while ordering its elements based of
	 * the value associated to a comparator factor.
	 * @param shapes represents a list of shapes being passed into the method
	 * @param leftHalf represents a list of shapes being passed into the method
	 * @param rightHalf represents a list of shapes being passed into the method
	 */
	public static void merge_c(Shape[] shapes, Shape[] leftHalf, Shape[] rightHalf, Comparator<Shape> c) {

			int leftSize = leftHalf.length;
			int rightSize = rightHalf.length;
			int i=0, j=0, k=0;
			
			while (i < leftSize && j < rightSize) {
				if (c.compare(leftHalf[i], rightHalf[j]) > 0) {
					shapes[k] = leftHalf[i];
					i++;
				}
				else {
					shapes[k] = rightHalf[j];
					j++;
				}
				k++;
			}
			
			while (i < leftSize)
			{
				shapes[k] = leftHalf[i];
				k++; i++;
			}
				
			while (j < rightSize) {
				shapes[k] = rightHalf[j];
				k++; j++;
			}		
	}


	public static void quickSort(Shape[] shapes) {
	    if (shapes == null || shapes.length == 0) {
	        return; // Handle empty or null array
	    }
	    quickSort(shapes, 0, shapes.length - 1);
	}

	private static void quickSort(Shape[] shapes, int low, int high) {
	    if (low < high) {
	        int partitionIndex = partition(shapes, low, high);
	        quickSort(shapes, low, partitionIndex - 1); // Sort left subarray
	        quickSort(shapes, partitionIndex + 1, high); // Sort right subarray
	    }
	}

	private static int partition(Shape[] shapes, int low, int high) {
	    Shape pivot = shapes[high]; // Choose the last element as the pivot
	    int i = low - 1; // Index of the smaller element

	    for (int j = low; j < high; j++) {
	        if (shapes[j].compareTo(pivot) > 0) {
	            i++;
	            // Swap shapes[i] and shapes[j]
	            Shape temp = shapes[i];
	            shapes[i] = shapes[j];
	            shapes[j] = temp;
	        }
	    }

	    // Swap shapes[i + 1] and shapes[high] (pivot)
	    Shape temp = shapes[i + 1];
	    shapes[i + 1] = shapes[high];
	    shapes[high] = temp;

	    return i + 1; // Return the partition index
	}
	
	public static <T> void quickSort(T[] array, Comparator<T> comparator) {
	    if (array == null || array.length == 0) {
	        return;
	    }
	    quickSort(array, 0, array.length - 1, comparator);
	}

	private static <T> void quickSort(T[] array, int low, int high, Comparator<T> comparator) {
	    if (low < high) {
	        int partitionIndex = partition(array, low, high, comparator);
	        quickSort(array, low, partitionIndex - 1, comparator);
	        quickSort(array, partitionIndex + 1, high, comparator);
	    }
	}

	private static <T> int partition(T[] array, int low, int high, Comparator<T> comparator) {
	    T pivot = array[high];
	    int i = low - 1;

	    for (int j = low; j < high; j++) {
	        if (comparator.compare(array[j], pivot) > 0) {
	            i++;
	            T temp = array[i];
	            array[i] = array[j];
	            array[j] = temp;
	        }
	    }

	    T temp = array[i + 1];
	    array[i + 1] = array[high];
	    array[high] = temp;

	    return i + 1;
	}
	/**
	 * This method processes through a Radix Sort. It takes a list of numbers, sorts them into buckets based off of the digit in a specific index in the number.
	 * @param shapes represents and Array of Shapes
	 */
	public static void radixSort(Shape[] shapes) {
	    // Creation of the buckets for sorting objects into
	    Map<Integer, ArrayList<Shape>> numbersMap = new TreeMap<>(Collections.reverseOrder());
	    ArrayList<Shape> zero = new ArrayList<>();
	    numbersMap.put(0, zero);
	    ArrayList<Shape> one = new ArrayList<>();
	    numbersMap.put(1, one);
	    ArrayList<Shape> two = new ArrayList<>();
	    numbersMap.put(2, two);
	    ArrayList<Shape> three = new ArrayList<>();
	    numbersMap.put(3, three);
	    ArrayList<Shape> four = new ArrayList<>();
	    numbersMap.put(4, four);
	    ArrayList<Shape> five = new ArrayList<>();
	    numbersMap.put(5, five);
	    ArrayList<Shape> six = new ArrayList<>();
	    numbersMap.put(6, six);
	    ArrayList<Shape> seven = new ArrayList<>();
	    numbersMap.put(7, seven);
	    ArrayList<Shape> eight = new ArrayList<>();
	    numbersMap.put(8, eight);
	    ArrayList<Shape> nine = new ArrayList<>();
	    numbersMap.put(9, nine);

	    // maxLen: a variable that holds an int declaring the max length of the variable being compared
	    // count: int variable that keeps track of how many iterations of the main loop
	    int maxLen = 0;
	    int count = 1;

	    // loop that checks the maximum length of the compared variable, and assigns the int to maxLen
	    for (Shape s : shapes) {
	        String height = String.valueOf(s.getHeight());
	        if (height.length() > maxLen) {
	            maxLen = height.length();
	        }
	    }

	    // index: creates a variable of the index for the position of the least significant digit for the largest length
	    int index = maxLen - 1;

	    // loop that will continue iterating until it has been processed as many times as the maximum number of digits
	    while (count < maxLen) {
	        // Clear all buckets before each iteration
	        for (ArrayList<Shape> bucket : numbersMap.values()) {
	            bucket.clear();
	        }

	        // Add shapes to buckets based on the current digit
	        for (Shape s : shapes) {
	            String height = String.valueOf(s.getHeight());
	            Character digit = '0'; // Default digit

	            // Adjust index to handle numbers with fewer digits
	            int adjustedIndex = index - (maxLen - height.length());
	            adjustedIndex = getAdjustedIndex(height, adjustedIndex);

	            // If the adjusted index is valid, get the digit
	            if (adjustedIndex >= 0 && adjustedIndex < height.length()) {
	                digit = height.charAt(adjustedIndex);
	            }

	            // Add the shape to the correct bucket
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
	        }

	        // Re-add shapes from buckets back to the shapes array
	        int reAdd = 0;
	        for (Map.Entry<Integer, ArrayList<Shape>> entry : numbersMap.entrySet()) {
	            ArrayList<Shape> list = entry.getValue();
	            for (Shape s : list) {
	                shapes[reAdd++] = s;
	            }
	        }

	        // Debugging: Print the number of shapes in each bucket
//	        System.out.println("Iteration " + count + ":");
//	        for (Map.Entry<Integer, ArrayList<Shape>> entry : numbersMap.entrySet()) {
//	            System.out.println("Bucket " + entry.getKey() + ": " + entry.getValue().size() + " shapes");
//	        }

	        // Increment count and adjust index
	        count++;
	        index--;
	    }
	}	
	/**
	 * This method processes through a Radix Sort. It takes a list of numbers, sorts them into buckets based off of the digit in a specific index in the number.
	 * @param shapes Represents a list of shapes being passed into the method
	 * @param c Represents the compare type to be used for the sorting
	 */
	public static void radixSort(Shape[] shapes, Comparator<Shape> c) {
	    // Creation of the buckets for sorting objects into
	    Map<Integer, ArrayList<Shape>> numbersMap = new TreeMap<>(Collections.reverseOrder());
	    ArrayList<Shape> zero = new ArrayList<>();
	    numbersMap.put(0, zero);
	    ArrayList<Shape> one = new ArrayList<>();
	    numbersMap.put(1, one);
	    ArrayList<Shape> two = new ArrayList<>();
	    numbersMap.put(2, two);
	    ArrayList<Shape> three = new ArrayList<>();
	    numbersMap.put(3, three);
	    ArrayList<Shape> four = new ArrayList<>();
	    numbersMap.put(4, four);
	    ArrayList<Shape> five = new ArrayList<>();
	    numbersMap.put(5, five);
	    ArrayList<Shape> six = new ArrayList<>();
	    numbersMap.put(6, six);
	    ArrayList<Shape> seven = new ArrayList<>();
	    numbersMap.put(7, seven);
	    ArrayList<Shape> eight = new ArrayList<>();
	    numbersMap.put(8, eight);
	    ArrayList<Shape> nine = new ArrayList<>();
	    numbersMap.put(9, nine);

	    // maxLen: a variable that holds an int declaring the max length of the variable being compared
	    // count: int variable that keeps track of how many iterations of the main loop
	    int maxLen = 0;
	    int count = 1;

	    String className = c.getClass().getName();
	    String compType = "";
	    if (className.contains("Volume")) {
	        compType = "Volume";
	    } else if (className.contains("BaseArea")) {
	        compType = "Area";
	    }

	    // loop that checks the maximum length of the compared variable, and assigns the int to maxLen
	    for (Shape s : shapes) {
	        String value = String.valueOf((s.assignCalc(s, compType)));
	        if (value.length() > maxLen) {
	            maxLen = value.length();
	        }
	    }

	    // index: creates a variable of the index for the position of the least significant digit for the largest length
	    int index = maxLen - 1;

	    // loop that will continue iterating until it has been processed as many times as the maximum number of digits
	    while (count < maxLen) {
	        // Clear all buckets before each iteration
	        for (ArrayList<Shape> bucket : numbersMap.values()) {
	            bucket.clear();
	        }

	        // Add shapes to buckets based on the current digit
	        for (Shape s : shapes) {
	            String value = String.valueOf((s.assignCalc(s, compType)));
	            Character digit = '0'; // Default digit

	            // Adjust index to handle numbers with fewer digits
	            int adjustedIndex = index - (maxLen - value.length());
	            adjustedIndex = getAdjustedIndex(value, adjustedIndex);

	            // If the adjusted index is valid, get the digit
	            if (adjustedIndex >= 0 && adjustedIndex < value.length()) {
	                digit = value.charAt(adjustedIndex);
	            }

	            // Add the shape to the correct bucket
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
	        }

	        // Re-add shapes from buckets back to the shapes array
	        int reAdd = 0;
	        for (Map.Entry<Integer, ArrayList<Shape>> entry : numbersMap.entrySet()) {
	            ArrayList<Shape> bucket = entry.getValue();
	            for (Shape s : bucket) {
	                shapes[reAdd++] = s;
	            }
	        }

	        // Debugging: Print the number of shapes in each bucket
//	        System.out.println("Iteration " + count + ":");
//	        for (Map.Entry<Integer, ArrayList<Shape>> entry : numbersMap.entrySet()) {
//	            System.out.println("Bucket " + entry.getKey() + ": " + entry.getValue().size() + " shapes");
//	        }

	        // Increment count and adjust index
	        count++;
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

	public static String timeTracker(Shape[] shapes, String methodName, Comparator<Shape> comparator) {
        long start, stop;
        long elapsedTime = 0;

        try {
            // Get the method using reflection
            Method method;
            if (comparator == null) {
                // Get the method without Comparator parameter
                method = Sort.class.getMethod(methodName, Shape[].class);
            } else {
                // Get the method with Comparator parameter
                method = Sort.class.getMethod(methodName, Shape[].class, Comparator.class);
            }

            // Start the timer
            start = System.currentTimeMillis();

            // Invoke the method dynamically
            if (comparator == null) {
                method.invoke(null, (Object) shapes); // Call method without Comparator
            } else {
                method.invoke(null, shapes, comparator); // Call method with Comparator
            }

            // Stop the timer
            stop = System.currentTimeMillis();

            // Calculate elapsed time
            elapsedTime = stop - start;

            // Print the result
        } catch (NoSuchMethodException e) {
            System.err.println("Method '" + methodName + "' not found.");
        } catch (IllegalAccessException e) {
            System.err.println("Cannot access method '" + methodName + "'.");
        } catch (InvocationTargetException e) {
            System.err.println("Exception occurred while executing method '" + methodName + "': " + e.getCause());
        }

        // Return the elapsed time (optional)
        return methodName + " run time was: " + elapsedTime + " milliseconds";
    }
}
