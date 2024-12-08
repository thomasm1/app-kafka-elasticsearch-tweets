package app.mapl.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;


import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private Long id;

	@Column(name = "DID", nullable = false)
	private String did;

	@Column(name = "DATE_")
	private String date;
	
	@Column(name = "AUTHOR")
	private String author; //TODO MAKE AUTHOR OBJECT
	
	@Column(name = "MONTH_ORDER")
	private String monthOrder;
	
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

//	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
//	private Set<Comment> comments = new HashSet<>();

	
}
