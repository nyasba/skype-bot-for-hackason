package jp.co.gxp.bot.skype.repository.weather;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestOperations;

import jp.co.gxp.bot.skype.domain.weather.TomorrowWeather;
import jp.co.gxp.bot.skype.repository.skype.SkypeBotRepository;

@Repository
public class LivedoorWeatherApiRepository {

	private final RestOperations restOperations;

	private static Logger logger = LoggerFactory.getLogger(SkypeBotRepository.class);

    public LivedoorWeatherApiRepository(RestTemplateBuilder restTemplateBuilder) {
        this.restOperations = restTemplateBuilder.build();
    }

	public TomorrowWeather getWeather(String cityCode) {


		String urlstr = "http://weather.livedoor.com/forecast/webservice/json/v1";
		String parameter = "city=" + cityCode;		//東京都のcity番号

		try {
		URI url = new URI(urlstr + "?" + parameter);

		ResponseEntity<LivedoorWeatherApiResponse> response = restOperations.getForEntity(url,  LivedoorWeatherApiResponse.class);

			logger.info("*****************************************************");
			logger.info("result : " + response.getBody().toString());
			logger.info("*****************************************************");

			logger.info(response.getBody().getTomorrowWeather());

			return new TomorrowWeather(response.getBody().getTomorrowWeather());

		} catch (Exception ex) {

			logger.info("*****************************************************");
			logger.info("ERROR : " + ex.getMessage());
			logger.info("*****************************************************");


		}
		return new TomorrowWeather("Failed to get the weather.");
	}
}
