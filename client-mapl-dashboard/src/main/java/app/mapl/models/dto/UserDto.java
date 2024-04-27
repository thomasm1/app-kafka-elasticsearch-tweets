package app.mapl.models.dto;

import app.mapl.models.BaseModel;
import app.mapl.models.auth.RoleEntity;
import app.mapl.models.auth.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.util.AlternativeJdkIdGenerator;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static io.netty.util.internal.StringUtil.EMPTY_STRING;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT) // NON_ABSENT, NON_EMPTY, NON_NULL
public class UserDto implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	// base
	private Long id;
	private String referenceId;

	private Integer version; // for optimistic locking

	private Long createdBy;
	private Long updatedBy;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private LocalDate dateCreated;
	private Timestamp lastUpdated;
	private List<User> owner; // instances of same user, multiple user-logins owned by user

	//entity
	private String userId;
	private String firstName;
	private String lastName;
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
	private String qrCodeImageUri;
	private String dashboardCode;
	private String organizationCode;

	private int userType;

	private RoleEntity role;

//	prfivate Set<User> roles = new HashSet<>();  // ADMIN, USER, READER, EDITOR, DEVELOPER
public static UserDto buildUserDto(String firstName, String lastName, String email, RoleEntity role) {
	return UserDto.builder()
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
//			.qrCodeImageUri(EMPTY_STRING)
			.phone(EMPTY_STRING)
			.bio(EMPTY_STRING)
			.imageUrl("https://s3.amazonaws.com/friendsofgroot.com/assets/groot.png")
			.dashboardCode("userEntity.getDashboardCode()")
			.organizationCode("userEntity.getOrganizationCode()")
			.role(role)
			.build();
}
	public static UserDto from(UserDto userDto) {
		return UserDto.builder()
				.userId(userDto.getUserId())
				.firstName(userDto.getFirstName())
				.lastName(userDto.getLastName())
				.email(userDto.getEmail())
				.password(userDto.getPassword())
				.loginAttempts(userDto.getLoginAttempts())
				.lastLogin(userDto.getLastLogin())
				.accountNonExpired(userDto.isAccountNonExpired())
				.accountNonLocked(userDto.isAccountNonLocked())
				.enabled(userDto.isEnabled())
				.mfa(userDto.isMfa())
				.qrCodeSecret(userDto.getQrCodeSecret())
				.qrCodeImageUri(userDto.getQrCodeImageUri())
				.dashboardCode(userDto.getDashboardCode())
				.organizationCode(userDto.getOrganizationCode())
				.role(userDto.getRole())
				.build();
	}

}
