package constants;

public enum Gender {

	MALE(1),
	FEMALE(2),
	OTHER(3);
	private Gender(int gender) {
		this.gender = gender;
	}
	private int gender;
	public int getGender() {
		return gender;
	}

	}
