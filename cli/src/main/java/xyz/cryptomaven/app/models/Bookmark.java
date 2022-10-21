package xyz.cryptomaven.app.models;

public class Bookmark {
	private long id;
	private String title;
	private String profileUrl;





	private User sharedBy;

	public Bookmark(long id, String title, String profileUrl) {
		this.id = id;
		this.title = title;
		this.profileUrl = profileUrl;
	}

	public Bookmark() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

//	public abstract boolean isWeb3Link();

	@Override
	public String toString() {
		return "Bookmark [id=" + id + ", title=" + title + ", profileUrl=" + profileUrl + "]";
	}

	public User getSharedBy() {
		return sharedBy;
	}
    public void setSharedBy(User sharedBy) {
	this.sharedBy = sharedBy;
    }
}
