package xyz.climongoapp.methods.comparing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
//
//import apps.comparing.CompareThing;

public class Runner {

	public static void main(String[] args) {
		List<CompareThing> cThings = new ArrayList<>();
		cThings.add(new CompareThing("HP", 16,800));
		cThings.add(new CompareThing("Apple", 32,500));
		cThings.add(new CompareThing("Dell", 12,300));
		
		Comparator<CompareThing> comp = new Comparator<CompareThing>() {
			@Override
			public int compare(CompareThing o1, CompareThing o2) {
				if(o1.getPrice() > o2.getPrice()) {
					return 1;
				} else {

					return -1;
				}
								
			 } 
		};
		Collections.sort(cThings); 
		System.out.println("Collections.sort(cThings);  =>CompareThing implements Comparable // compareTo(CompareThing comp) RAM");
		for (CompareThing ct : cThings) {
			System.out.println(ct);
		}
		System.out.println();

		Collections.sort(cThings, comp); 
		System.out.println("Collections.sort(cThings, comp); =>comp = new Comparator	if(o1.getPrice() > o2.getPrice()) {"); 
		for (CompareThing ct2 : cThings) {
			System.out.println(ct2);
		} 
	} 
}
