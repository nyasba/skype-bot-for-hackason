package jp.co.gxp.bot.skype.repository.skype;

import jp.co.gxp.bot.skype.domain.skype.SkypeBotApiAccessToken;
import jp.co.gxp.bot.skype.domain.skype.SkypeMessage;
import jp.co.gxp.bot.skype.domain.skype.SkypeRoom;

/**
 * SkypeでBotを扱うためのRepository
 */
public interface SkypeBotRepository {
    
    
    SkypeBotApiAccessToken auth();
    
    void postMessage(SkypeBotApiAccessToken accessToken, SkypeRoom room, SkypeMessage message);
    
}
