package app.mapl.models.auth;

public enum TokenType {

    ACCESS_TOKEN ("access-token"),
    REFRESH_TOKEN("refresh-token");
    private final String value;

     TokenType(String value) {
        this.value = value;
        }

public String getValue() {
        return value;
        }

}
