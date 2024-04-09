package app.mapl.util.constants;

public class Constants {
    public static final String ROLE_PREFIX = "ROLE_";
    public static final String AUTHORITY_DELIMITER = ",";
    public static final String USER_AUTHORITIES ="document:read, document:update, document:create, document:delete";
    public static final String ADMIN_AUTHORITIES = "document:read, document:update, document:create,   user:read, user:update, user:create,";

    //    ADMIN { user:read, user:update, user:create, user:delete, document:read, document:update, document:create, document:delete }
//    USER { user:read, user:update, document:read, document:update }
//    READER { user:read, document:read }
//    EDITOR { user:read, user:update, document:read, document:update
//        DEVELOPER { user:read, user:update, user:create, user:delete, document:read, document:update, document:create, document:delete }



    public static final String SUPER_ADMIN_AUTHORITIES = "document:read, document:update, document:create, document:delete,  user:read, user:update, user:create, user:delete"; //,  role:read, role:update, role:create, role:delete,";
    public static final String MANAGER_AUTHORITIES ="document:read, document:update, document:create, document:delete";
}
