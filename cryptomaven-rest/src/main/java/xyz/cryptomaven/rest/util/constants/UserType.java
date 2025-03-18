package xyz.cryptomaven.rest.util.constants;

public enum UserType {
		USER(0),
		CUST(1),
		OWNER(2),
		MEMBER(3),

		ADMIN(4),
		SUPER(5),
		EDITOR(6),
		CHIEF_EDITOR(7);

	private final int userType;

	private UserType(int userType) {
		this.userType = userType;
	};

	public int getUserType() {
		return userType;
	}
}
