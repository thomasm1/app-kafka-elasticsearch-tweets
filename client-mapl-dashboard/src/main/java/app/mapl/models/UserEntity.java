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

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
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
public class UserEntity extends BaseModel {
	@Serial
	private static final long serialVersionUID = 1L;

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
//	private boolean credentialsNonExpired;
	private boolean accountNonLocked;
	private boolean enabled;
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

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "USER_ROLES",
			joinColumns = @JoinColumn(
					name = "id", referencedColumnName = "id"),
					inverseJoinColumns = @JoinColumn(
							name = "role_id", referencedColumnName = "id"))
	private RoleEntity role;

//	prfivate Set<User> roles = new HashSet<>();  // ADMIN, USER, READER, EDITOR, DEVELOPER
public static UserEntity buildUserEntity(String firstName, String lastName, String email, RoleEntity role) {
	return UserEntity.builder()
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
			.qrCodeSecret(EMPTY_STRING)
//			.qrCodeImageUri(EMPTY_STRING)
			.phone(EMPTY_STRING)
			.bio(EMPTY_STRING)
			.imageUrl("https://s3.amazonaws.com/friendsofgroot.com/assets/groot.png")
			.dashboardCode("userEntity.getDashboardCode()")
			.organizationCode("userEntity.getOrganizationCode()")
			.role(role)
			.build();
}
	public static UserEntity from(UserEntity userEntity) {
		return UserEntity.builder()
				.userId(userEntity.getUserId())
				.firstName(userEntity.getFirstName())
				.lastName(userEntity.getLastName())
				.email(userEntity.getEmail())
				.password(userEntity.getPassword())
				.loginAttempts(userEntity.getLoginAttempts())
				.lastLogin(userEntity.getLastLogin())
				.accountNonExpired(userEntity.isAccountNonExpired())
				.accountNonLocked(userEntity.isAccountNonLocked())
				.enabled(userEntity.isEnabled())
				.mfa(userEntity.isMfa())
				.qrCodeSecret(userEntity.getQrCodeSecret())
				.qrCodeImageUri(userEntity.getQrCodeImageUri())
				.dashboardCode(userEntity.getDashboardCode())
				.organizationCode(userEntity.getOrganizationCode())
				.role(userEntity.getRole())
				.build();
	}

}
