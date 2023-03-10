package com.example.lab8;

import java.util.Objects;

public class City implements Comparable{

    private String city;
    private String province;

    public City(String city, String province){
        this.city = city;
        this.province = province;
    }

    String getCityName(){
        return this.city;
    }

    String getProvinceName(){
        return this.province;
    }
    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }

    @Override
    public boolean equals(Object o) {
        City city = (City) o;
        return Objects.equals(this.city, ((City) o).getCityName()) && Objects.equals(this.province, ((City) o).getProvinceName());
    }
}
