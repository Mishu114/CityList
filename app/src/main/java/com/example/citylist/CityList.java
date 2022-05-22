package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     *      Return the sorted list of cities
     */
    public List<City> getCities(boolean sortByProvince) {

        List<City> cityList = cities;
        if(sortByProvince){
            Collections.sort(cityList, new Comparator<City>() {
                @Override
                public int compare(City c1, City c2) {
                    return c1.getProvinceName().compareTo(c2.getProvinceName());
                }
            });
        }else{
            Collections.sort(cityList);
        }

        return cityList;
    }

    /**
     *  This deletes a city from CityList
     */

    public void delete(City city){
        if(cities.contains(city)){
            cities.remove(city);
        }else{
            throw new IllegalArgumentException();
        }
    }
    /**
     * This returns the number of cities
     * @return
     *      Return the number of cities
     */

    public int count(){
        return cities.size();
    }
}
