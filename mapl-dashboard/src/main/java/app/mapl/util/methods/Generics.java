package app.mapl.util.methods;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Generics {
	
	// One Generic type
	public <T> List<T> fromArrayToList(T[] a) {   
	    return Arrays.stream(a).collect(Collectors.toList());
	}
	
	// Two Generic types
	public static <T, G> List<G> fromArrayToList(T[] a, Function<T, G> mapperFunction) {
	    return Arrays.stream(a)
	      .map(mapperFunction)
	      .collect(Collectors.toList());
	}
//	passing a function that converts an array with the elements of type T to list with elements of type G.
//	An example would be to convert Integer to its String representation:
	
//	@Test
//	public void givenArrayOfIntegers_thanListOfStringReturnedOK() {
//	    Integer[] intArray = {1, 2, 3 };
//	    List<String> stringList
//	      = Generics.fromArrayToList(intArray, Object::toString);
//
//		assertEquals(stringList, hasItems("1", "2", "3" ));
//	}

	private Object hasItems(String string, String string2, String string3) {
		return null;
	}
}
