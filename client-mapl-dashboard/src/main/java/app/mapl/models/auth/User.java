package app.mapl.models.auth;

import app.mapl.models.BaseModel;
import jakarta.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static io.netty.util.internal.StringUtil.EMPTY_STRING;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT) // NON_ABSENT, NON_EMPTY, NON_NULL
@Entity
@Table(name= "USER_ENTITY")
public class User extends BaseModel {
	@Serial
	private static final long serialVersionUID = 1L;
	@NotBlank
	private String userId;
 	@NotBlank
	private String firstName;
 	@NotBlank
	private String lastName;
	@Column(unique = true, nullable = false)
	private String email;

	@JsonIgnore
	private String password;

	private Integer loginAttempts;
	private LocalDateTime lastLogin;
	private boolean accountNonExpired;
	private boolean credentialsNonExpired;
	private boolean accountNonLocked;
	private boolean enabled;
	private boolean isAuthenticated;
	private boolean mfa;
	private String phone;
	private String bio;
	private String imageUrl;
	@JsonIgnore
	private String qrCodeSecret;
	@Column(columnDefinition = "text")
	private String qrCodeImageUri;
	private String dashboardCode;
	private String organizationCode;

	private int userType;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinTable(
			name = "USER_ROLES",
			joinColumns = @JoinColumn(
					name = "user_id", referencedColumnName = "id"),
					inverseJoinColumns = @JoinColumn(
							name = "role_id", referencedColumnName = "id"))
	private RoleEntity role;
//
//	private Set<RoleEntity> roles = new HashSet<>();  // ADMIN, USER, READER, EDITOR, DEVELOPER
public static User buildUser(String firstName, String lastName, String email, RoleEntity role) {
	return User.builder()
			.userId(UUID.randomUUID().toString())
			.firstName(firstName)
			.lastName(lastName)
			.email(email)
			.lastLogin(LocalDateTime.now())
			.accountNonExpired(true)
			.accountNonLocked(true)
			.mfa(false)
			.enabled(false)
			.loginAttempts(0)
			.qrCodeSecret("EMPTY_STRING")
//			.qrCodeImageUri(EMPTY_STRINsG)
			.phone(EMPTY_STRING)
			.bio(EMPTY_STRING)
			.imageUrl("https://s3.amazonaws.com/friendsofgroot.com/assets/groot.png")
			.dashboardCode("userEntity.getDashboardCode()")
			.organizationCode("userEntity.getOrganizationCode()")
			.role(role)
			.build();
}


}
