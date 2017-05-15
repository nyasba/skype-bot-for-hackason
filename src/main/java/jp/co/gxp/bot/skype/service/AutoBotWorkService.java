package jp.co.gxp.bot.skype.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.gxp.bot.skype.domain.cleanUp.CleanUpDuty;
import jp.co.gxp.bot.skype.domain.skype.SkypeBotApiAccessToken;
import jp.co.gxp.bot.skype.domain.skype.SkypeMessage;
import jp.co.gxp.bot.skype.domain.skype.SkypeRoomDefined;
import jp.co.gxp.bot.skype.domain.weather.TomorrowWeather;
import jp.co.gxp.bot.skype.repository.skype.SkypeBotRepository;

@Service
public class AutoBotWorkService {

	@Autowired
	private SkypeBotRepository skypeBotRepository;

	public void makeNotice(SkypeRoomDefined room) {

		// Dateオブジェクト生成
		LocalDate date = LocalDate.now();	// 今日の日付を取得する
		date.plusDays(1);					// 日付を1日進め、明日の日付を取得

		// 取得した日付が休日ではないかチェックする
		// 休日だった場合、翌週の月曜日に日付を設定する
		if(date.getDayOfWeek().getValue()==6) {
			date.plusDays(2);
		}
		if(date.getDayOfWeek().getValue()==7) {
			date.plusDays(1);
		}

		CleanUpDuty cleanUpDuty = new CleanUpDuty("A", "B", "C");	// Repositoryから担当者名を取得する

		String place = "130010";     // 位置情報送信 考える

		TomorrowWeather tomorrowWeather = new TomorrowWeather("晴れ");	// 明日の天気情報取得

		SkypeMessage message = new SkypeMessage("明日の掃除は\r\nAグループ：" + cleanUpDuty.getNameA() + "さん\r\nBグループ：" +
				 cleanUpDuty.getNameB() + "さん\r\nCグループ：" + cleanUpDuty.getNameC() + "さん　です。\r\n明日の天気は「" +
				 tomorrowWeather.getValue() + "」です。");

		//SkypeMessage message = new SkypeMessage("test");

		// トークン生成
		SkypeBotApiAccessToken accessToken = skypeBotRepository.auth();

		skypeBotRepository.postMessage(accessToken, room, message);
	}

}