package app.mapl.models.auth;

import java.util.List;

import static app.mapl.util.constants.Constants.ADMIN_AUTHORITIES;
import static app.mapl.util.constants.Constants.MANAGER_AUTHORITIES;
import static app.mapl.util.constants.Constants.SUPER_ADMIN_AUTHORITIES;
import static app.mapl.util.constants.Constants.USER_AUTHORITIES;

public enum Authority {
    USER(USER_AUTHORITIES),
    ADMIN(ADMIN_AUTHORITIES),
    SUPER_ADMIN(SUPER_ADMIN_AUTHORITIES),
    MANAGER(MANAGER_AUTHORITIES);
    private final String value;

    Authority(String value) {
        this.value = value;
    }

    public List<Authority> getValue() {
       return List.of(Authority.values());
    }



}
