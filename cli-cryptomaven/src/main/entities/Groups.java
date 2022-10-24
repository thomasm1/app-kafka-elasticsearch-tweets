package main.entities;

public class Groups {
    private int groupsId;
    private int groupsHeadId;
    private String groupsName;

    public Groups() {
        super();
    }

    public Groups(int groupsId, int groupsHeadId, String groupsName) {
        super();
        this.groupsId = groupsId;
        this.groupsHeadId = groupsHeadId;
        this.groupsName = groupsName;
    }

    public int getGroupsId() {
        return groupsId;
    }
    public void setGroupsId(int groupsId) {
        this.groupsId = groupsId;
    }
    public int getGroupsHeadId() {
        return groupsHeadId;
    }
    public void setGroupsHeadId(int groupsHeadId) {
        this.groupsHeadId = groupsHeadId;
    }
    public String getGroupsName() {
        return groupsName;
    }
    public void setGroupsName(String groupsName) {
        this.groupsName = groupsName;
    }

    @Override
    public String toString() {
        return "Groups [groupsId=" + groupsId + ", groupsHeadId=" + groupsHeadId + ", groupsName=" + groupsName + "]";
    }


    public void add(Groups groups) {
    }
}
