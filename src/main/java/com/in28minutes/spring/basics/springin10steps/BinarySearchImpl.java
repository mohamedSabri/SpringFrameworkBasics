package com.in28minutes.spring.basics.springin10steps;

public class BinarySearchImpl {

	public int binarySearch(int[] numbers, int numberToSearchFor) {
		// Implement Sorting logic
		// Bubble Sort Algorithm --> here BinarySearchImpl is tightly coupled to Bubble
		// Sort i we want to change the sorting algorithm then we need to change in
		// BinarSearchImpl.
		// even if we move the sorting algorithm outside the binary search class in
		// stand alone class we still need to define an instance of it here in
		// BinarySearchImpl the problem of change the sorting algorithm still happens (tight coupling)
		
		BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();
		int[] sortedNumbers = bubbleSortAlgorithm.sort(numbers);
		

		// Search the array

		// Return the Result ( the index of the searched item)

		return 3;
	}
}
