package db;

import constants.CarMake;
import models.*;
import singletons.BookmarkManager;
import singletons.CarManager;
import singletons.UserManager;
import util.InputOutput;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class DataStore {
	public static final int USER_CAR_LIMIT = 2;
	public static final int CAR_INVENTORY = 10;
	public static final int USER_BOOKMARK_LIMIT = 25;
	public static final int BOOKMARK_COUNT_PER_TYPE = 5;
	public static final int BOOKMARK_TYPES_COUNT = 3;
	public static final int TOTAL_USER_COUNT = 5;
	
	public static List<Car> cars = new ArrayList<>();
	public static List<Car> getCars() {

		return cars;
	}

	public static UserCarbuy[]  userCarbuys = new UserCarbuy[USER_CAR_LIMIT * TOTAL_USER_COUNT];
	private static int carIndex;  
	
	private static List<User> users = new ArrayList<>();
	public static  List<User> getUsers() {
		return users;
	}

	protected static List<List<Bookmark>> bookmarks= new ArrayList<>();
	public static List<List<Bookmark>> getBookmarksArray() {
		return bookmarks;
	}
	
	public static UserBookmark[]  userBookmarks = new UserBookmark[USER_BOOKMARK_LIMIT * TOTAL_USER_COUNT];
	public static int bookmarkIndex; // initialized to zero
  
	public static void loadData() throws FileNotFoundException, UnsupportedEncodingException {
		loadUsers();
		loadWeblinks();
		loadMovies();
		loadBooks();
		loadCars();
	}


	private static void loadUsers() throws FileNotFoundException, UnsupportedEncodingException {
//		users[0] = UserManager.getInstance().createUser(500, 1000,	"Smith", "Tom", "user0", "password",  UserType.USER, Gender.MALE, "user0@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net");
//		users[1] = UserManager.getInstance().createUser(501, 1001, "Smith", "Tom", "user1", "password", UserType.USER, Gender.OTHER, "user1@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net");
//		users[2] = UserManager.getInstance().createUser(502, 1002,	"Smith", "Tom", "user2", "password", UserType.EDITOR, Gender.FEMALE, "user2@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net");
//		users[3] = UserManager.getInstance().createUser(503, 1003,	"Smith", "Tom", "user3", "password",   UserType.EDITOR, Gender.OTHER, "user3@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net");
//		users[4] = UserManager.getInstance().createUser(504, 1004,	"Smith", "Tom", "user4", "password",   UserType.CHIEF_EDITOR, Gender.MALE, "user4@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net");
		List<String> data = new ArrayList<>();
		InputOutput.read(data, "src/fileInUsers.txt");
		System.out.println("DATA:::::::\n");
		System.out.println(data.toString());
		int rowNum = 0;
		for (String row : data) {
			String[] values = row.split(",");
			User user = UserManager.getInstance().createUser(Integer.parseInt(values[0]), Long.parseLong(values[1]), values[2], values[3], values[4], values[5], Integer.parseInt(values[6]), Integer.parseInt(values[7]), values[8], values[9], values[10]);
			users.add(user);
		}
	}
	private static void loadWeblinks() throws FileNotFoundException, UnsupportedEncodingException {
//		bookmarks[0][0] = BookmarkManager.getInstance().createWeblink(2000,  "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com" );
//		bookmarks[0][1] = BookmarkManager.getInstance().createWeblink(2001,	  "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com" );
//		bookmarks[0][2] = BookmarkManager.getInstance().createWeblink(2002,	 "https://www.imdb.com/title/tt0120915/","http://www.starwars.com" );
//		bookmarks[0][3] = BookmarkManager.getInstance().createWeblink(2003,	  "http://mindprod.com/jgloss/interfacevsabstract.html", "http://mindprod.com" );
//		bookmarks[0][4] = BookmarkManager.getInstance().createWeblink(2004,	  "http://mindprod.com/jgloss/interfacevsabstract.html", "http://mindprod.com" );
		List<String>  data = new ArrayList<>();
		InputOutput.read(data, "src/fileInWeblinks.txt");
		List<Bookmark> bookmarkList = new ArrayList<>();
		for (String row : data) {
			String[] values = row.split(",");
			Bookmark bookmark = BookmarkManager.getInstance().createWeblink(Long.parseLong(values[0]), values[1],  values[2]);
			bookmarkList.add(bookmark);
		}
		bookmarks.add(bookmarkList);
	}

	private static void loadBooks() throws FileNotFoundException, UnsupportedEncodingException {
//		bookmarks[1][0] = BookmarkManager.getInstance().createBook(4000,"Walden",	1854,	"Wilder Publications", new String[] {"Henry David Thoreau"},	BookGenre.PHILOSOPHY,	4.3  );
//		bookmarks[1][1] = BookmarkManager.getInstance().createBook(4001,"Self-Reliance and Other Essays",	1993,	"Dover Publications", new String[] {"Ralph Waldo Emerson"},	BookGenre.PHILOSOPHY,	4.3  );
//		bookmarks[1][2] = BookmarkManager.getInstance().createBook(4002,"Light From Many Lamps",	1988,	"Touchstone", new String[] {"Lillian Eichler Watson"},	BookGenre.PHILOSOPHY,	5.0  );
//		bookmarks[1][3] = BookmarkManager.getInstance().createBook(4003,"Head First Design Patterns",  2004,	"O'Reilly Media",	new String[] {"Eric Freeman","Bert Bates","Kathy Sierra","Elisabeth Robson"},	BookGenre.FICTION,	4.5 );
//		bookmarks[1][4] = BookmarkManager.getInstance().createBook(4004,"Effective Java Programming Language Guide",  2007,	"Prentice Hall",	new String[] {"Joshua Bloch"},	BookGenre.TECHNICAL,	4.9	 );
		List<String> data = new ArrayList<>();
		InputOutput.read(data, "src/fileInBooks.txt");
		List<Bookmark> bookmarkList = new ArrayList<>();
		for (String row : data) {
			String[] values = row.split(",");
		Bookmark bookmark = BookmarkManager.getInstance().createBook(Long.parseLong(values[0]), values[1], Integer.parseInt(values[2]), values[3], values[4], values[5], Double.parseDouble(values[6]));
			bookmarkList.add(bookmark);
		}
		bookmarks.add(bookmarkList);
	}
	private static void loadMovies() throws FileNotFoundException, UnsupportedEncodingException {
//		bookmarks[2][0] = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", 1941, new String[] {"Orson Welles"," Joseph Cotten"},new String[] {"Orson Welles"}, MovieGenre.CLASSICS, 8.5);
//		bookmarks[2][1] = BookmarkManager.getInstance().createMovie(3001, "The Grapes of Wrath", 1940, new String[] {"Henry Fonda","Jane Darwell"},new String[] {"John Ford"}, MovieGenre.CLASSICS, 8.2);
//		bookmarks[2][2] = BookmarkManager.getInstance().createMovie(3002, "The Big Bang Theory2", 2007, new String[] {"Kaley Cuoco","Jim Parsons"},new String[] {"Chuck Lorre","Bill Prady"}, MovieGenre.FOREIGN_DRAMAS, 8.7 );
//		bookmarks[2][3] = BookmarkManager.getInstance().createMovie(3003, "The Big Bang Theory3", 2002, new String[] {"  Cuoco"," Parsons"},new String[] {"Bill"," Prady"}, MovieGenre.ACTION_AND_ADVENTURE, 7.0 );
//		bookmarks[2][4] = BookmarkManager.getInstance().createMovie(3004, "The Big Bang Theory4", 2002, new String[] {"  Cuoco"," Parsons"},new String[] {"Bill"," Prady"}, MovieGenre.ACTION_AND_ADVENTURE, 7.0 );
		List<String> data = new ArrayList<>();
		InputOutput.read(data, "src/fileInMovies.txt");
		List<Bookmark> bookmarkList = new ArrayList<>();
		for (String row : data) {
			String[] values = row.split(",");
			System.out.println(values.toString());
			System.out.println(values.length);
			Bookmark bookmark = BookmarkManager.getInstance().createMovie(Long.parseLong(values[0]), values[1],  Integer.parseInt(values[2]), values[3], values[4], values[5], Double.parseDouble(values[6]));
			bookmarkList.add(bookmark);
		}
		bookmarks.add( bookmarkList);
	}
	public static void loadCars(){

		Car car1 = CarManager.getInstance().createCar(5000, CarMake.TESLA, "Cyber-Truck", 37000.99, 0);
		Car car2 = CarManager.getInstance().createCar(5001, CarMake.FORD, "Fusion", 23000.99, 0  );
		Car car3  = CarManager.getInstance().createCar(5002, CarMake.JEEP, "Gladiator", 59000.99, 0 );
		Car car4 = CarManager.getInstance().createCar(5003, CarMake.FORD, "Fusion1", 23000.99, 0  );
		Car car5 = CarManager.getInstance().createCar(5004, CarMake.JEEP, "Gladiator", 59000.99, 0 );
		cars.add(car1);
		cars.add(car2);
		cars.add(car3);
		cars.add(car4);
		cars.add(car5);
	};
	public static void add(UserBookmark userBookmark) {
		userBookmarks[bookmarkIndex] = userBookmark;
		bookmarkIndex++;
	}

	public static void add(UserCarbuy userCarbuy) {
		userCarbuys[carIndex] = userCarbuy;
		carIndex++;
	}


}
