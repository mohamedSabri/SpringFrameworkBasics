package com.in28minutes.spring.basics.springin10steps;

public class BinarySearchImpl {

	/**
	 * sort algorithm is a dependency of binary search , so binary search depend on
	 * the sort algorithm. We made the sort algorithm as a separate dependency and
	 * we are passing it in to the binary search. I have to create the instance of
	 * quick sort or bubble sort whenever We create an instance of the binary search.
	 * we want to avoid that using spring framework
	 * 
	 */
	private SortAlgorithm sortAlgorithm;

	public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
		super();
		this.sortAlgorithm = sortAlgorithm;
	}

	public int binarySearch(int[] numbers, int numberToSearchFor) {

		// make binary search loosely coupled. it independent of the sorting algorithm
		// being used (with interface)

		int[] sortedNumbers = sortAlgorithm.sort(numbers);

		System.err.println("sortAlgorithm:" + sortAlgorithm);

		// Search the array

		// Return the Result ( the index of the searched item)

		return 3;
	}
}
