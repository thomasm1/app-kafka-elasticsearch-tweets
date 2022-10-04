package db;

import constants.Gender;
import constants.UserType;
import models.Bookmark;
import models.User;
import models.UserBookmark;
import singletons.UserManager;

public class DataStore {
	private static final int USER_BOOKMARK_LIMIT = 5;
	private static final int BOOKMARK_COUNT_PER_TYPE = 5;
	private static final int BOOKMARK_TYPES_COUNT = 3;
	private static final int TOTAL_USER_COUNT = 5;
	private static User[] users = new User[TOTAL_USER_COUNT];
	private static Bookmark[][] bookmarks= new Bookmark[BOOKMARK_TYPES_COUNT][BOOKMARK_COUNT_PER_TYPE];
	private static UserBookmark[]  userBookmarks = new UserBookmark[USER_BOOKMARK_LIMIT * TOTAL_USER_COUNT];
	
	public static void loadData() {
		loadUsers();
	}
	private static void loadUsers() {
		users[0] = UserManager.getInstance().createUser(500, 1000,	"Smith", "Tom", "user0", "password",  UserType.USER, Gender.MALE, "user0@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net");

		users[1] = UserManager.getInstance().createUser(501, 2001, "Smith", "Tom", "user1", "password", UserType.USER, Gender.MALE, "user0@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net");

		users[2] = UserManager.getInstance().createUser(502, 1002,	"Smith", "Tom", "user2", "password", UserType.USER, Gender.MALE, "user0@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net");

		users[3] = UserManager.getInstance().createUser(503, 1003,	"Smith", "Tom", "user3", "password",   UserType.USER, Gender.MALE, "user0@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net");

		users[4] = UserManager.getInstance().createUser(504, 1004,	"Smith", "Tom", "user4", "password",   UserType.USER, Gender.MALE, "user0@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net");
	}
}
