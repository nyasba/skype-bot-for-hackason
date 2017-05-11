package jp.co.gxp.bot.skype.repository.skype;

import jp.co.gxp.bot.skype.domain.skype.SkypeBotApiAccessToken;
import jp.co.gxp.bot.skype.domain.skype.SkypeMessage;
import jp.co.gxp.bot.skype.domain.skype.SkypeRoomDefined;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SkypeBotApiRepositoryTest {
    @Autowired
    private SkypeBotRepository skypeBotRepository;
    
    @Ignore
    @Test
    public void postTest() {
        SkypeMessage message = new SkypeMessage("hello, bot");
        
        SkypeBotApiAccessToken accessToken = skypeBotRepository.auth();
        skypeBotRepository.postMessage(accessToken, SkypeRoomDefined.TEST, message);
    }
    
}
