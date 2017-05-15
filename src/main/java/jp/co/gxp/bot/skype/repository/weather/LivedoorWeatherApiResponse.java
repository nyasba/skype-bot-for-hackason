package jp.co.gxp.bot.skype.repository.weather;

import java.util.Arrays;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LivedoorWeatherApiResponse {

	@JsonProperty(value = "forecasts")
    private Map<String,Object>[] forecasts;

	public Object[] getforecasts() {
		return forecasts;
	}

	@Override
	public String toString() {
		return "LivedoorWeatherApiResponse [forecasts=" + Arrays.toString(forecasts) + "]";
	}



	public String getTomorrowWeather(){
		return forecasts[1].get("telop").toString();
	}

}

