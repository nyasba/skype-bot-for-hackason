package jp.co.gxp.bot.skype.domain.skype;

/**
 * Skypeルーム(未定義のもの)
 */
public class SkypeRoomUndefined implements SkypeRoom {
    private final String value;
    
    public SkypeRoomUndefined(String value) {
        this.value = value;
    }
    
    @Override
    public String getId() {
        return value;
    }
}
