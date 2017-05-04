package jp.co.gxp.bot.skype.repository.skype;

/**
 * BotFrameworkのアクセストークン
 */
public class SkypeBotApiAccessToken {
    private final String value;
    
    public SkypeBotApiAccessToken(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return "SkypeBotApiAccessToken{" +
                "value='" + value + '\'' +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SkypeBotApiAccessToken)) return false;
        
        SkypeBotApiAccessToken that = (SkypeBotApiAccessToken) o;
        
        return value != null ? value.equals(that.value) : that.value == null;
    }
    
    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
