package app.mapl.models;

public class RequestContext {
    private static final ThreadLocal<Long> userId = new ThreadLocal<>();

    private RequestContext() {
    }
    public static void start() {
        userId.remove();
    }
    public static Long getUserId() {
        return userId.get();
    }
    public static void setUserId(Long id) {
        userId.set(id);
    }

}
