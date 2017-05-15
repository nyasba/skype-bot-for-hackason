package jp.co.gxp.bot.skype.service;

import jp.co.gxp.bot.skype.domain.onichan.OnichanResponseMessage;
import jp.co.gxp.bot.skype.domain.skype.SkypeBotApiAccessToken;
import jp.co.gxp.bot.skype.domain.skype.SkypeMessage;
import jp.co.gxp.bot.skype.domain.skype.SkypeRoomUndefined;
import jp.co.gxp.bot.skype.repository.skype.SkypeBotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Skypeへメッセージ投稿するサービス
 */
@Service
public class OnichanResponseService {
    @Autowired
    private SkypeBotRepository skypeBotRepository;
    
    public void postMessage(SkypeRoomUndefined room, SkypeMessage message) {
        
        // あまりよくないオブジェクト構成だが、既存のクラスに影響を与えないように多少無理やり。
        OnichanResponseMessage responseMessage = new OnichanResponseMessage(message);
        
        SkypeBotApiAccessToken accessToken = skypeBotRepository.auth();
        skypeBotRepository.postMessage(accessToken, room, responseMessage.getMessage());
    }
}
