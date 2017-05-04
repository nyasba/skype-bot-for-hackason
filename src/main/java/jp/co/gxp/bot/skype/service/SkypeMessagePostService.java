package jp.co.gxp.bot.skype.service;

import jp.co.gxp.bot.skype.domain.skype.SkypeBotApiAccessToken;
import jp.co.gxp.bot.skype.domain.skype.SkypeMessage;
import jp.co.gxp.bot.skype.domain.skype.SkypeRoom;
import jp.co.gxp.bot.skype.repository.skype.SkypeBotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Skypeへメッセージ投稿するサービス
 */
@Service
public class SkypeMessagePostService {
    @Autowired
    private SkypeBotRepository skypeBotRepository;
    
    public void postMessage(SkypeRoom room, SkypeMessage message) {
        SkypeBotApiAccessToken accessToken = skypeBotRepository.auth();
        skypeBotRepository.postMessage(accessToken, room, message);
    }
}
