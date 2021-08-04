package com.app.controllers;


import com.app.dao.interfaces.WeatherDbEntityDAO;

import com.app.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;

@RestController
@RequestMapping("/weather")
public class RestWeatherController {

    WeatherDbEntityDAO weatherDbEntityDAO;

    @GetMapping(value = "/{city}", produces = MediaType.APPLICATION_JSON_VALUE)
    public WeatherDbEntity getJson(@PathVariable String city) throws IOException {

        return weatherDbEntityDAO.addWeather(city);
    }

    @Autowired
    public void setWeatherDbEntityDAO(WeatherDbEntityDAO weatherDbEntityDAO) {
        this.weatherDbEntityDAO = weatherDbEntityDAO;
    }

}

