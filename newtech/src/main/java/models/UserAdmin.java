package models;

public class UserAdmin {
	private int userAdminId;
	private int superId;
	private String userAdminName;
	private String password;
	private String email;
	private int deptId;
	
	public UserAdmin() {
		super();
	}

	public UserAdmin(int userAdminId, int deptId, int superId, String userAdminName, String password, String email) {
		super();
		this.userAdminId = userAdminId;
		this.deptId = deptId;
		this.superId = superId;
		this.userAdminName = userAdminName;
		this.password = password;
		this.email = email;
	}

	public int getUserAdminId() {
		return userAdminId;
	}

	public void setUserAdminId(int userAdminId) {
		this.userAdminId = userAdminId;
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

	public String getUserAdminName() {
		return userAdminName;
	}

	public void setUserAdminName(String userAdminName) {
		this.userAdminName = userAdminName;
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

	@Override
	public String toString() {
		return "UserAdmin [userAdminId=" + userAdminId + ", deptId=" + deptId + ", superId=" + superId + ", userAdminName=" + userAdminName
				+ ", password=" + password + ", email=" + email + "]";
	}

}
