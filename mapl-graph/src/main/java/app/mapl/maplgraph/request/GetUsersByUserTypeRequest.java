package app.mapl.maplgraph.request;

import java.util.List;

public class GetUsersByUserTypeRequest {

	private List<Integer> userTypeList;

	public List<Integer> getUserTypeList() {
		return userTypeList;
	}

	public void setUserTypeList(List<Integer> userTypeList) {
		this.userTypeList = userTypeList;
	}

}
