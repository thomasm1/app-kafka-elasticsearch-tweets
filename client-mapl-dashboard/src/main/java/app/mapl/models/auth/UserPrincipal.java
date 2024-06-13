package app.mapl.models.auth;

import app.mapl.models.dto.UserDto;
import app.mapl.repositories.CredentialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@RequiredArgsConstructor
public class UserPrincipal implements UserDetails {
    private final UserDto userDto;
    private final CredentialEntity credentialEntity;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.commaSeparatedStringToAuthorityList(userDto.getAuthorities().toString());
    }


    @Override
    public String getPassword() {
        return credentialEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userDto.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return userDto.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return userDto.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return userDto.isAccountNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return userDto.isEnabled();
    }
}
