/**
 * 
 */
package util;

import java.util.LinkedList;
import java.util.ListIterator;

import models.User;

/**
 * @author thoma
 *
 */
public class HashtableChain {

	private LinkedList<StoredUser>[] hashtable;
	
	public HashtableChain() {
		hashtable = new LinkedList[1000];
		for (int i=0;i<hashtable.length;i++) {
			hashtable[i] = new LinkedList<StoredUser>();
		}
	}
	
	public void put(String key, User user) {
		int hashedKey = hashKey(key);
		hashtable[hashedKey].add(new StoredUser(key, user));
	}
	
	public User get(String key) {
		int hashedKey = hashKey(key);
		ListIterator<StoredUser> iterator = hashtable[hashedKey].listIterator();
		StoredUser user = null;
		while (iterator.hasNext()) {
			user = iterator.next();
			if (user.key.equals(key)) {
				return user.user;
			}
		}
		return null;
	}
	public User remove(String key) {
		int hashedKey = hashKey(key);
		ListIterator<StoredUser> iterator = hashtable[hashedKey].listIterator();
		StoredUser user = null;
		int index = -1;
		while (iterator.hasNext()) {
			user = iterator.next();
			index++;
			if(user.key.equals(key)) {
				break;
			}
		}
		if (user == null) {
			return null;
		}
		else {
			hashtable[hashedKey].remove(index);
			return user.user;
			
		}
	}
	private int hashKey(String key) {
		// return key.length() % hashtable.length;
		return Math.abs(key.hashCode() % hashtable.length);
	}
	
	public void printHashtable() {
		for (int i = 0;i<hashtable.length;i++) {
			if(hashtable[i].isEmpty()) {
				System.out.println("Position " + i + ": empty");
			} else {
				System.out.println("Postiion " + i + ": ");
				ListIterator<StoredUser> iterator = hashtable[i].listIterator();
				while(iterator.hasNext()) {
					System.out.println(iterator.next().user);
					System.out.println("->");
				}
				System.out.println("null");
			}
		}
	}

}
