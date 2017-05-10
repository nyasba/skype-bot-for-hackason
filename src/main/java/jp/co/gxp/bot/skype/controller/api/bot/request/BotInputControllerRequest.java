package jp.co.gxp.bot.skype.controller.api.bot.request;

import jp.co.gxp.bot.skype.domain.skype.SkypeMessage;

import java.util.Map;

/**
 * BotInputControllerのリクエスト
 */
public class BotInputControllerRequest {
    
    private Map<String, Object> body;
    private Map<String, Object> headers;
    
    //    @NotBlank
    public String getText() {
        return body.get("text").toString();
    }
    
    public SkypeMessage getMessage() {
        return new SkypeMessage(getText());
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
