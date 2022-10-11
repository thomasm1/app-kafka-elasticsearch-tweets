package db;

import constants.BookGenre;
import constants.CarMake;
import constants.Gender;
import constants.MovieGenre;
import constants.UserType;
import models.Bookmark;
import models.Car;
import models.User;
import models.UserBookmark;
import models.UserCarbuy;
import singletons.BookmarkManager;
import singletons.CarManager;
import singletons.UserManager;

public class DataStore {
	public static final int USER_CAR_LIMIT = 2;
	public static final int CAR_INVENTORY = 10;
	public static final int USER_BOOKMARK_LIMIT = 5;
	public static final int BOOKMARK_COUNT_PER_TYPE = 5;
	public static final int BOOKMARK_TYPES_COUNT = 3;
	public static final int TOTAL_USER_COUNT = 5;
	
	private static Car[] cars = new Car[CAR_INVENTORY];
	public static Car[] getCars() {
		return cars;
	} 

	private static UserCarbuy[]  userCarbuys = new UserCarbuy[USER_CAR_LIMIT * TOTAL_USER_COUNT];
	private static int carIndex;  
	
	private static User[] users = new User[TOTAL_USER_COUNT];
	public static User[] getUsers() {
		return users;
	}
	
	private static Bookmark[][] bookmarks= new Bookmark[BOOKMARK_TYPES_COUNT][BOOKMARK_COUNT_PER_TYPE];
	public static Bookmark[][] getBookmarks() {
		return bookmarks;
	}
	
	private static UserBookmark[]  userBookmarks = new UserBookmark[USER_BOOKMARK_LIMIT * TOTAL_USER_COUNT];
	private static int bookmarkIndex; // initialized to zero
  
	public static void loadData() {
		loadUsers();
		loadWeblinks();
		loadMovies();
		loadBooks();
		loadCars();
	}
	private static void loadUsers() {
		users[0] = UserManager.getInstance().createUser(500, 1000,	"Smith", "Tom", "user0", "password",  UserType.USER, Gender.MALE, "user0@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net");
		users[1] = UserManager.getInstance().createUser(501, 1001, "Smith", "Tom", "user1", "password", UserType.USER, Gender.OTHER, "user1@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net");
		users[2] = UserManager.getInstance().createUser(502, 1002,	"Smith", "Tom", "user2", "password", UserType.EDITOR, Gender.FEMALE, "user2@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net");
		users[3] = UserManager.getInstance().createUser(503, 1003,	"Smith", "Tom", "user3", "password",   UserType.EDITOR, Gender.OTHER, "user3@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net");
		users[4] = UserManager.getInstance().createUser(504, 1004,	"Smith", "Tom", "user4", "password",   UserType.CHIEF_EDITOR, Gender.MALE, "user4@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net");
	}
	private static void loadWeblinks() { 
		bookmarks[0][0] = BookmarkManager.getInstance().createWeblink(2000,  "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com" );
		bookmarks[0][1] = BookmarkManager.getInstance().createWeblink(2001,	  "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com" );
		bookmarks[0][2] = BookmarkManager.getInstance().createWeblink(2002,	 "https://www.imdb.com/title/tt0120915/","http://www.starwars.com" );
		bookmarks[0][3] = BookmarkManager.getInstance().createWeblink(2003,	  "http://mindprod.com/jgloss/interfacevsabstract.html", "http://mindprod.com" ); 
		bookmarks[0][4] = BookmarkManager.getInstance().createWeblink(2004,	  "http://mindprod.com/jgloss/interfacevsabstract.html", "http://mindprod.com" ); 
	}
	private static void loadMovies() {
		bookmarks[1][0] = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", 1941, new String[] {"Orson Welles"," Joseph Cotten"},new String[] {"Orson Welles"}, MovieGenre.CLASSICS, 8.5);  
		bookmarks[1][1] = BookmarkManager.getInstance().createMovie(3001, "The Grapes of Wrath", 1940, new String[] {"Henry Fonda","Jane Darwell"},new String[] {"John Ford"}, MovieGenre.CLASSICS, 8.2);  
		bookmarks[1][2] = BookmarkManager.getInstance().createMovie(3002, "The Big Bang Theory2", 2007, new String[] {"Kaley Cuoco","Jim Parsons"},new String[] {"Chuck Lorre","Bill Prady"}, MovieGenre.FOREIGN_DRAMAS, 8.7 );
		bookmarks[1][3] = BookmarkManager.getInstance().createMovie(3003, "The Big Bang Theory3", 2002, new String[] {"  Cuoco"," Parsons"},new String[] {"Bill"," Prady"}, MovieGenre.ACTION_AND_ADVENTURE, 7.0 );  
		bookmarks[1][4] = BookmarkManager.getInstance().createMovie(3004, "The Big Bang Theory4", 2002, new String[] {"  Cuoco"," Parsons"},new String[] {"Bill"," Prady"}, MovieGenre.ACTION_AND_ADVENTURE, 7.0 );  
	}

	private static void loadBooks() {
		bookmarks[2][0] = BookmarkManager.getInstance().createBook(4000,"Walden",	1854,	"Wilder Publications", new String[] {"Henry David Thoreau"},	BookGenre.PHILOSOPHY,	4.3  );
		bookmarks[2][1] = BookmarkManager.getInstance().createBook(4001,"Self-Reliance and Other Essays",	1993,	"Dover Publications", new String[] {"Ralph Waldo Emerson"},	BookGenre.PHILOSOPHY,	4.3  );
		bookmarks[2][2] = BookmarkManager.getInstance().createBook(4002,"Light From Many Lamps",	1988,	"Touchstone", new String[] {"Lillian Eichler Watson"},	BookGenre.PHILOSOPHY,	5.0  );
		bookmarks[2][3] = BookmarkManager.getInstance().createBook(4003,"Head First Design Patterns",  2004,	"O'Reilly Media",	new String[] {"Eric Freeman","Bert Bates","Kathy Sierra","Elisabeth Robson"},	BookGenre.FICTION,	4.5 ); 
		bookmarks[2][4] = BookmarkManager.getInstance().createBook(4004,"Effective Java Programming Language Guide",  2007,	"Prentice Hall",	new String[] {"Joshua Bloch"},	BookGenre.TECHNICAL,	4.9	 );  
	}
	private static void loadCars() {  
		cars[0] = CarManager.getInstance().createCar(5000, CarMake.TESLA, "Cyber-Truck", 37000.99, 0);
		cars[1] = CarManager.getInstance().createCar(5001, CarMake.FORD, "Fusion", 23000.99, 0  );
		cars[2] = CarManager.getInstance().createCar(5002, CarMake.JEEP, "Gladiator", 59000.99, 0 );
		cars[3] = CarManager.getInstance().createCar(5003, CarMake.FORD, "Fusion1", 23000.99, 0  );
		cars[4] = CarManager.getInstance().createCar(5004, CarMake.JEEP, "Gladiator", 59000.99, 0 );
		cars[5] = CarManager.getInstance().createCar(5005, CarMake.TESLA, "Cyber-Truck", 37000.99, 0);
		cars[6] = CarManager.getInstance().createCar(5006, CarMake.CHEVROLET, "Impala", 23000.99, 0  );
		cars[7] = CarManager.getInstance().createCar(5007, CarMake.JEEP, "Wrangler", 59000.99, 0 );
		cars[8] = CarManager.getInstance().createCar(5008, CarMake.TESLA, "Fusion1", 23000.99, 0  );
		cars[9] = CarManager.getInstance().createCar(5009, CarMake.JEEP, "Gladiator1", 59000.99, 0 );
		
		 
	}
	public static void add(UserBookmark userBookmark) {
		userBookmarks[bookmarkIndex] = userBookmark;
		bookmarkIndex++;
		
	}
	public static void add(UserCarbuy userCarbuy) {
		userCarbuys[carIndex] = userCarbuy;
		carIndex++;
	}
}
