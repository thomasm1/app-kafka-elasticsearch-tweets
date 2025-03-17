package xyz.cryptomaven.rest.util.dataLoader;

import org.springframework.context.annotation.Profile;
import xyz.cryptomaven.rest.models.*;
import xyz.cryptomaven.rest.util.ReadWriteFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static xyz.cryptomaven.rest.util.constants.Constants.*;


@Profile("test")
public class FileDataStore extends ReadWriteFile {

	private static final Logger log = LoggerFactory.getLogger(FileDataStore.class);
	// DATA SOURCES
	private static int COIN_COUNT = 1;

	public static List<NftCoin> nftsStatic = new ArrayList<>();

	public static int getCoinInventory() {
		return COIN_COUNT;
	}

	private static int TEST_USERS;

	private static List<User> users = new ArrayList<>();
	public static List<User> getUsers() {
		return users;
	}


	public static void loadData() throws FileNotFoundException, UnsupportedEncodingException {
    loadUsersFromCsv();

	}


		static List<User> loadUsersFromCsv() throws FileNotFoundException, UnsupportedEncodingException {
//		users[0] = UserManager.getInstance().registerUser(500,  "user0", "password", "Smith", "Tom", UserType.MALE,  UserType.USER, "user0@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net", "1000");
 	List<String> data = new ArrayList<>();
			ReadWriteFile.readFromFilename(data,  FILE_IN_USERS);
			System.out.println("TEST_USERS::::::: "+FILE_IN_USERS+data.toString());
			for (String row : data) {
				String[] values = row.split(",");
        User user;
        user =  User.builder()
          .username(values[1])
          .password(values[2])
          .firstName(values[3])
          .lastName(values[4])
          .email(values[8])
          .isActive(Integer.parseInt(values[12]))
          .contactType(Integer.parseInt((values[13])))
          .build();
         users.add(user);
				TEST_USERS = users.size();
			}
      log.info("TEST_USERS SIZE::::::: "+TEST_USERS);
      log.info("TEST_USERS  ::::::: "+users);
			return users;
		}

// TABLE JOIN

	public static List<NftCoin> getNfts() {
		return nftsStatic;
	}



}
