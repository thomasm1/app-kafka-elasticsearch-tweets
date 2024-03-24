package app.mapl.bootstrap;

import app.mapl.dto.UserBookmark;
import app.mapl.models.*;
import app.mapl.service.WeblinksService;
import app.mapl.util.DownloadSequential;
import app.mapl.util.ReadWriteFile;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static app.mapl.util.constants.Datum.*;

@Component
public class FileDataStore extends ReadWriteFile {
 	WeblinksService bookmarks;
	 FileDataStore(WeblinksService bookmarkservice) {
		this.bookmarks = bookmarkservice;
	 }
	public static int USER_BOOKMARK_LIMIT = 5; // Non-member User
//	public   int USER_BOOKMARK_LIMIT = Integer.MAX_VALUE; //Premium -member
	// DATA SOURCES
	private static int COIN_COUNT = 1;
	public static final int BOOKMARK_COUNT_PER_TYPE = 5;
	public static final int BOOKMARK_TYPES_COUNT = 3;

	public static List<Coin> coinsStatic = new ArrayList<>();

	public static int getCoinInventory() {
		return COIN_COUNT;
	}

	private static int TEST_USERS;
	public static List<UserCoinbuy> userCoinbuys = new ArrayList<>();
	private static List<User> users = new ArrayList<>();
//	public static List<User> getUsers() {
//		return users;
//	}

	public static List<Weblink> weblinks= new ArrayList<>();
	public static List<Weblink> getBookmarksArray() {
		return weblinks;
	}
	public static List<UserBookmark> userBookmarks = new ArrayList<>();

	public static void loadData() throws FileNotFoundException, UnsupportedEncodingException {
		loadUsers();
		loadWeblinks();
		loadCoins();
	}


		static List<User> loadUsers() throws FileNotFoundException, UnsupportedEncodingException {
//		users[0] = UserManager.getInstance().createUser(500,  "user0", "password", "Smith", "Tom", Group.MALE,  UserType.USER, "user0@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net", "1000");
 	List<String> data = new ArrayList<>();
			ReadWriteFile.readFromFilename(data,  FILE_IN_USERS);
			System.out.println("TEST_USERS::::::: "+FILE_IN_USERS+data.toString());
			for (String row : data) {
				String[] values = row.split(",");
				User user = new User( values[1], values[2], values[3], values[4],  Integer.parseInt(values[6]),   values[8], values[9],  values[10],values[11],Integer.parseInt(values[12]),Integer.parseInt((values[13])) );
				users.add(user);
				TEST_USERS = users.size();
			}
			return users;
		}

		public static List<Weblink> loadWeblinks() throws FileNotFoundException, UnsupportedEncodingException {
//			bookmarks[0][0] = BookmarkManager.getInstance().createWeblink(2000,  "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com" );
			List<String>  data = new ArrayList<>();
			ReadWriteFile.readFromFilename(data, FILE_IN_WEBLINKS);

			for (String row : data) {
				String[] values = row.split(",");
				//// STATIC DATA
//				Bookmark weblink = ManagerBookmarks.getInstance().createWeblink(Long.parseLong(values[0]), values[1],  values[2]);
     			Bookmark weblink = new Weblink(Long.parseLong(values[0]), values[1],  values[2]);

				if(weblink != null && weblink instanceof Weblink) {
					weblinks.add((Weblink) weblink);
				}
			}
			return weblinks;
		}

		public static List<Coin> loadCoins() throws FileNotFoundException, UnsupportedEncodingException {
//		Coin coin1 = CoinManager.getInstance().createCoin(5000, CoinMake.TESLA, "Cyber-Truck", 37000.99, 0);
			List<String> data =new ArrayList<>();
			ReadWriteFile.readFromFilename(data, FILE_IN_COINS);
			for (String row: data) {
				String[] values = row.split(",");
				Coin coin = new Coin(Integer.parseInt(values[0]), values[1], values[2], Double.parseDouble(values[3]), Integer.parseInt(values[4]));

				coinsStatic.add(coin);
				COIN_COUNT = coinsStatic.size();
				System.out.println("COIN_COUNT::::::: "+COIN_COUNT);
			}
			return coinsStatic;
		};

// TABLE JOIN
	public static void add(UserBookmark userBookmark) {
		userBookmarks.add(userBookmark);
	}


	public static void add(UserCoinbuy userCoinbuy) {
		userCoinbuys.add(  userCoinbuy);
	}

	public static List<Coin> getCoins() {
		return coinsStatic;
	}
	public static void saveLocalUserCoinbuy(User user, Coin coin) {
		UserCoinbuy userCoinbuy = new UserCoinbuy();
		userCoinbuy.setUser(user);
		userCoinbuy.setCoin(coin);
	}


	public static void saveLocalUserBookmark(User user, Bookmark bookmark) {
		UserBookmark userBookmark = new UserBookmark();
		userBookmark.setUser(user);
		userBookmark.setBookmark(bookmark);
		add(userBookmark);
		if(bookmark instanceof Weblink) {
			try {
				String url = ((Weblink) bookmark).getUrl();
				if(!url.endsWith(".pdf")) {
					String website = DownloadSequential.downloadFromUrl(((Weblink) bookmark).getUrl());
					if(website != null) {
						ReadWriteFile.writeWebpage(website, bookmark.getId());
					}
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

}










