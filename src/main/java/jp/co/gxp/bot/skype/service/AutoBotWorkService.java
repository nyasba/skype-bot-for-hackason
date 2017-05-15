package jp.co.gxp.bot.skype.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.gxp.bot.skype.domain.cleanUp.CleanUpDuty;
import jp.co.gxp.bot.skype.domain.skype.SkypeBotApiAccessToken;
import jp.co.gxp.bot.skype.domain.skype.SkypeMessage;
import jp.co.gxp.bot.skype.domain.skype.SkypeRoomDefined;
import jp.co.gxp.bot.skype.domain.weather.TomorrowWeather;
import jp.co.gxp.bot.skype.repository.skype.CleanStaffRepositoryInpl;
import jp.co.gxp.bot.skype.repository.skype.SkypeBotRepository;
import jp.co.gxp.bot.skype.repository.weather.LivedoorWeatherApiRepository;

@Service
public class AutoBotWorkService {

	@Autowired
	private SkypeBotRepository skypeBotRepository;

	@Autowired
	private LivedoorWeatherApiRepository livedoorWeatherApiRepository;

	@Autowired
	private CleanStaffRepositoryInpl cleanStaffRepositoryInpl;

	public void makeNotice(SkypeRoomDefined room) {

		String next = "来週";

		// Dateオブジェクト生成
		LocalDate date = LocalDate.now();	// 今日の日付を取得する
		date = date.plusDays(1);					// 日付を1日進め、明日の日付を取得

		// 取得した日付が休日ではないかチェックする
		// 休日だった場合、翌週の月曜日に日付を設定する
		if(date.getDayOfWeek().getValue()==6) {
			date = date.plusDays(2);
		}
		else if(date.getDayOfWeek().getValue()==7) {
			date = date.plusDays(1);
		}
		else {
			next = "明日";
		}

		CleanUpDuty cleanUpDuty = cleanStaffRepositoryInpl.getName(date);	// Repositoryから担当者名を取得する

		TomorrowWeather tomorrowWeather = livedoorWeatherApiRepository.getWeather("130010");	// 明日の天気情報取得

		SkypeMessage message = new SkypeMessage(next + "の掃除は\r\nAグループ：" + cleanUpDuty.getNameA() + "ちゃん\r\nBグループ：" +
				 cleanUpDuty.getNameB() + "ちゃん\r\nCグループ：" + cleanUpDuty.getNameC() + "ちゃん　っす～！Ψ( ｀▽´ )Ψ\r\n明日の天気は「" +
				 tomorrowWeather.getValue() + "」っすよ～！Ψ( ｀▽´ )Ψ");

		//SkypeMessage message = new SkypeMessage("test");

		// トークン生成
		SkypeBotApiAccessToken accessToken = skypeBotRepository.auth();

		skypeBotRepository.postMessage(accessToken, room, message);
	}

}
