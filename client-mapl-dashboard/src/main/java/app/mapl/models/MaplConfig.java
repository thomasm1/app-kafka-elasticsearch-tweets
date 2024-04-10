package app.mapl.models;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Validated
@ConfigurationProperties(prefix = "app.mapl.client")
@Slf4j
@Data
public class MaplConfig {

    private MaplClientConfig maplClientConfig;

    private String message;
    private String newprofile;
    private Map<String, String> keys = new java.util.HashMap<>();

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
    public MaplClientConfig getMaplClientConfig() {
        return maplClientConfig;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);

    }
}
