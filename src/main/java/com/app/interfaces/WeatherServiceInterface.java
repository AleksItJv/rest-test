package com.app.interfaces;

import com.app.entities.WeatherDbEntity;

import java.io.IOException;

public interface WeatherServiceInterface {

    WeatherDbEntity addWeather(String city) throws IOException;
}
