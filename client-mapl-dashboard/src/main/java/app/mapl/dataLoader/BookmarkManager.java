package app.mapl.dataLoader;

import app.mapl.dao.BookmarkDaoImpl;
import app.mapl.dao.CoinDAOimpl;
import app.mapl.dao.OfferDAOimpl;
import app.mapl.dao.UserDAOimpl;
import app.mapl.models.*;
import app.mapl.util.DownloadSequential;
import app.mapl.util.InputOutput;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static app.mapl.util.constants.Datum.*;

public class BookmarkManager {
	private static BookmarkManager instance = new BookmarkManager();
	public static BookmarkDaoImpl bookmarkDaoImpl = new  BookmarkDaoImpl();
	
	private BookmarkManager() {}
	
	public static BookmarkManager getInstance() {
		return instance;
	}
	
	public Movie createMovie(long id, String title,  int releaseYear,	String cast, String directors, String genre, double imbdRating ) {

	Movie movie = new Movie();
	movie.setId(id);
	movie.setTitle(title); 
	movie.setReleaseYear(releaseYear);
	movie.setCast(cast);
	movie.setDirectors(directors);
	movie.setGenre(genre);
	movie.setImdbRating(imbdRating);
	return movie;
	}
 
	public Book createBook(long id, String title, int publicationYear, String publisher, String authors,
                           String genre, double rating  ) {

		Book book = new Book();
		book.setId(id);
		book.setTitle(title); 
		book.setPublicationYear(publicationYear);
		book.setPublisher(publisher);
		book.setAuthors(authors);
		book.setGenre(genre);
		book.setRating(rating);
	
	return book;
	}
 
	public Weblink createWeblink(long id, String url, String host ) {

		Weblink weblink = new Weblink();
		weblink.setId(id); 
		weblink.setUrl(url);
		weblink.setHost(host);
	return weblink;
	}

	public List<List<Bookmark>> getBookmarksArray() {
		return bookmarkDaoImpl.getBookmarksArray();
	}

	public List<Bookmark> getLocalUserBookmarksByUser(User user) {
		return bookmarkDaoImpl.getLocalUserBookmarksByUser(user);
	}


	public static void saveLocalUserBookmark(User user, Bookmark bookmark) {
	    UserBookmark userBookmark = new UserBookmark();
	    userBookmark.setUser(user);
	    userBookmark.setBookmark(bookmark);
		bookmarkDaoImpl.saveLocalUserBookmark(userBookmark);   // JOIN TABLE

		if(bookmark instanceof Weblink) {
			try {
				String url = ((Weblink) bookmark).getUrl();
				if(!url.endsWith(".pdf")) {
					String website = DownloadSequential.downloadFromUrl(((Weblink) bookmark).getUrl());
					if(website != null) {
						InputOutput.writeWebpage(website, bookmark.getId());
					}
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			} catch (URISyntaxException e) {
				throw new RuntimeException(e);
			}
		}
	    
	}


	public void share(User user, Bookmark bookmark) {
		bookmark.setSharedBy(user);
	System.out.println("Data to be shared by" + user + " : "+bookmark);
	if (bookmark instanceof Book) {
		System.out.println(((Book) bookmark).getItemData());
	} else if (bookmark instanceof Weblink) {
		System.out.println(((Weblink) bookmark).getItemData());

	}
}


    public static class CoinManager {

        private static CoinManager instance = new CoinManager();
        private static CoinDAOimpl coinDaoImpl = new CoinDAOimpl();

        private static OfferDAOimpl offerDaoImpl= new OfferDAOimpl();
        private static UserDAOimpl userDAOimpl = new UserDAOimpl();
        private CoinManager() {
        }

        public static CoinManager getInstance() {

            return instance;
        }

        public Coin createCoin(int carId, String carToken, String carSymbol, double priceTotal, int purchased) {

            Coin car = new Coin();
            car.setCoinId(carId);
            car.setCoinToken(carToken);
            car.setCoinSymbol(carSymbol);
            car.setPriceTotal(priceTotal);
            car.setPurchased(purchased);

            return car;
        }
        public List<Coin> getCoins() {
            return coinDaoImpl.getCoins();
    }


        public Offer createOffer(int offerID, String username, int carId, double offerAmt, int offerMos, String offerStatus) {
            Offer offer = new Offer();
            offer.setOfferID(offerID);
            offer.setUsername(username);
            offer.setCoinId(carId);
            offer.setOfferAmt(offerAmt);
            offer.setOfferMos(offerMos);
            offer.setOfferStatus(offerStatus);
            return offer;
        }

        public List<Offer> getOffers() {
            return offerDaoImpl.getOffers();
        }


    }

    public static class TestDataStore extends InputOutput{

        public static int USER_BOOKMARK_LIMIT = 5; // Non-member User
    //	public   int USER_BOOKMARK_LIMIT = Integer.MAX_VALUE; //Premium -member
        // DATA SOURCES
        private static int COIN_INVENTORY;
        public static final int BOOKMARK_COUNT_PER_TYPE = 5;
        public static final int BOOKMARK_TYPES_COUNT = 3;

        public List<Groups> groups = new ArrayList<>();
        public static List<Coin> coins = new ArrayList<>();
        public static List<Nft> nfts = new ArrayList<>();
        public static List<Offer> offers = new ArrayList<>();

        public static int getCoinInventory() {
            return COIN_INVENTORY;
        }

        private static int TEST_USERS;
        public static List<UserCoinbuy> userCoinbuys = new ArrayList<>();
        public static List<UserNftbuy> userNftbuys = new ArrayList<>();
        private static List<User> users = new ArrayList<>();
        public static List<User> getUsers() {
            return users;
        }
        public static List<Offer> getOffers() { return offers;	}
        protected static List<List<Bookmark>> bookmarks= new ArrayList<>();
        public static List<List<Bookmark>> getBookmarksArray() {
            return bookmarks;
        }
        public static List<UserBookmark> userBookmarks = new ArrayList<>();

        public int bookmarkIndex; // initialized to zero
        public static void loadData() throws FileNotFoundException, UnsupportedEncodingException {
            loadUsers();
            loadWeblinks();
            loadMovies();
            loadBooks();
            loadCoins();
            loadOffers();
            loadGroups();
        }


            private static void loadUsers() throws FileNotFoundException, UnsupportedEncodingException {
    //		users[0] = UserManager.getInstance().createUser(500,  "user0", "password", "Smith", "Tom", Group.MALE,  UserType.USER, "user0@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net", "1000");
         List<String> data = new ArrayList<>();
                InputOutput.readFromFilename(data,  FILE_IN_USERS);
                System.out.println("TEST_USERS::::::: "+FILE_IN_USERS+data.toString());
                for (String row : data) {
                    String[] values = row.split(",");
                    User user = UserManager.getInstance().createUser(Integer.parseInt(values[0]), values[1], values[2], values[3], values[4], Integer.parseInt(values[5]), Integer.parseInt(values[6]), values[7], values[8], values[9],  values[10],values[11],Integer.parseInt(values[12]),Integer.parseInt((values[13])),values[14]);
                    users.add(user);
                    TEST_USERS = users.size();
                }
            }
            private static void loadOffers() throws FileNotFoundException, UnsupportedEncodingException {
                List<String> data = new ArrayList<>();
                InputOutput.readFromFilename(data, FILE_IN_OFFERS);
                System.out.println("OFFER-FILE IN::::::: "+data.toString());
                for (String row: data) {
                    String[] values = row.split(",");
                    Offer offer = CoinManager.getInstance().createOffer(Integer.parseInt(values[0]),  values[1], Integer.parseInt(values[2]), Double.parseDouble(values[3]), Integer.parseInt(values[4]), values[5]);
                    offers.add(offer);
                }

            }
            private static void loadWeblinks() throws FileNotFoundException, UnsupportedEncodingException {
    //			bookmarks[0][0] = BookmarkManager.getInstance().createWeblink(2000,  "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com" );
                List<String>  data = new ArrayList<>();
                InputOutput.readFromFilename(data, FILE_IN_WEBLINKS);
                List<Bookmark> WeblinkList = new ArrayList<>();
                for (String row : data) {
                    String[] values = row.split(",");
                    Bookmark weblink = getInstance().createWeblink(Long.parseLong(values[0]), values[1],  values[2]);
                    WeblinkList.add(weblink);
                }
                bookmarks.add(WeblinkList);   // First of Three
            }

            private static void loadBooks() throws FileNotFoundException, UnsupportedEncodingException {
    //		bookmarks[1][1] = BookmarkManager.getInstance().createBook(4001,"Self-Reliance and Other Essays",	1993,	"Dover Publications", new String[] {"Ralph Waldo Emerson"},	BookGenre.PHILOSOPHY,	4.3  );
                List<String> data = new ArrayList<>();
                InputOutput.readFromFilename(data, FILE_IN_BOOKS);
                List<Bookmark> bookList = new ArrayList<>();
                for (String row : data) {
                    String[] values = row.split(",");
                    Bookmark book = getInstance().createBook(Long.parseLong(values[0]), values[1], Integer.parseInt(values[2]), values[3], values[4], values[5], Double.parseDouble(values[6]));
                    bookList.add(book);
                }
                bookmarks.add(bookList); // Second of Three
            }
            private static void loadMovies() throws FileNotFoundException, UnsupportedEncodingException {
    //		bookmarks[2][0] = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", 1941, new String[] {"Orson Welles"," Joseph Cotten"},new String[] {"Orson Welles"}, MovieGenre.CLASSICS, 8.5);
                 List<String> data = new ArrayList<>();
                InputOutput.readFromFilename(data, FILE_IN_MOVIES);
                List<Bookmark> movieList = new ArrayList<>();
                for (String row : data) {
                    String[] values = row.split(",");
                    Bookmark movie = getInstance().createMovie(Long.parseLong(values[0]), values[1],  Integer.parseInt(values[2]), values[3], values[4], values[5], Double.parseDouble(values[6]));
                    movieList.add(movie);
                }
                bookmarks.add(movieList);  // Third of Three
            }
            public static void loadCoins() throws FileNotFoundException, UnsupportedEncodingException {
    //		Coin coin1 = CoinManager.getInstance().createCoin(5000, CoinMake.TESLA, "Cyber-Truck", 37000.99, 0);
                List<String> data =new ArrayList<>();
                InputOutput.readFromFilename(data, FILE_IN_COINS);
                for (String row: data) {
                    String[] values = row.split(",");
                    Coin coin = CoinManager.getInstance().createCoin(Integer.parseInt(values[0]), values[1], values[2], Double.parseDouble(values[3]), Integer.parseInt(values[4]));
                    coins.add(coin);
                    COIN_INVENTORY = coins.size();
                }
            };
        public static void loadGroups() throws FileNotFoundException, UnsupportedEncodingException {
    //		Group group1 = UserManager.getInstance().createGroup( 7004,24,"Business Group");
            List<String> data =new ArrayList<>();
            InputOutput.readFromFilename(data, FILE_IN_GROUPS);
            for (String row: data) {
                String[] values = row.split(",");
                Groups groups = UserManager.getInstance().createGroups(Integer.parseInt(values[0]), Integer.parseInt(values[1]), values[2] );
                groups.add(groups);
            }
        };
    // TABLE JOIN
        public static void add(UserBookmark userBookmark) {
            userBookmarks.add(userBookmark);
        }

        public static void add(Groups groups) {
            groups.add(groups);
        }

        public static void add(UserCoinbuy userCoinbuy) {
            userCoinbuys.add(  userCoinbuy);
        }
        public static void add(UserNftbuy userNftbuy) {
            userNftbuys.add( userNftbuy);
        }


        public static List<Coin> getCoins() {
            return coins;
        }

        public static List<Nft> getNfts() {
            return nfts;
        }

        public static void saveLocalUserCoinbuy(User user, Coin coin) {
            UserCoinbuy userCoinbuy = new UserCoinbuy();
            userCoinbuy.setUser(user);
            userCoinbuy.setCoin(coin);
        }

        public List<Coin> getLocalCoinsByUser(User user) {
            List<Coin> coinsOwnedByUser = new ArrayList<>();
            for(UserCoinbuy userCoinbuy : userCoinbuys) {
                if(userCoinbuy.getUser() == user) {
                    coinsOwnedByUser.add(userCoinbuy.getCoin());
                }
            }
            return coinsOwnedByUser;
        }

        public static List<Bookmark> getLocalUserBookmarksByUser(User user) {
            List<Bookmark> bookmarksOwnedByUser = new ArrayList<>();
            for(UserBookmark userbookmark: userBookmarks) {
                if(userbookmark.getUser()==user) {
                    bookmarksOwnedByUser.add(userbookmark.getBookmark());
                }
            }
            return bookmarksOwnedByUser;
        }

    }

    public static class UserManager {
        private static CoinDAOimpl coinDAOimpl = new CoinDAOimpl();

        private static UserManager instance = new UserManager();
        private static UserDAOimpl userDAOimpl = new UserDAOimpl();

        private UserManager() {
        }

        public static UserManager getInstance() {

            return instance;
        }

        public User createUser(int userId, String username, String password, String lastName, String firstName,
                               int groups, int userType, String organizationCode, String email, String cusUrl, String photoPath, String dashboardCode, int isActive, int contactType, String id) {

            User user = new User();
            user.setUserId(userId);
            user.setId(id);
            user.setLastName(lastName);
            user.setFirstName(firstName);
            user.setUsername(username);
            user.setPassword(password);
            user.setGroups(groups);
            user.setUserType(userType);
            user.setEmail(email);
            user.setOrganizationCode(organizationCode);
            user.setCusUrl(cusUrl);
            user.setPhotoPath(photoPath);
            user.setDashboardCode(dashboardCode);
            user.setIsActive(isActive);
            user.setContactType(contactType);
            user.setId(id);

            return user;

        }

        public List<User> getUsers() {// THis is just relaying the call to the DaoImpl
            return userDAOimpl.getLocalUsers();
        }


        public void saveUserCoin(User user, Coin coin) {
            UserCoinbuy userCoinbuy = new UserCoinbuy();
            userCoinbuy.setUser(user);
            userCoinbuy.setCoin(coin);
            userDAOimpl.saveUserCoinbuy(userCoinbuy);
        }

        public Groups createGroups(int id, int id2, String name_groups) {
            Groups groups = new Groups();
            groups.setGroupsId(id);
            groups.setGroupsHeadId(id2);
            groups.setGroupsName(name_groups);
            userDAOimpl.createLocalGroups(groups);
            return groups;
        }

        public void saveLocalUserCoin(User user, Coin coin) {

            userDAOimpl.saveLocalUserCoinbuy(user, coin);

        }

        public List<Coin> getLocalUserCoinsByUser(User user) {
            return userDAOimpl.getLocalUserCoinbuysByUser(user);
        }

        public void saveLocalUserCoinbuy(UserCoinbuy userCoinbuy) {
            userDAOimpl.saveLocalUserCoinbuy(userCoinbuy);
        }

        public List<Coin> getLocalUserCoinbuysByUser(User user) {
            return 	userDAOimpl.getLocalUserCoinbuysByUser(user);
        }
    }
}
