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

	private void postMessage(SkypeBotApiAccessToken token, SkypeRoomUndefined room, SkypeMessage message) {

		skypeBotRepository.postMessage(token, room, message);
	}

	public void makeMessage(SkypeBotApiAccessToken token, SkypeRoomUndefined room, SkypeMessage message) {

		// 文字列を反転させて返すよ
		StringBuffer sb = new StringBuffer(message.getValue());
		String newMessage = sb.reverse().toString();

		this.postMessage(token, room, new SkypeMessage(newMessage));
	}

}
