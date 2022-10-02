package models;

public class User {

	private int userId;
	private long id;
	private String lastName;
	private String firstName;
	private String userName;
	private String password;
	private String fullName;
	private int isCust;
	private int isOwner;
	private String email;
	private String phone;
	private String cusUrl;

	public User() {
		super();
	}

	public User(int userId, long id, String lastName, String firstName, String userName, String password,
			String fullName, int isCust, int isOwner, String email, String phone, String cusUrl) {
		super();
		this.userId = userId;
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.isCust = isCust;
		this.isOwner = isOwner;
		this.email = email;
		this.phone = phone;
		this.cusUrl = cusUrl;
	}
// overloaded without   Id, lastname, firstname, email, phone, cusurl
	public User(int userId, String userName, String password, String fullName, int isCust, int isOwner) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.isCust = isCust;
		this.isOwner = isOwner;
	}

//	 overloaded without Id
	public User(String userName, String password, String fullName, int isCust, int isOwner) {
//			super(); 
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.isCust = isCust;
		this.isOwner = isOwner;
	}

 

	@Override
    public int hashCode() {
        int result = userName.hashCode();
        result = 31 * result + fullName.hashCode(); 
        return result;
    }

    
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String userName) {
		this.userName = userName;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCusUrl() {
		return cusUrl;
	}

	public void setCusUrl(String cusUrl) {
		this.cusUrl = cusUrl;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", id=" + id + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", userName=" + userName + ", password=" + password + ", fullName=" + fullName + ", isCust=" + isCust
				+ ", isOwner=" + isOwner + ", email=" + email + ", phone=" + phone + ", cusUrl=" + cusUrl + "]";
	}

}