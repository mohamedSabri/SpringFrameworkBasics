package com.in28minutes.spring.basics.springin10steps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 
 * @author Mohamed Sabri
 *
 */
@SpringBootApplication
public class SpringIn10StepsApplication {

	public static void main(String[] args) {

		/**
		 * We made the binary search loosely coupled by passing the sort algorithm to
		 * use as one of the constructor Arguments. It would be great actually if some
		 * framework can take control of creation of the beans and the Dependencies. We
		 * have one bean And one dependency.
		 * 
		 * What we are calling as a bean is an instance of the object so this is a bean
		 * when I'm creating a new quicksort algorithm that’s a bean.
		 * 
		 * So we would want to be able to create beans and we would want to be able to
		 * wire in the dependencies. So we want to be able to create new quicksort
		 * algorithm and wire it in into the binary search Impl. That's called wiring.
		 * 
		 * The Spring Framework helps us to manage beans and wiring in the dependencies.
		 * 
		 * To be able to make best use of Spring we would need to tell it three
		 * different things.
		 * 
		 * // what are the beans? What are the different beans that Spring has to
		 * manage.How do I tell that? The way you tell that to Spring is by adding an
		 * annotation called at component.we want BinarySearchImpl and
		 * BubbleSortAlgorithm to be beans and managed by spring so we will put
		 * the @component to them.
		 * 
		 * // what are the dependencies for a bean? we need to be able to tell Spring
		 * that sort algorithm is a dependency of binary search.How do I tell Spring
		 * that this is a dependency?The way I would do that is by adding something
		 * called at autowired.So I'm adding an at @Autowired annotation on the sort
		 * algorithm instance which I declared in the BinarySearchImpl class.Now I'm
		 * telling that binary search Impl depends on sort algorithm.Sort algorithm is a
		 * dependency for binary search.
		 * 
		 * 
		 * // where to search for beans? should I search in this package or should I
		 * search it in another package? The way I would do that is by
		 * adding @ComponentScan annotation to the main class (the class that have the
		 * main method o your application) and give it the property basePackages to list
		 * all the packages you want spring to search in (spring search in the base
		 * package and its sub packages).
		 * 
		 * Spring Boot main class uses @SpringBootApplication annotation which
		 * uses @ComponentScan annotation to search in its default base package. Spring
		 * Boot would automatically scan the package where the main application class is
		 * present.
		 */

		/**
		 * So Spring framework is going to create a lot of beans for us. Where are all
		 * these beans going to be present? where would all these beans be managed?
		 * These would all be managed by something called application context. Spring
		 * application context is the one which would maintain all the beans.
		 * 
		 * From the application context I would now want to get the BinarySearchImpl
		 * bean. we got an application context by running the Spring Boot application
		 * class using the Spring application class.
		 * 
		 * Spring manages the dependencies, injects the dependencies where ever they are
		 * needed and it manages the entire life cycle of these beans.That's what is
		 * called dependency management.
		 * 
		 * 
		 * now algorithm being used is bubble sort ,So how do I change it to use
		 * QuickStart. And how can I do that dynamically?
		 * 
		 * if we put @component for QuickSortAlgorithm class so when spring try to
		 * create bean from SortAlgorithm it will find two beans that can be of type
		 * SortAlgorithm so spring will throw exception of type
		 * NoUniqueBeanDefinitionException and says that "expected single matching bean
		 * but found 2: bubbleSortAlgorithm,quickSortAlgorithm" to solve this you need
		 * to use @primary annotation to give priority to the important Bean you want to
		 * create first.
		 * 
		 * If you have more than one component matching a specific type. You can use
		 * 
		 * @primary with @component to give more importance to one of those components.
		 */

		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringIn10StepsApplication.class,
				args);
		BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);

//		BinarySearchImpl binarySearch = new BinarySearchImpl(new QuickSortAlgorithm());
//		BinarySearchImpl binarySearch = new BinarySearchImpl(new BubbleSortAlgorithm());
		int result = binarySearch.binarySearch(new int[] { 12, 4, 6 }, 3);
		System.err.println("result:" + result);

	}

}
