package com.weather.weather_api.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Repository
public class WeatherRepository {

    @Value("${weather.api.accesskey}")
    String accessKey;

    public Object getCityWeather(String city){
        // 1. Create URL
        String url = "https://api.weatherstack.com/current?" + "access_key=" + accessKey
                + "&" + "query=" + city;
        URI finalURL = URI.create(url);
        // Create request -> RequestEntity
        RequestEntity request = RequestEntity.get(finalURL).build();
        // Hit The request
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> response  = restTemplate.exchange(finalURL, HttpMethod.GET, request, Object.class);
        return response.getBody();
    }
}

// import java.net.URI;
// import java.net.URISyntaxException;
// import java.net.URLEncoder;
// import java.nio.charset.StandardCharsets;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.http.HttpMethod;
// import org.springframework.http.RequestEntity;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Repository;
// import org.springframework.web.client.RestTemplate;

// @Repository
// public class WeatherRepository {

//     // @Value("${weather.api.accessKey}")
//     // private String accessKey;

//     private final String accessKey = "3c4996be3f59c8f25d5dc880c51ef674";

//     public String getCityWeather(String city) {
//         try {
//             // Encode the city name to handle spaces and special characters
//             String encodedCity = URLEncoder.encode(city, StandardCharsets.UTF_8);
            
//             // Construct the URL with properly encoded query parameters
//             String url = String.format("https://api.weatherstack.com/current?access_key=%s&query=%s", accessKey, encodedCity);

//             URI uri = new URI(url);
//             RestTemplate restTemplate = new RestTemplate();
//             return restTemplate.getForObject(uri, String.class);

//         } catch (URISyntaxException e) {
//             throw new RuntimeException("Invalid URL", e);
//         } catch (Exception e) {
//             throw new RuntimeException("Failed to fetch weather data", e);
//         }
//     }
// }


// package com.weather.weather_api.repository;

// import java.net.URI;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.http.HttpMethod;
// import org.springframework.http.RequestEntity;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Repository;
// import org.springframework.web.client.RestTemplate;

// @Repository
// public class WeatherRepository {

//     @Value("${weather.api.accessKey}")
//     String accessKey;
//     public Object getCityWeather(String city){
//         //create url
//         // Correct URL encoding for the query parameters
//         String url = "https://api.weatherstack.com/current?access_key=" + accessKey + "&"+"query=" + city;
//         //converting url to URI b'z java read url in terms of URI
//         URI finalURL=URI.create(url);

//         //create request->RequestEntity
//         RequestEntity<Void> request=RequestEntity.get(finalURL).build();

//         //hit the request
//         RestTemplate restTemplate=new RestTemplate();
//         ResponseEntity<Object> response= restTemplate.exchange(finalURL, HttpMethod.GET,request, Object.class);

//         return response.getBody();

//     }
    
// }
