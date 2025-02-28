# Assignment 1 - Shape Sorting Application

## Overview
The Shape Sorting Application is a Java console application that reads a list of shapes from a text file,
processes the data, and outputs the results to the console.

The application supports the following shapes:
###Cone
###Cylinder
###Prisms: Octagonal Prism, Pentagonal Prism, Square Prism, Triangular Prism
###Pyramid

The list of shapes is read from a pre-formatted text file. The first line indicates the total number of shapes,
and each subsequent line represents a shape with its dimensions as height and side length or radius.
The list of shapes is then processed and sorted based on a chosen metric (height, volume or area) in descending order.
The sorting algorithm can be one of: Bubble, Insertion, Merge, Quick, Radix, or Selection sort.
The sorted list of shapes is then output to the console indicating each 1000th element including first and last.
The processing time of the sorting algorithm is then displayed in milliseconds.

## Features
### Read data from a text file.
### Create a list of three-dimensional geometric shape objects from the text file.
### Sort the list based on the selected algorithm option and comparison factor.
### Output the ordered list of elements to the console.
### Output the processing time (milliseconds) to sort the list.

## Requirements
### Java Development Kit (JDK) 8 or higher.

## Syntax of Execution
The Java program is run via the command line according to the following structure:
###java -jar Sort.jar -t[OPTION] -s[OPTION] -f[FILE_PATH]

### Mandatory argument description:
#### -f: Specifies the file path that contains the elements to be sorted.
#### -t: Specifies the sorting algorithm to be performed.
##### -t [ v ]: sorts based on volume.
##### -t [ h ]: sorts based on height.
##### -t [ b ]: sorts based on base area.
#### -s: Specifies the sorting algorithm to be performed.
##### -s [ b ]: sorts using the bubble sort algorithm.
##### -s [ s ]: sorts using the selection sort algorithm.
##### -s [ i ]: sorts using the insertion sort algorithm.
##### -s [ r ]: sorts using the radix sort algorithm.
##### -s [ m ]: sorts using the merge sort algorithm.
##### -s [ q ]: sorts using the quick sort algorithm.


