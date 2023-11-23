package app.mapl.config;


@Validated
@ConfigurationProperties(prefix = "app.mapl.client")
@Slf4j
@Data
public class ClientConfig {

    private MaplClientConfig maplClientConfig;

    @Data
    public static class MaplClientConfig {
        private String url;
        private String username;
        private String password;

        private String clientId;
        private String clientSecret;
        private String grantType;
        private String scope;

        private String tokenUrl;
        private String authorizeUrl;
        private String redirectUrl;

        private String logoutUrl;
        private String logoutRedirectUrl;


    }
    @Data
    public String getMaplClientConfig() {
        return maplClientConfig;
    }
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);

    }
}
