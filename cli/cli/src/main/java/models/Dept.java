package models;

public class Dept {
	private int deptId;
	private int deptHeadId;
	private String deptName;
	
	public Dept() {
		super();
	}

	public Dept(int deptId, int deptHeadId, String deptName) {
		super();
		this.deptId = deptId;
		this.deptHeadId = deptHeadId;
		this.deptName = deptName;
	}
	
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public int getDeptHeadId() {
		return deptHeadId;
	}
	public void setDeptHeadId(int deptHeadId) {
		this.deptHeadId = deptHeadId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Dept [deptId=" + deptId + ", deptHeadId=" + deptHeadId + ", deptName=" + deptName + "]";
	}
	 

}
