package com.friendsofgroot.app.dataLoader;

import com.friendsofgroot.app.models.dto.UserNftbuy;
import com.friendsofgroot.app.models.*;
import com.friendsofgroot.app.util.ReadWriteFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static com.friendsofgroot.app.util.constants.Constants.*;


public class FileDataStore extends ReadWriteFile {

	private static final Logger log = LoggerFactory.getLogger(FileDataStore.class);
	public static int USER_BOOKMARK_LIMIT = 5; // Non-member User
//	public   int USER_BOOKMARK_LIMIT = Integer.MAX_VALUE; //Premium -member
	// DATA SOURCES
	private static int COIN_COUNT = 1;
	public static final int BOOKMARK_COUNT_PER_TYPE = 5;
	public static final int BOOKMARK_TYPES_COUNT = 3;

	public static List<Nft> nftsStatic = new ArrayList<>();

	public static int getCoinInventory() {
		return COIN_COUNT;
	}

	private static int TEST_USERS;
	public static List<UserNftbuy> userNftbuys = new ArrayList<>();
	private static List<User> users = new ArrayList<>();
	public static List<User> getUsers() {
		return users;
	}


	public static void loadData() throws FileNotFoundException, UnsupportedEncodingException {
		loadUsers();

	}


		static List<User> loadUsers() throws FileNotFoundException, UnsupportedEncodingException {
//		users[0] = UserManager.getInstance().registerUser(500,  "user0", "password", "Smith", "Tom", Group.MALE,  UserType.USER, "user0@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net", "1000");
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

// TABLE JOIN
	public static void add(UserNftbuy userNftbuy) {
		userNftbuys.add( userNftbuy);
	}

	public static List<Nft> getNfts() {
		return nftsStatic;
	}



}
