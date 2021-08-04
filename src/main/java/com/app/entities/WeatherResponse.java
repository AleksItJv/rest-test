package com.app.entities;

public class WeatherResponse {

    private String name;
    private String time;
    private Coord coord;
    private Weather weather;

    public WeatherResponse() {
    }

    public WeatherResponse(String name, String time, Coord coord, Weather weather) {
        this.name = name;
        this.time = time;
        this.coord = coord;
        this.weather = weather;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "Wather{" +
                ", name='" + name + '\'' +
                ", date=" + time +
                ", coord=" + coord +
                ", weather=" + weather +
                '}';
    }
}