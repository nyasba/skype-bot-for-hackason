package jp.co.gxp.bot.skype.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.gxp.bot.skype.domain.skype.SkypeBotApiAccessToken;
import jp.co.gxp.bot.skype.domain.skype.SkypeMessage;
import jp.co.gxp.bot.skype.domain.skype.SkypeRoomUndefined;
import jp.co.gxp.bot.skype.repository.skype.SkypeBotRepository;

@Service
public class BotWorkService {

	@Autowired
	private SkypeBotRepository skypeBotRepository;


	public void makeMessage(SkypeBotApiAccessToken token, SkypeRoomUndefined room, SkypeMessage message) {
		// トークン生成
		SkypeBotApiAccessToken accessToken = skypeBotRepository.auth();
        skypeBotRepository.postMessage(accessToken, room, message.createReverseMessage());
	}

}
