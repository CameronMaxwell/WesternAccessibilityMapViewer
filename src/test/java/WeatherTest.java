package com.cameronmaxwell.westernmapviewer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Weather class
 * 
 * @author Cameron Maxwell
 */
public class WeatherTest {

    /**
     * Test of updateData method, of class Weather.
     */
    @Test
    public void testUpdateData() throws Exception {
        System.out.println("updateData");
        // create a new instance of the weather class and call updateData on it
        Weather instance = new Weather();
        instance.updateData();
        // if any variables are empty, updateWeather fails
        assertNotNull(Weather.temp);
        assertNotNull(Weather.conditions);
        assertNotNull(Weather.icon);
    }
}
