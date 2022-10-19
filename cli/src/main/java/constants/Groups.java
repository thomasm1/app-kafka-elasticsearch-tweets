package constants;

public enum Groups {

	MALE(1),
	FEMALE(2),
	OTHER(3);
	private Groups(int groups) {
		this.groups = groups;
	}
	private int groups;
	public int getGroups() {
		return groups;
	}

	}
