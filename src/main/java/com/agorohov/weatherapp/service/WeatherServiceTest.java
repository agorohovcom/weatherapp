package com.agorohov.weatherapp.service;

import com.agorohov.weatherapp.model.Weather;
import com.agorohov.weatherapp.model.WeatherMain;
import com.agorohov.weatherapp.model.WeatherWind;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Profile("!production")
public class WeatherServiceTest implements WeatherService {
    @Override
    public Weather getWeather(String city) {
        Weather weather = new Weather();
        WeatherMain weatherMain = new WeatherMain();
        weatherMain.setHumidity(BigDecimal.ONE);
        weatherMain.setTemp(BigDecimal.ONE);
        WeatherWind weatherWind = new WeatherWind();
        weatherWind.setSpeed(BigDecimal.ONE);
        weatherWind.setDeg(1);
        weather.setMain(weatherMain);
        weather.setWind(weatherWind);
        return weather;
    }
}