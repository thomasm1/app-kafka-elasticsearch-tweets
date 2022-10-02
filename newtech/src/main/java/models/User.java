package models;

public class User {

	int userID;
	String username;
	String password;
	String fullName;
	int isCust;
	int isOwner;

	public User() {
		super();
	}

	public User(int userID, String username, String password, String fullName, int isCust, int isOwner) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.isCust = isCust;
		this.isOwner = isOwner;
	}

//	 overloaded without ID
	public User(String username, String password, String fullName, int isCust, int isOwner) {
//			super(); 
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.isCust = isCust;
		this.isOwner = isOwner;
	}

	

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + fullName.hashCode(); 
        return result;
    }

    
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int isCust() {
		return isCust;
	}

	public void setCust(int isCust) {
		this.isCust = isCust;
	}

	public int isOwner() {
		return isOwner;
	}

	public void setOwner(int isOwner) {
		this.isOwner = isOwner;
	}

	@Override
	public String toString() {
		return "User [ userid=" + userID + "username=" + username + ", password=" + password + ", fullName=" + fullName
				+ ", isCust=" + isCust + ", isOwner=" + isOwner + "]\n"
						+ "---------------------------";
	}

}