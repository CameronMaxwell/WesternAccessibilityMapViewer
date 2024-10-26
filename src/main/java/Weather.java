package com.cameronmaxwell.westernmapviewer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONObject;


/**
 * Weather class. Pulls read-time data from WeatherAPI.com for London, Ontario
 * and stores the data in global variables accessible from everywhere in the project.
 * 
 * @version 1.0
 * @author Cameron Maxwell
 */
public class Weather {
    
    /** URL to get data */
    private String url = "http://api.weatherapi.com/v1/current.json?key=2b322522870b49c3b69222230233003&q=43.01032824660111,-81.27455336792043&aqi=no\n";

    /** global variables for current temp, conditions, and weather icon */
    public static String temp, conditions, icon;
 
    /**
     * updateData method. Updates/refreshes the weather data from the weather API.
     * 
     */
    public void updateData() {
        try {    
            // creates a new URL object
            URL weatherURL = new URL(url);
            // create new reader
            BufferedReader input = new BufferedReader(
            new InputStreamReader(weatherURL.openStream()));
            // read weather from input
            String rawWeatherString = input.readLine();;
            // close reader
            input.close();
            // create JSONObjects corresponding to the JSON given by the API
            JSONObject weatherJSON = new JSONObject(rawWeatherString);
            JSONObject currentJSON = weatherJSON.getJSONObject("current");
            JSONObject conditionJSON = currentJSON.getJSONObject("condition");
            // set the variables for temp, conditions, and icon to the data from the API call
            this.temp = String.valueOf(currentJSON.getInt("temp_c")) + "\u00B0" + "C";
            this.conditions = conditionJSON.getString("text");
            this.icon = conditionJSON.getString("icon");
        // catch potential error and change variables accordingly
        } catch (MalformedURLException e) { 
            this.temp = "N/A";
            this.conditions = "No Internet Connection";
            this.icon = null;
        } catch (IOException e) {
            this.temp = "N/A";
            this.conditions = "No Internet Connection";
            this.icon = null;
        }
    }
}