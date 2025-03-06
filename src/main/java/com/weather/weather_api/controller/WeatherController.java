package com.weather.weather_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weather.weather_api.service.WeatherService;


@RestController
@RequestMapping("/api/v1/weather")
@CrossOrigin(origins = "http://localhost:5173")  // Update with the correct frontend URL
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @GetMapping("/")
    public Object getCityWeather(@RequestParam String city){
        return weatherService.getCityWeather(city);
    }
}
