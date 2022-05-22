package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    /**
     * This function is used to add a city name to CityList
     */

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(false).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(false).size());
        assertTrue(cityList.getCities(false).contains(city));
    }

    /**
     * This function is used to identify exceptions of add operation.
     */

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    /**
     * This function is used to delete a city name from CityList
     */

    @Test
    public void testDelete() {
        CityList cityList = new CityList();
        City city1 = new City("Edmonton", "AB");
        City city2 = new City("Chittagong", "CH");
        cityList.add(city1);
        cityList.add(city2);

        cityList.delete(city1);

        assertFalse(cityList.getCities(false).contains(city1));
    }

    /**
     * This function is used to identify the exceptions of delete operation.
     */

    @Test
    public void testDeleteException() {
        CityList cityList = new CityList();
        City city1 = new City("Edmonton", "AB");
        City city2 = new City("Chittagong", "CH");
        cityList.add(city1);
        cityList.add(city2);

        cityList.delete(city1);
        assertEquals(1,cityList.count());

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city1);
        });
    }

    /**
     * This function is used to get the city names
     */

    @Test
    public void testGetCities() {
        CityList cityList = new CityList();
        City city1 = new City("Admonton", "ED");
        City city2 = new City("Chittagong", "CH");
        cityList.add(city1);
        assertEquals(0, city1.compareTo(cityList.getCities(false).get(0)));

        cityList.add(city2);

        assertEquals(0, city2.compareTo(cityList.getCities(true).get(0)));
        assertEquals(0, city1.compareTo(cityList.getCities(true).get(1)));
    }
}
