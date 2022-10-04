package models;

public class Task {
	private int taskId;
	private int reqId;
	private int currUserId;
	private String timeStamp;
	private String currDocs;
	private String updateReason;
	private String updateReqType;
	private String updateGradeType;
	private String updateGradePass;
	private double updateAmt;
	private int updateStage;

	public Task() {
		super();
	}

	public Task(int taskId, int reqId, int currUserId, String timeStamp, String currDocs, String updateReason,
			String updateReqType, String updateGradeType, String updateGradePass, double updateAmt, int updateStage) {
		super();
		this.taskId = taskId;
		this.reqId = reqId;
		this.currUserId = currUserId;
		this.timeStamp = timeStamp;
		this.currDocs = currDocs;
		this.updateReason = updateReason;
		this.updateReqType = updateReqType;
		this.updateGradeType = updateGradeType;
		this.updateGradePass = updateGradePass;
		this.updateAmt = updateAmt;
		this.updateStage = updateStage;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getReqId() {
		return reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	public int getCurrUserId() {
		return currUserId;
	}

	public void setCurrUserId(int currUserId) {
		this.currUserId = currUserId;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getCurrDocs() {
		return currDocs;
	}

	public void setCurrDocs(String currDocs) {
		this.currDocs = currDocs;
	}

	public String getUpdateReason() {
		return updateReason;
	}

	public void setUpdateReason(String updateReason) {
		this.updateReason = updateReason;
	}

	public String getUpdateReqType() {
		return updateReqType;
	}

	public void setUpdateReqType(String updateReqType) {
		this.updateReqType = updateReqType;
	}

	public String getUpdateGradeType() {
		return updateGradeType;
	}

	public void setUpdateGradeType(String updateGradeType) {
		this.updateGradeType = updateGradeType;
	}

	public String getUpdateGradePass() {
		return updateGradePass;
	}

	public void setUpdateGradePass(String updateGradePass) {
		this.updateGradePass = updateGradePass;
	}

	public double getUpdateAmt() {
		return updateAmt;
	}

	public void setUpdateAmt(double updateAmt) {
		this.updateAmt = updateAmt;
	}

	public int getUpdateStage() {
		return updateStage;
	}

	public void setUpdateStage(int updateStage) {
		this.updateStage = updateStage;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", reqId=" + reqId + ", currUserId=" + currUserId + ", timeStamp=" + timeStamp
				+ ", currDocs=" + currDocs + ", updateReason=" + updateReason + ", updateReqType=" + updateReqType
				+ ", updateGradeType=" + updateGradeType + ", updateGradePass=" + updateGradePass + ", updateAmt="
				+ updateAmt + ", updateStage=" + updateStage + "]";
	}

}
