# Assignment 1 - Shape Sorting Application

## Overview
The Shape Sorting Application is a Java console application that reads a list of shapes from a text file,
processes the data, and outputs the results to the console.

The application supports the following shapes:
Cone
Cylinder
Prisms: Octagonal Prism, Pentagonal Prism, Square Prism, Triangular Prism
Pyramid

The list of shapes is read from a pre-formatted text file. The first line indicates the total number of shapes,
and each subsequent line represents a shape with its dimensions as height and side length or radius.
The list of shapes is then processed and sorted based on a chosen metric (height, volume or area) in descending order.
The sorting algorithm can be one of: Bubble, Insertion, Merge, Quick, Radix, or Selection sort.
The sorted list of shapes is then output to the console indicating each 1000th element including first and last.
The processing time of the sorting algorithm is then displayed in milliseconds.

## Features
- Read data from a text file
- Process and manipulate data
- Output results to the console

## Requirements
- Java Development Kit (JDK) 8 or higher

## Execution
The program is run via command line arguments.
-f[filename]
-t[sort type: "
