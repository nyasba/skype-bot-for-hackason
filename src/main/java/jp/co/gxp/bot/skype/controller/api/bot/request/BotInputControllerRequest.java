package jp.co.gxp.bot.skype.controller.api.bot.request;

import jp.co.gxp.bot.skype.domain.skype.SkypeMessage;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Map;

/**
 * BotInputControllerのリクエスト
 */
public class BotInputControllerRequest {
    
    private Map<String, String> body;
    private Map<String, String> headers;
    
    @NotBlank
    public String getText() {
        return body.get("text");
    }
    
    public SkypeMessage getMessage() {
        return new SkypeMessage(getText());
    }
    
    public void setBody(Map<String, String> body) {
        this.body = body;
    }
    
    public void setHeaders(Map<String, String> headers) {
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
