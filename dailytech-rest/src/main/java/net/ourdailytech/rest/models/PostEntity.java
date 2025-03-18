package net.ourdailytech.rest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(
		name = "post_entity",
		uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})}
)
public class PostEntity {

	public static class SimplePost {
		Long id = 0L;
		String did = "";
		String title = "";
		String post = "";
		String blogcite = "";
		String author = "";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "did", nullable = false)
	private String did;

	@Column(name = "post_date")
	private String date;

	@Column(name = "author")
	private String author; // Optionally convert to an Author entity

	@Column(name = "month_order")
	private String monthOrder;

	@Column(name = "cat3")
	private String cat3;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "post", nullable = false, length = 3000)
	private String post;

	@Column(name = "blogcite", nullable = false, length = 1000)
	private String blogcite;

	@Column(name = "email")
	private String email;

	@Column(name = "state")
	private String state;

	@Column(name = "word_count")
	private int wordCount;

	@Column(name = "duration_goal")
	private int durationGoal;

	// Many posts can belong to one Category
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	@ToString.Exclude
	@JsonIgnore
	private Category category;

	// One PostEntity can have many Comment
	@ToString.Exclude  // ✅ Prevents infinite recursion
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true )
	private Set<Comment> comments = new HashSet<>();

	@JsonIgnore // ✅ Prevents infinite recursion when serializing JSON
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_userid") // ✅ Fixed JoinColumn to match `users.userid`
	@ToString.Exclude // ✅ Prevents infinite recursion in @ToString
	private User user;

}

