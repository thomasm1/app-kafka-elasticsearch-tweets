package app.mapl.models.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
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

    public String getValue() {
        return value;
    }


}
