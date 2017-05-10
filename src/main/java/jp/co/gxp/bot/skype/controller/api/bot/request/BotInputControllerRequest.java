package jp.co.gxp.bot.skype.controller.api.bot.request;

import jp.co.gxp.bot.skype.domain.skype.SkypeMessage;
import jp.co.gxp.bot.skype.domain.skype.SkypeRoomUndefined;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * BotInputControllerのリクエスト
 */
public class BotInputControllerRequest {
    
    private Map<String, Object> body;
    private Map<String, Object> headers;
    
    @NotBlank
    public String getTextString() {
        return body.get("text").toString();
    }
    
    @NotNull
    public String getRoomString() {
        Object conversation = body.get("conversation");
        if (!(conversation instanceof Map)) {
            return null;
        }
        Map<String, Object> c = (Map<String, Object>) conversation;
        if (c.containsKey("id")) {
            return c.get("id").toString();
        }
        return null;
    }
    
    public SkypeMessage getMessage() {
        return new SkypeMessage(getTextString());
    }
    
    public SkypeRoomUndefined getRoom() {
        return new SkypeRoomUndefined(getRoomString());
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
