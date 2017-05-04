package jp.co.gxp.bot.skype.controller.request;

import jp.co.gxp.bot.skype.domain.skype.SkypeMessage;
import jp.co.gxp.bot.skype.domain.skype.SkypeRoom;
import jp.co.gxp.bot.skype.util.validator.EnumString;
import org.hibernate.validator.constraints.NotBlank;

/**
 * SampleControllerのリクエスト
 */
public class SampleControllerRequest {
    
    @EnumString(enumClass = SkypeRoom.class, required = true)
    private String room;
    
    @NotBlank
    private String message;
    
    public SkypeRoom getRoom() {
        return SkypeRoom.convertFromApiValue(room);
    }
    
    public void setRoom(String room) {
        this.room = room;
    }
    
    public SkypeMessage getMessage() {
        return new SkypeMessage(message);
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
}
