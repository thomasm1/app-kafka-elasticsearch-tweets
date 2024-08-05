package app.mapl.models;

import app.mapl.util.Shareable;
import lombok.*;

import javax.persistence.*;


@Data
@Entity
@Table(name = "weblinks")
public class Weblink extends Bookmark implements Shareable {
	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ID_MAKER" )
//	@SequenceGenerator(name = "ID_MAKER", sequenceName = "ID_MAKER", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;
	private String url;
	private String host;
	@Column(name="htmlpage")
	private String htmlPage;
	@Column(name="downloadstatus")
	private DownloadStatus downloadStatus = DownloadStatus.NOT_ATTEMPTED;

	public enum DownloadStatus {
		NOT_ATTEMPTED,
		SUCCESS,
		FAILED,
		NOT_ELIGIBLE;
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
	@Override
	public boolean isWeb3Link() {
		return true;
	}

}
