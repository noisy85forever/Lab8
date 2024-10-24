package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>()); return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    void hasCityTest() {
        CustomList cityList = MockCityList();
        assertEquals(0, cityList.getCount());
        City city = new City("Regina", "Saskatchewan");
        assertFalse(cityList.hasCity(city));
        cityList.addCity(city);
        assertEquals(1, cityList.getCount());
        assertTrue(cityList.hasCity(city));
    }

    @Test
    void testDeleteCity() {
        CustomList cityList = MockCityList();
        assertEquals(0, cityList.getCount());
        City city = new City("Regina", "Saskatchewan");
        cityList.addCity(city);
        assertTrue(cityList.hasCity(city));
        assertEquals(1, cityList.getCount());
        cityList.deleteCity(city);
        assertEquals(0, cityList.getCount());
        assertFalse(cityList.hasCity(city));
    }

    @Test
    void testCountCities() {
        CustomList cityList = MockCityList();
        assertEquals(0, cityList.countCities());
        City city = new City("Regina", "Saskatchewan");
        cityList.addCity(city);
        assertEquals(1, cityList.countCities());
    }

}
