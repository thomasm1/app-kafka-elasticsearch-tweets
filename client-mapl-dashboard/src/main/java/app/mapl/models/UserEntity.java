package app.mapl.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.netty.handler.codec.socks.SocksAuthRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT) // NON_ABSENT, NON_EMPTY, NON_NULL
@Entity
@Table(name= "USER_ENTITY")
public class UserEntity extends BaseModel {
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "id")
//	private long id;
	private String userId;
	private String firstName;
	private String lastName;
	@Column(unique = true, nullable = false)
	private String email;

	@JsonIgnore
	private String password;

	private Integer loginAttempts;
	private LocalDateTime lastLogin;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean enabled;
	private boolean mfa;
	@JsonIgnore
	private String qrCodeSecret;
	@Column(columnDefinition = "text")
	private String qrCodeImageUri;
	private String dashboardCode;
	private String organizationCode;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "USERS_ROLES",
			joinColumns = @JoinColumn(
					name = "id", referencedColumnName = "id"),
					inverseJoinColumns = @JoinColumn(
							name = "role_id", referencedColumnName = "id"))
	private RoleEntity role;

//	private Set<User> roles = new HashSet<>();  // ADMIN, USER, READER, EDITOR, DEVELOPER

}
