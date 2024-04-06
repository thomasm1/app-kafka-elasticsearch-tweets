package app.mapl.models;

public class RequestContext {
    private static final ThreadLocal<Long> USER_ID = new ThreadLocal<>();

    private RequestContext() {
    }
    public static void start() {
        USER_ID.remove();
    }
    public static Long getUserId() {
        return USER_ID.get();
    }
    public static void setUserId(Long id) {
        USER_ID.set(id);
    }

}
