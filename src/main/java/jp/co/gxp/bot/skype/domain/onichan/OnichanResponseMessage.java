package jp.co.gxp.bot.skype.domain.onichan;

import jp.co.gxp.bot.skype.domain.skype.SkypeMessage;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class OnichanResponseMessage {
    
    private static final List<String> MESSAGE_LIST = Arrays.asList(
            "ウィッス、ウィッス～",
            "いやっス～",
            "当たり前じゃないっすか～",
            "ウォッ！、カッコいいっすね～",
            "マジカンベンっすよ～",
            "オッシャレ～",
            "だが断る！"
    );
    
    private final SkypeMessage message;
    
    public OnichanResponseMessage(SkypeMessage value) {
        int random = new Random().nextInt(MESSAGE_LIST.size());
        this.message = new SkypeMessage(MESSAGE_LIST.get(random));
    }
    
    public SkypeMessage getMessage() {
        return this.message;
    }
}
