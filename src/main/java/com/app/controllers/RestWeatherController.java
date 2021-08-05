package com.app.controllers;


import com.app.interfaces.WeatherServiceInterface;

import com.app.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;

@RestController
@RequestMapping("/weather")
public class RestWeatherController {

    WeatherServiceInterface weatherServiceInterface;

    @GetMapping(value = "/{city}", produces = MediaType.APPLICATION_JSON_VALUE)
    public WeatherDbEntity getJson(@PathVariable String city) throws IOException {

        return weatherServiceInterface.addWeather(city);
    }

    @Autowired
    public void setWeatherServiceInterface(WeatherServiceInterface weatherServiceInterface) {
        this.weatherServiceInterface = weatherServiceInterface;
    }

}

