package xyz.cryptomaven.rest.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "WEBLINKS")
public class Weblink extends AbstractDomainClass implements Bookmark   {

  private static final long serialVersionUID = 1L;
	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ID_MAKER" )
//	@SequenceGenerator(name = "ID_MAKER", sequenceName = "ID_MAKER", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	@Column(name="URL")
	private String url;
	@Column(name="HOST")
	private String host;
	@Column(name="HTMLPAGE")
	private String htmlPage;
	@Column(name="DOWNLOADSTATUS")
	private DownloadStatus downloadStatus = DownloadStatus.NOT_ATTEMPTED;

  @ManyToOne
  @JoinColumn(name = "shared_by_userid")
  private User sharedBy;

  String getTitle() {
    return this.title;
  }

	public enum DownloadStatus {
		NOT_ATTEMPTED,
		SUCCESS,
		FAILED,
		NOT_ELIGIBLE;
	}

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

	public boolean isWeb3Link() {
		return true;
	}

}
