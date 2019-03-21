package com.in28minutes.spring.basics.springin10steps;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class QuickSortAlgorithm  implements SortAlgorithm{

	public int [] sort(int[] numbers) {
		//logic for quick sort 
		return numbers;
	}
}
