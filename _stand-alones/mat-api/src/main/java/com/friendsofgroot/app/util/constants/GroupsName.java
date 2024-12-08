package com.friendsofgroot.app.util.constants;

public enum GroupsName {

	MALE(1),
	FEMALE(2),
	OTHER(3);
	private GroupsName(int groups) {
		this.groups = groups;
	}
	private int groups;
	public int getGroups() {
		return groups;
	}

	}
