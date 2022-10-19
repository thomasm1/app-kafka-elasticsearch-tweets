package models;

public class Group {
	private int groupId;
	private int groupHeadId;
	private String groupName;
	
	public Group() {
		super();
	}

	public Group(int groupId, int groupHeadId, String groupName) {
		super();
		this.groupId = groupId;
		this.groupHeadId = groupHeadId;
		this.groupName = groupName;
	}
	
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public int getGroupHeadId() {
		return groupHeadId;
	}
	public void setGroupHeadId(int groupHeadId) {
		this.groupHeadId = groupHeadId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public String toString() {
		return "Group [groupId=" + groupId + ", groupHeadId=" + groupHeadId + ", groupName=" + groupName + "]";
	}


}
