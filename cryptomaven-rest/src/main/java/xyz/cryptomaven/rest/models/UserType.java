package xyz.cryptomaven.rest.models;

public class UserType  extends AbstractDomainClass{

  private static final long serialVersionUID = 1L;
	private int userTypeId;
	private int userTypeHeadId;
	private String userTypeName;

	public UserType() {
		super();
	}

	public UserType(int userTypeId, int userTypeHeadId, String userTypeName) {
		super();
		this.userTypeId = userTypeId;
		this.userTypeHeadId = userTypeHeadId;
		this.userTypeName = userTypeName;
	}

	public int getuserTypeId() {
		return userTypeId;
	}
	public void setuserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}
	public int getuserTypeHeadId() {
		return userTypeHeadId;
	}
	public void setuserTypeHeadId(int userTypeHeadId) {
		this.userTypeHeadId = userTypeHeadId;
	}
	public String getuserTypeName() {
		return userTypeName;
	}
	public void setuserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

	@Override
	public String toString() {
		return "UserType [userTypeId=" + userTypeId + ", userTypeHeadId=" + userTypeHeadId + ", userTypeName=" + userTypeName + "]";
	}


	public void add(UserType userType) {
	}
}
