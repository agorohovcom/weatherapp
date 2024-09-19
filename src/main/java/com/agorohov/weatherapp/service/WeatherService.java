package com.agorohov.weatherapp.service;

import com.agorohov.weatherapp.model.Weather;

public interface WeatherService {
    Weather getWeather(String city);
}
