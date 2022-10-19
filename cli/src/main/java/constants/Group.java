package constants;

public enum Group {

	MALE(1),
	FEMALE(2),
	OTHER(3);
	private Group(int group) {
		this.group = group;
	}
	private int group;
	public int getGroup() {
		return group;
	}

	}
