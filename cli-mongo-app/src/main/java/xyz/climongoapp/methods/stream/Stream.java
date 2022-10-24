package xyz.climongoapp.methods.stream;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Stream {
	
	public static void main(String[] args) {
		Blog b = new Blog();
		b.set_Id(11234L);
		b.setRatings(1.0);
		b.setReadings(13.0);
		b.setTitle("new title0");
		
		Blog b1 = new Blog();
		b1.set_Id(231234L);
		b1.setRatings(1.10);
		b1.setReadings(33.0);
		b1.setTitle("new title1");
		
		Blog b2 = new Blog();
		b2.set_Id(312234L);
		b2.setRatings(2.20);
		b2.setReadings(55.0);
		b2.setTitle("new title2");

		Blog b3 = new Blog();
		b3.set_Id(412342L);
		b3.setRatings(0.20);
		b3.setReadings(23.0);
		b3.setTitle("new title3");
		
		List ls = new ArrayList();
		ls.add(b1);
		ls.add(b);
		ls.add(b3);
		ls.add(b2);
		Blog.slice(ls);
		
		Blog.collectToMap(ls);
		Blog.mutableReduction();
	}
	static class Blog {
		private long _id;
		private String id;
		private String cat3;
		private String post;
		private String blogcite; 
		private String author;
		private String title;
		private String did;

		private double rating; 
		private double readings;
		private String _date; 
	 
		///////////////////////////// Reduce numerical
		private static void reduce(List<Blog> blogs) {
			System.out.println("\nReduce ...");
		blogs.stream()
		.filter( b -> b.getRating() >=4.5)
		.reduce((b1,b2) -> b1.getReadings() <= b2.getReadings() ? b1 : b2)
		.ifPresent(b -> System.out.println("lowest readership: "+ b));
		}
		public void set_Id(long _id) {
			this._id = _id;
			
		}
		public void setReadings(double d) {
			// TODO Auto-generated method stub
			
		}
		public void setTitle(String title) {
			this.title = title;
			
		}
		/////////////// StringBuilder Append
		private static void overloadedReduction() {
			String[] letters = {"a","b","c"};
			String concat1 = Arrays.stream(letters)
					.reduce("", (s1,s2) -> s1+s2);
			System.out.println("String concat slow"+ concat1);
			
			StringBuilder append1 = Arrays.stream(letters)
					.reduce(new StringBuilder(), (sb,s) -> sb.append(s), (sb1,sb2) -> sb1.append(sb2));
			System.out.println("StringBuilder Append"+ append1);
			
		}
		/////// findAny
//		 Print at most 5 DISTINCT blogs with rating >= 4.5
//		 DB world: select distinct (_id) from blog where rating >= 4.5 limit 0, 5;
		private static void slice(List<Blog> blogs) {
			System.out.println("\nSlice ... ");
			 List<String> result = blogs.stream()
				.filter(d -> d.getRating() >1.5)
				.distinct()
				//.peek(d -> System.out.println(d.getTitle() + " " + d.getRating()))
				.limit(5)  
				  //.skip(5)
				.map(d -> d.getTitle()) 
//				.forEach(System.out::println);
				.collect(Collectors.toList());
			System.out.println(result);
			for(String title : result){
				System.out.println("title: " + title );
				}; 
			} 
		 // mutable reduction => Supplier + accumulator + Combinor
		// if accumulator mutates, use collect(). Otherwise,  reduce()
		  static void mutableReduction() {
			System.out.println("\nmutableReduction ... ");
			String[] elems = {"A", "A", "B"};
			
			StringBuilder concat2 = Arrays.stream(elems).parallel()
					.collect(() -> new StringBuilder(),   
							(sb, s) -> sb.append(s),   /// Accumulator
							(sb1, sb2) -> sb1.append(sb2));  /// Combinor
			System.out.println("concat2: " + concat2);
			
			String concatWithJoining = Arrays.stream(elems).parallel()
					.collect(Collectors.joining());
			System.out.println("concatWithJoining: " + concatWithJoining); 
		  }
		  
		  // GROUPING
		  private static void collectToMap(List<Blog> blogs) {
				System.out.println("\nIn collectToMap ...");
				Map<Long, Blog> map = blogs.stream()
//					.collect(Collectors.toMap(b -> b.get_Id(), b -> b));
					.collect(Collectors.toMap(b -> b.get_Id(), b -> b, (b1, b2) -> b1.getReadings() <= b2.getReadings() ? b1 : b2));
				for (Entry<Long, Blog> entry : map.entrySet()) {
					System.out.println("_id: " + entry.getKey() + ", blog: " + entry.getValue());
				}
				
				System.out.println(map instanceof HashMap);
				
				Map<Long, Blog> treeMap = blogs.stream()
						.collect(Collectors.toMap(b -> b.get_Id(), b -> b));
//						.collect(Collectors.toMap(Blog::get_Id, Function.identity(), (b1, b2) -> ((Blog) b1).getReadings() <= b2.getReadings() ? b1 : b2, () -> new TreeMap()));
					for (Entry<Long, Blog> entry : treeMap.entrySet()) {
						System.out.println("_id: " + entry.getKey() + ", blog: " + entry.getValue());
					}
				
					/*Map<Double, List<Blog>> ratingsMap = treeMap.values().stream()
						.collect(Collectors.toMap(Blog::getRating, b -> Collections.singletonList(b), (l1, l2) -> { ArrayList<Blog> l = new ArrayList<>(l1);
																						l.addAll(l2);
																						return l;}));
					for (Entry<Double, List<Blog>> entry : ratingsMap.entrySet()) {
						System.out.println("\nRating: " + entry.getKey());
						for (Blog b : entry.getValue()) {
							System.out.println(b);
						}
					}*/
					
					Map<Double, List<Blog>> ratingsMap1 = treeMap.values().stream()
							.collect(Collectors.groupingBy(Blog::getRating));
					for (Entry<Double, List<Blog>> entry : ratingsMap1.entrySet()) {
						System.out.println("\nRating: " + entry.getKey());
						for (Blog b : entry.getValue()) {
							System.out.println(b);
						}
					}
			}
			
		/////////////////////////////////////////////////////////
		public Blog(long _id, String id, String _date, String cat3, String post, String blogcite, String author,
				String title, String did, double rating, double readings ) {
			super();
			this._id = _id;
			this.id = id;
			this._date = _date;
			this.cat3 = cat3;
			this.post = post;
			this.blogcite = blogcite;
			this.author = author;
			this.title = title;
			this.did = did;
			this.rating = rating;
			this.readings = readings; 
		}
		public Blog() {
			// TODO Auto-generated constructor stub
		}
		public Long get_Id() {
			return _id;
		} 
		public String getId() {
			return id;
		} 
		public String getDate() {
			return _date;
		} 
		public String getCat3() {
			return cat3;
		} 
		public String getPost() {
			return post;
		} 
		public String getBlogcite() {
			return blogcite;
		} 
		public String getAuthor() {
			return author;
		} 
		public String getTitle() {
			return title;
		} 
		public String getDid() {
			return did;
		} 
		public double getRating() {
			return rating;
		}

		public void setRatings(double d) {
		this.rating = d;
			
		}
		public double getReadings() {
			return readings;
		}  
		 
		@Override
		public int hashCode() {
			return Objects.hash(_id);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			Blog other = (Blog) obj;
			return _id == other._id;
		}
		@Override
		public String toString() {
			return "Blog [_id=" + _id + ", id=" + id + ", cat3=" + cat3 + ", post=" + post + ", blogcite=" + blogcite
					+ ", author=" + author + ", title=" + title + ", did=" + did + ", rating=" + rating + ", readings="
					+ readings + "]";
		}
		
	 
		
	}
}
