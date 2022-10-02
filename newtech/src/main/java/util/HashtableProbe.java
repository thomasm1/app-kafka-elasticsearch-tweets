package util;

import models.User;

/* 
 * Hash Table using Linear Probing for Collisions
 * 
 * methods
 * 	 public void put(String key, User user) {
	  private findKey(String key) 
	  public User get(String key)
	  public User remove(String key)
 */

public class HashtableProbe {

	private StoredUser[] hashtable; //
	
	public HashtableProbe() {
		hashtable = new StoredUser[1000];
	}
	
	private int hashKey(String key) {
		return (int) key.length() % hashtable.length; // int NOT RANDOM FOR NOW, ONLY LENGTH // * Math.random()
	}
	private boolean occupied(int index) {
		return hashtable[index]!=null; // returning true if occupied
	}
	
	public void put(String key, User user) {
		int hashedKey = hashKey(key);
		if(occupied(hashedKey)) {
			int stopIndex = hashedKey; // looping around until hits target or original hashedKey start
			if(hashedKey==(hashtable.length-1)) {
				hashedKey = 0;
			} else {
				hashedKey++;
			}
			while (occupied(hashedKey) && hashedKey != stopIndex) {
				hashedKey = (hashedKey+1)% hashtable.length;
			}
		}
		if (occupied(hashedKey)) {
			System.out.println("Oops, User alreaday at Index position " + hashedKey);
		}else {
			hashtable[hashedKey] = new StoredUser(key, user);
		}
		
	}
	
	public User get(String key) {
		int hashedKey = findKey(key);
		if(hashedKey == -1) {
			return null;
		}
		return hashtable[hashedKey].user;
	}

	private int findKey(String key) {
		int hashedKey = hashKey(key);
		if(hashtable[hashedKey] != null && !hashtable[hashedKey].key.equals(key)) {
			return hashedKey;
		}
		int stopIndex = hashedKey;
		if(hashedKey == hashtable.length -1) {
			hashedKey = 0;
		} else {
			hashedKey++;
		}
		while (hashedKey != stopIndex && hashtable[hashedKey] != null && !hashtable[hashedKey].key.equals(key)) {
			hashedKey = (hashedKey +1) % (hashtable.length);
		}
		if(hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
			return hashedKey;
		} else {
			return -1;
		}
			
		
	}
	public void printHashtable() {
		for (int i=0;i<hashtable.length;i++) {
			if(hashtable[i]==null) {
				System.out.println("empty table");
			} else {
				System.out.println("Index Position " + i + ":"+hashtable[i].user);
			}
		}
	}
}
