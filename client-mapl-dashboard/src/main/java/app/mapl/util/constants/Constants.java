package app.mapl.util.constants;

public class Constants {
    public static final String AUTHORITIES = "authorities";
    public static final String EMPTY_VALUE = "empty";
    public static final String ROLE = "role";
    public static final String ROLE_PREFIX = "ROLE_";
    public static final String AUTHORITY_DELIMITER = ",";
    public static final String USER_AUTHORITIES ="document:read, document:update, document:create, document:delete";
    public static final String USER  ="document:read, document:update, document:create, document:delete";
    public static final String ADMIN_AUTHORITIES = "user:read, user:update, user:create,      document:read, document:update, document:create";
    public static final String ADMIN = "user:read, user:update, user:create, user:delete,     document:read, document:update, document:create, document:delete";

    public static final String SUPER_ADMIN_AUTHORITIES = "document:read, document:update, document:create, document:delete,  user:read, user:update, user:create, user:delete"; //,  role:read, role:update, role:create, role:delete,";
    public static final String MANAGER_AUTHORITIES ="document:read, document:update, document:create, document:delete";


    public static final String READER =" user:read,    document:read  ";
    public static final String EDITOR =" user:read, user:update,    document:read, document:update";
    public static final String DEVELOPER  = "user:read, user:update, user:create,    document:read, document:update, document:create ";
}
