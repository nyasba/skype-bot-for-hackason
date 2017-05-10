package jp.co.gxp.bot.skype.controller.api.bot.request;

import jp.co.gxp.bot.skype.domain.skype.SkypeBotApiAccessToken;
import jp.co.gxp.bot.skype.domain.skype.SkypeMessage;
import jp.co.gxp.bot.skype.domain.skype.SkypeRoomUndefined;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Map;

/**
 * BotInputControllerのリクエスト
 */
public class BotInputControllerRequest {
    
    private Map<String, Object> body;
    private Map<String, Object> headers;
    
    @NotBlank
    public String getTextString() {
        if (!body.containsKey("text")) {
            return null;
        }
        return body.get("text").toString()
                .replace("@" + getBotNameString() + " ", "");
    }
    
    @NotBlank
    public String getRoomString() {
        Object conversation = body.get("conversation");
        if (!(conversation instanceof Map)) {
            return null;
        }
        Map<String, Object> c = (Map<String, Object>) conversation;
        if (!c.containsKey("id")) {
            return null;
        }
        return c.get("id").toString();
    }
    
    @NotBlank
    public String getBotNameString() {
        Object recipient = body.get("recipient");
        if (!(recipient instanceof Map)) {
            return null;
        }
        Map<String, Object> r = (Map<String, Object>) recipient;
        if (!r.containsKey("name")) {
            return null;
        }
        return r.get("name").toString();
    }
    
    @NotBlank
    public String getAuthTokenString() {
        if (!headers.containsKey("Authorization")) {
            return null;
        }
        return body.get("Authorization").toString()
                .replace("Bearer ", "");
    }
    
    public SkypeMessage getMessage() {
        return new SkypeMessage(getTextString());
    }
    
    public SkypeRoomUndefined getRoom() {
        return new SkypeRoomUndefined(getRoomString());
    }
    
    public SkypeBotApiAccessToken getToken() {
        return new SkypeBotApiAccessToken(getAuthTokenString());
    }
    
    
    public void setBody(Map<String, Object> body) {
        this.body = body;
    }
    
    public void setHeaders(Map<String, Object> headers) {
        this.headers = headers;
    }
    
    @Override
    public String toString() {
        return "BotInputControllerRequest{" +
                "body=" + body +
                ", headers=" + headers +
                '}';
    }
}
