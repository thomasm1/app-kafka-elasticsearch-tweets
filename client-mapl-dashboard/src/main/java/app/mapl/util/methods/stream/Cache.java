package app.mapl.util.methods.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

interface CacheIterator {
	boolean hasNext();
	Bookmark next();
}

abstract class Test {
	abstract void apply();
}
///////////////// public class ///////////////////////
public class Cache { 
	private Bookmark[] items;
	private int next = 0; 

	public Cache(int size) {  //CCC
		items = new Bookmark[size];
	} 
	public void add(Bookmark item) {
		if(next < items.length)
			items[next++] = item;
	}  
	public CacheIterator iterator() {
		return new MyCacheIterator();   /// Chaining new
	} 

	private class MyCacheIterator implements CacheIterator {   // NESTED
		private int i = 0; 
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i < items.length;
		} 
		@Override
		public Bookmark next() {
			// TODO Auto-generated method stub
			return items[i++];
		} 
	} 

	public static void cache(String[] args) {
		Cache recommendedItems = new Cache(3);

		Bookmark item1 = new Bookmark();
		item1.setId(2000);
		item1.setTitle("Title_1");
		item1.setRating(1.0);

		Bookmark item2 = new Bookmark();
		item2.setId(2001);
		item2.setTitle("Title_2");
		item2.setRating(2.0);

		Bookmark item3 = new Bookmark();
		item3.setId(2002);
		item3.setTitle("Title_3");
		item3.setRating(3.0);

		recommendedItems.add(item1);
		recommendedItems.add(item2);
		recommendedItems.add(item3); 

		CacheIterator iterator = recommendedItems.iterator();  // new MyCacheIterator()
		while(iterator.hasNext()) {
			System.out.println(iterator.next().getTitle());
		}

		Arrays.sort(recommendedItems.items, new Comparator<Bookmark>() {
			@Override
			public int compare(Bookmark o1, Bookmark o2) {
				return o1.getRating() < o2.getRating() ? 1 : -1;
			}
		});
		
		System.out.println("\nSorted by rating [with anonymous class]");
		iterator = recommendedItems.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next().getTitle());
		}
		////// Lambda
		Arrays.sort(recommendedItems.items, (o1,o2) -> // new Comparator<Bookmark>() {
			new Integer(o1.getTitle().length()).compareTo(new Integer(o2.getTitle().length())) 
//			@Override
//			public int compare(Bookmark o1, Bookmark o2) {
//				return o1.getRating() < o2.getRating() ? 1 : -1;
//			}
//		}
	);
		System.out.println("\nSorted by length [with lambda]");
	}
		
	/////////////////////////////////////////////////////////
	int globalInt = 0;
	public void go(Test test) {
		test.apply();
		
		int count = 0;
		
		List<Integer> trick = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			new Thread(() -> System.out.println(globalInt++)).start();
			
			new Thread(() -> {
				trick.add(count);
				int temp = trick.get(0);
				trick.set(0, temp++);
			}).start();
			
			new Thread(new Runnable() {
				public void run() {
					int count = 2;
				}
			}).start();
		}
	} 
}

 class Bookmark {
	private long id;
	private String title;
	private double rating;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	
}



