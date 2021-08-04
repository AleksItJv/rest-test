package com.app.dao.services;

import com.app.dao.interfaces.WeatherDbEntityDAO;
import com.app.dao.repositories.WeatherDbEntityRepository;
import com.app.entities.WeatherDbEntity;
import com.app.entities.WeatherEnt;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class WeatherDbEntityService implements WeatherDbEntityDAO {

    private WeatherDbEntityRepository weatherDbEntityRepository;

    @Override
    public WeatherDbEntity addWeather(String city) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        WeatherEnt weatherEnt = mapper.readValue(new URL(String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=6c01bbd693a8200df2a1c593f2f25ce2", city)), WeatherEnt.class);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        WeatherDbEntity weatherDbEntity = new WeatherDbEntity(
                weatherEnt.getName(),
                ZonedDateTime.now(ZoneOffset.ofTotalSeconds(weatherEnt.getTimezone())).format(formatter),
                weatherEnt.getCoord().getLon(), weatherEnt.getCoord().getLat(),
                weatherEnt.getWeather().get(0).getMain(),
                weatherEnt.getWeather().get(0).getDescription(),
                weatherEnt.getWeather().get(0).getIcon());

        weatherDbEntityRepository.save(weatherDbEntity);
        return weatherDbEntity;
    }

    @Autowired
    public void setWeatherDbEntityRepository(WeatherDbEntityRepository weatherDbEntityRepository) {
        this.weatherDbEntityRepository = weatherDbEntityRepository;
    }
}
