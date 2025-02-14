package com.weather.weather_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weather.weather_api.repository.WeatherRepository;

@Service
public class WeatherService {

    @Autowired
    WeatherRepository weatherRepository;

    public Object getCityWeather(String city){
        return weatherRepository.getCityWeather(city);
    }
}
