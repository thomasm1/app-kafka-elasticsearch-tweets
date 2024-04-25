package app.mapl.models;

import app.mapl.models.auth.User;
import lombok.*;

import jakarta.persistence.*;
import java.io.Serializable;

@Data
public class BookmarkDto implements Serializable {

	private static final long serialVersionUID = 1L;
 	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String title;

	@Column(name="profileurl")
	private String profileUrl;


	@ManyToOne
	@JoinColumn(name = "shared_by_userid")
	private User sharedBy;
}
