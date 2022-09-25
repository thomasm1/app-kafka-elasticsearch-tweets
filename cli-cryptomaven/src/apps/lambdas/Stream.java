package apps.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional; 

public class Stream {
	
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
		// Print at most 5 DISTINCT blogs with rating >= 4.5
		// DB world: select distinct (_id) from blog where rating >= 4.5 limit 0, 5;
//		private static void slice(List<Blog> blogs) {
//			System.out.println("\nSlice ... ");
//			/*List<String> result = blogs.stream()
//				.filter(d -> d.getRating() >= 4.5)
//				.distinct()
//				//.peek(d -> System.out.println(d.getTitle() + " " + d.getRating()))
//				.limit(5)
//				//.skip(5)
//				.map(d -> d.getTitle())
//				//.forEach(System.out::println);
//				.collect(Collectors.toList());
//			
//			for(String title : result)
//				System.out.println("title: " + title);*/
//			
//			Stream<Blog> blogsStream = blogs.stream()
//			.filter(d -> d.getRating() >= 4.5)
//			.distinct()
//			//.peek(d -> System.out.println(d.getTitle() + " " + d.getRating()))
//			.limit(5);
//			
//			Stream<String> titleStream = blogsStream.map(d -> d.getTitle());
//			titleStream.forEach(System.out::println);
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
