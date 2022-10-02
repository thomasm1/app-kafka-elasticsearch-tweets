package models;

public class UserAdmin { 
	
	private int userId;
	private long id;
	private String lastName;
	private String firstName;
	private int deptId;
	private int superId;
	private String userName;
	private String password;
	private String email;
	private String phone;
	private String cusUrl;
	
	public UserAdmin() {
		super();
	}

	public UserAdmin(int userId, long id, String lastName, String firstName, int deptId, int superId, String userName,
			String password, String email, String phone, String cusUrl) {
		super();
		this.userId = userId;
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.deptId = deptId;
		this.superId = superId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.cusUrl = cusUrl;
	}

	public UserAdmin(int userId, int deptId, int superId, String userName, String password, String email) {
		super();
		this.userId = userId;
		this.deptId = deptId;
		this.superId = superId;
		this.userName = userName;
		this.password = password;
		this.email = email;
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

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public int getSuperId() {
		return superId;
	}

	public void setSuperId(int superId) {
		this.superId = superId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		return "UserAdmin [userId=" + userId + ", id=" + id + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", deptId=" + deptId + ", superId=" + superId + ", userName=" + userName + ", password=" + password
				+ ", email=" + email + ", phone=" + phone + ", cusUrl=" + cusUrl + "]";
	}
}
