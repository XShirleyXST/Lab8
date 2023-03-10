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

        // Check if the city is present in the list before deletion
        assertTrue(list.hasCity(cityToDelete));

        // Delete the city from the list
        list.delete(cityToDelete);

        // Check if the city is no longer present in the list
        assertFalse(list.hasCity(cityToDelete));

        // Check if the size of the list has decreased by 1 after deletion
        assertEquals(listSizeBeforeDeletion - 1, list.getCount());

        // Check if an exception is thrown if we try to delete the same city again
        assertThrows(IllegalArgumentException.class, () -> {
            list.delete(cityToDelete);
        });
    }
}
