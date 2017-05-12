package jp.co.gxp.bot.skype.domain.skype;

/**
 * Skypeメッセージ
 */
public class SkypeMessage {
    private final String value;
    
    public SkypeMessage(String value) {
        this.value = value;
    }
    
    public String getType() {
        return "message/text";
    }
    
    public String getValue() {
        return value;
    }

    /**
     * メッセージを反転した新しいSkypeMessageオブジェクトを戻します
     * @return SkypeMessage
     */
    public SkypeMessage getReverseMessage() {
        StringBuffer sb = new StringBuffer(this.getValue());
        String reverseString = sb.reverse().toString();
        return new SkypeMessage(reverseString);
    }
}
