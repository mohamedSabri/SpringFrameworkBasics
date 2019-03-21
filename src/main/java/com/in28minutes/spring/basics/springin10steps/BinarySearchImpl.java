package com.in28minutes.spring.basics.springin10steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {

	/**
	 * sort algorithm is a dependency of binary search , so binary search depend on
	 * the sort algorithm. We made the sort algorithm as a separate dependency and
	 * we are passing it in to the binary search. I have to create the instance of
	 * quick sort or bubble sort whenever We create an instance of the binary
	 * search. we want to avoid that using spring framework
	 * 
	 */
	@Autowired
	private SortAlgorithm sortAlgorithm;

	/**
	 * Constructor injection and setter injection.
	 * 
	 * So how do you choose between constructor and setter injection?
	 * 
	 * There's not a great deal of difference in using setter and constructor
	 * injection.
	 * 
	 * That was a recommendation with the earlier versions of Spring but with at
	 * autowired, what happens is even though you're using setter injection, if a
	 * bean of at auto wired is not found, so let's say you put @autowired and you
	 * don't have any bean of sort algorithm present in the class path.Then what
	 * would happen? The context will not launch at all. So there is no difference
	 * ,but the number of arguments of the constructor will increase if there is a
	 * lot of dependencies.
	 * 
	 * In the earlier version of Spring, what we used to suggest to do is all
	 * mandatory dependencies should be autowired using constructor.
	 * 
	 * 
	 * For example,without Sort algorithm the binary search cannot work at all. So
	 * this is a mandatory dependency. If there is a dependency which it can work
	 * without, so if some dependencies are not available and still the class can
	 * run, those dependencies are optional dependencies.
	 * 
	 * 
	 * So if you have mandatory dependencies then the recommendation was to use
	 * constructor injection. For all other dependencies the recommendation was to
	 * use setter injection.So if it's optional dependency, go for setter injection.
	 * Otherwise use setter injection.
	 * 
	 * now actually there is not a lot of difference in terms of mandatory or
	 * optional dependences.
	 * 
	 * The lines have really really become thin between constructor and setter
	 * injections.
	 * 
	 * 
	 * @param sortAlgorithm
	 */

//	public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
//		super();
//		this.sortAlgorithm = sortAlgorithm;
//	}

	public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
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
