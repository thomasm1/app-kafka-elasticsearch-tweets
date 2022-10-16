package models;

import org.apache.commons.lang3.StringUtils;
import util.Shareable;

public class Weblink extends Bookmark implements Shareable {
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


	@Override
	public String getItemData() {
		StringBuilder builder = new StringBuilder();
		builder.append("<item>");
		builder.append("<type>WebLink</type>");
		builder.append("<title>").append(getTitle()).append("</title>");
		builder.append("<url>").append(url).append("</url>");
		builder.append("<host>").append(host).append("</host>");
		builder.append("</item>");
		return builder.toString();
	}
}
