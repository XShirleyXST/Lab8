package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import android.util.Log;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    @Before
    public CustomList MockCityList(){
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));

        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    public void testHasCity() {
        list = MockCityList();
        list.addCity(new City("Estevan", "SK"));
        assertTrue(list.hasCity(new City("Estevan", "SK")));
        assertFalse(list.hasCity(new City("Regina", "SK")));

    }

    @Test
    public void testDelete(){
        list = MockCityList();
        City cityToDelete = new City("Edmonton", "AB");
        list.addCity(cityToDelete);
        int listSizeBeforeDeletion = list.getCount();
        assertTrue(list.hasCity(cityToDelete));
        list.delete(cityToDelete);
        assertFalse(list.hasCity(cityToDelete));
        assertEquals(listSizeBeforeDeletion - 1, list.getCount());
        assertThrows(IllegalArgumentException.class, () -> {
            list.delete(cityToDelete);
        });
    }
}
