package com.agorohov.weatherapp.service;

import com.agorohov.weatherapp.model.Weather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Profile("production")
public class WeatherServiceProduction implements WeatherService {

    Logger logger = LoggerFactory.getLogger(WeatherServiceProduction.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${weather.url}")
    private String weatherUrl;

    @Value(value = "${weather.api-key}")
    private String weatherApiKey;

    public Weather getWeather(String city) {
        logger.debug("Requesting weather for city: {}", city);
        Weather weather = restTemplate.exchange(
                weatherUrl,
                HttpMethod.GET,
                new HttpEntity<>(HttpHeaders.EMPTY),
                Weather.class,
                city,
                weatherApiKey
        ).getBody();
        logger.debug("The weather for {} is {}", city, weather);
        return weather;
    }
}
