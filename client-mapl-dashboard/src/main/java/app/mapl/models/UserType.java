package app.mapl.models;

public enum UserType {
		ADMIN(0),
		CUST(1),
		OWNER(2),
		MEMBER(3),
		USER(4),
		SUPER(5),
		EDITOR(6),
		CHIEF_EDITOR(7);

	private final int userType;

	UserType(int userType) {
		this.userType = userType;
	};

	public int getUserType() {
		return userType;
	}


}
