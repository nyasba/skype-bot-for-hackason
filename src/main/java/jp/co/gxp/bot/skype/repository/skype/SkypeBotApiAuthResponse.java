package jp.co.gxp.bot.skype.repository.skype;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * MicrosoftBotFrameworkのAuthEndpointのレスポンス
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SkypeBotApiAuthResponse {
    
    @JsonProperty(value = "access_token")
    private String accessToken;
    
    public SkypeBotApiAccessToken getAccessToken() {
        return new SkypeBotApiAccessToken(accessToken);
    }
    
    @Override
    public String toString() {
        return "SkypeBotApiAuthResponse{" +
                "accessToken='" + accessToken + '\'' +
                '}';
    }
}
