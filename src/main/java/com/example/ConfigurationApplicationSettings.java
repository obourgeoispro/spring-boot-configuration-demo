package com.example;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.net.URL;

@Component
@ConfigurationProperties(prefix = "configuration-app")
public class ConfigurationApplicationSettings {
    @NotNull
    private URL apiUrl;
    @NotNull
    private String apiKey;
    @NotNull
    private String apiUser;
    @Digits(integer = 12, fraction = 0)
    private int connectionTimeout;
    private boolean useSSL;

    public URL getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(URL apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiUser() {
        return apiUser;
    }

    public void setApiUser(String apiUser) {
        this.apiUser = apiUser;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public boolean isUseSSL() {
        return useSSL;
    }

    public void setUseSSL(boolean useSSL) {
        this.useSSL = useSSL;
    }

    @Override
    public String toString() {
        return "ConfigurationApplicationSettings{" +
                "apiUrl=" + apiUrl +
                ", apiKey='" + apiKey + '\'' +
                ", apiUser='" + apiUser + '\'' +
                ", connectionTimeout=" + connectionTimeout +
                ", useSSL=" + useSSL +
                '}';
    }
}