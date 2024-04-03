package app.mapl.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT) // NON_ABSENT, NON_EMPTY, NON_NULL
@Entity
@Table(name= "USER_PROFILE")
public class UserProfile extends BaseModel {

	private String userProfileId;
	private String firstName;
	private String lastName;
	@Column(unique = true, nullable = false)
	private String email;

	@Column(unique = true, nullable = false)
	private String username;
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
	@Column(columnDefinition = "TEXT")
	private String qrCodeImageUri;
	private String dashboardCode;
	private String organizationCode;
	@ManyToMany
	@JoinTable(
			name = "user_profile_role",
			joinColumns = @JoinColumn(name = "user_profile_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
	)
	private Set<Role> roles;  // ADMIN, USER, READER, EDITOR, DEVELOPER


//    ADMIN { user:read, user:update, user:create, user:delete, document:read, document:update, document:create, document:delete }
//    USER { user:read, user:update, document:read, document:update }
//    READER { user:read, document:read }
//    EDITOR { user:read, user:update, document:read, document:update
//        DEVELOPER { user:read, user:update, user:create, user:delete, document:read, document:update, document:create, document:delete }


	
	
}
