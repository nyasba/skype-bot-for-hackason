package jp.co.gxp.bot.skype.repository.skype;

import jp.co.gxp.bot.skype.domain.skype.SkypeMessage;

/**
 * MicrosoftBotFrameworkのPostMessageEndpointのリクエスト
 */
public class SkypeBotApiPostRequest {
    
    private String type;
    private String text;
    
    public SkypeBotApiPostRequest(SkypeMessage message) {
        this.type = message.getType();
        this.text = message.getValue();
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
}
