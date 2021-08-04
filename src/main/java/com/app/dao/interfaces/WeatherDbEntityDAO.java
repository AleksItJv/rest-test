package com.app.dao.interfaces;

import com.app.entities.WeatherDbEntity;

import java.io.IOException;

public interface WeatherDbEntityDAO {

    WeatherDbEntity addWeather(String city) throws IOException;
}
