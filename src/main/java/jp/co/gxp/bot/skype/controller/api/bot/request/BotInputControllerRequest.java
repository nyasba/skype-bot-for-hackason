package jp.co.gxp.bot.skype.controller.api.bot.request;

import jp.co.gxp.bot.skype.domain.skype.SkypeMessage;
import org.hibernate.validator.constraints.NotBlank;

/**
 * BotInputControllerのリクエスト
 */
public class BotInputControllerRequest {
    
    private String type;
    private String id;
    private String timestamp;
    private String serviceUrl;
    private String channelId;
    
    @NotBlank
    private String text;
    
    public SkypeMessage getMessage() {
        return new SkypeMessage(text);
    }
    
    public void setMessage(String text) {
        this.text = text;
    }
}
