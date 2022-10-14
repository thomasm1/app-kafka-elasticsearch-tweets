package models;

public class Weblink extends Bookmark {
	private String url;
	private String host;

	public Weblink(long id, String title, String profileUrl) {
		super(id, title, profileUrl);
	}

	public Weblink() {

	}


	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}

/*  {web3, dapp, crypto} in title
*
 */
//	@Override
//	public boolean isWeb3Link() {
//		return true;
//	}

	@Override
	public String toString() {
		return "Weblink [url=" + url + ", host=" + host + "]";
	}
	
		
}
