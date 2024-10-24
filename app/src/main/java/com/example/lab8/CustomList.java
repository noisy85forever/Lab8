package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    /**
     * this gets size of the list * @return
     */
    public int getCount(){
        return cities.size();
    }

    /**
     * this adds a city object to the list *the second phase, you can add the city * @param city
     */
    public void addCity(City city){
        cities.add(city);
    }

    /**
     * This method tells the user if the city list contains a city
     * @param city
     *      A city to test whether or not it is in the list
     * @return
     *      Returns boolean of whether or not the city is in the list
     */
    public Boolean hasCity(City city) {
        if (cities.contains(city)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * Deletes a city from the city list if the city exists
     * @param city
     *      The city to be deleted
     */
    public void deleteCity(City city) {
        if (cities.contains(city)) {
            cities.remove(city);
        }
    }

    /**
     * Counts the number of cities in the list
     * @return
     *      Returns the number of cities in the city list
     */
    public int countCities() {
        return cities.size();
    }

}
