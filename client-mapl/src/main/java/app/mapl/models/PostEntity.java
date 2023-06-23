package app.mapl.models;

import lombok.*;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
@Table(
		name = "POST_ENTITY", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})}
)
public class PostEntity {

    public interface SimplePost {
		String getTitle();
//		@Value("#{target.author.name}")  //TODO MAKE AUTHOR OBJECT
		String getAuthor();
		String getPost();
		String getCat3();
		String getBlogcite();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Long id;

	@Column(name = "DID", nullable = false)
	private String did;

	@Column(name = "DATE_")
	private String date;

	@Column(name = "AUTHOR")
	private String author; //TODO MAKE AUTHOR OBJECT

	@Column(name = "CAT3")
	private String cat3;

	@Column(name = "TITLE", nullable = false)
	private String title;

	@Column(name = "POST", nullable = false)
	private String post;

	@Column(name = "BLOGCITE", nullable = false)
	private String blogcite;

	@Column(name = "USERNAME", nullable = false)
	private String username;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CATEGORY_ID")
	private Category category;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Comment> comments = new HashSet<>();


}
