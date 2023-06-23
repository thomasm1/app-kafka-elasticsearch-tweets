package app.mapl.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "user_account")
public class UserAccount extends BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//, generator="user_accounts_seq")
	@Column(name="userid", nullable = false, unique = true)
	private int userId;

	@Column(name="username" , unique = true )
	private String username;


	private String email;

	private String password;

	private boolean enabled = true;

}
