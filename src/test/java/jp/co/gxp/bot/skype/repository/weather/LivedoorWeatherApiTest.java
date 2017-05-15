package jp.co.gxp.bot.skype.repository.weather;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.gxp.bot.skype.repository.weather.LivedoorWeatherApiRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LivedoorWeatherApiTest {

	@Autowired
	private LivedoorWeatherApiRepository repository;

	@Test
	public void getWeather() {

		repository.getWeather("130010");

	}
}
