package utilities;

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
//		int i, j;
//		T temp;
//		boolean swapped;
//		for (i=o)
		
	}

	public static <T> void bubbleSort(T[] shapes, Comparator<T> c)
	{
		// TODO Auto-generated method stub
		
	}

	public static void selectionSort(Shape[] shapes)
	{
		// TODO Auto-generated method stub
		
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

	public static void radixSort(Shape[] shapes)
	{
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

		int maxLen = 0;
		int count = 1;
		
		for( Shape s : shapes) {
			String height = String.valueOf(s.getHeight());
			if (height.length() > maxLen) {
				maxLen = height.length();
			}
		}
		
		int index = maxLen - 1;

    		while(count < maxLen) {
              			int i = 0;
 			for(Shape s : shapes)
			{
				String height = String.valueOf(s.getHeight());
				Character digit = '0';
				if (height.length() + count > maxLen && height.length() == maxLen) {
					int adjustedIndex = getAdjustedIndex(height, index);
					digit = height.charAt(adjustedIndex);
				}
				if (height.length() + count > maxLen && height.length() < maxLen) {
					int adjustedIndex = index - (maxLen - height.length());
					adjustedIndex = getAdjustedIndex(height, adjustedIndex);
					if(adjustedIndex >= 0 && count <= height.length()) {
						digit = height.charAt(adjustedIndex);
					}
				}
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
				shapes[i] = null;
				i++;
			}

			int reAdd = 0;
			
			for(Map.Entry<Integer, ArrayList<Shape>> entry : numbersMap.entrySet()) {
				Integer name = entry.getKey();
				ArrayList<Shape> list = entry.getValue();
				
				for(Shape s : list) {
					shapes[reAdd] = s;
					reAdd++;
				}
				list.clear();
			}
			count++;
			index--;
 		}
	}
	
	public static <T> void radixSort(T[] shapes, Comparator<T> c)
	{
		// TODO Auto-generated method stub
		
	}

	private static int getAdjustedIndex(String numStr, int digitIndex) {
	    int adjustedIndex = digitIndex; // Start with the original index
	    for (int i = 0; i < numStr.length(); i++) {
	        if (numStr.charAt(i) == '.') {
	            // If the current character is a decimal point, and the digitIndex is >= its position,
	            // increment the adjustedIndex to skip the decimal point
	            if (adjustedIndex <= i) {
	                adjustedIndex--;
	            }
	        }
	    }
	    return adjustedIndex;
	}


}
