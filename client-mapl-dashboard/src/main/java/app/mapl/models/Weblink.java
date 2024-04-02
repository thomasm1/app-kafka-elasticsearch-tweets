package app.mapl.models;

import app.mapl.util.Shareable;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;


@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@Entity
@JsonInclude(NON_DEFAULT)
@Table(name = "WEBLINKS")
public class Weblink extends Bookmark implements Shareable {
	static final long serialVersionUID = 1L;
	private String url;
	@Column(name="htmlpage")
	private String htmlPage;
	@Column(name="downloadstatus")
	private DownloadStatus downloadStatus = DownloadStatus.NOT_ATTEMPTED;

	public Weblink(  String value1,  String value3, String value4) {
				super();
		this.setId(Math.round(Math.random()*1000));
		this.url=value1;
		this.htmlPage=value3;
	 this.downloadStatus= DownloadStatus.valueOf(value4);
	}
	public Weblink(Long value0,  String value1,  String value3 ) {
		super();
		this.setId(value0);
		this.url=value1;
		this.htmlPage=value3;
		this.downloadStatus= DownloadStatus.valueOf("SUCCESS");
	}

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
		builder.append("</item>");
		return builder.toString();
	}
	@Override
	public boolean isWeb3Link() {
		return true;
	}

}
